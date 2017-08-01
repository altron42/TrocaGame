package tk.trocagame.trocagame.view;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.api.ApiService;
import tk.trocagame.trocagame.api.ApiUtils;
import tk.trocagame.trocagame.model.ResultStatus;
import tk.trocagame.trocagame.model.Usuario;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getName();

    private ApiService mApiService;

    private EditText mNameView;
    private EditText mEmailView;
    private EditText mPhoneView;
    private EditText mPasswordlView;
    private EditText mPassword2View;
    private EditText mBioView;
    private EditText mCepView;
    private EditText mCidadeView;

    private View mRegistrationFormView;

    private String strDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mNameView = (EditText) findViewById(R.id.registration_name);
        mEmailView = (EditText) findViewById(R.id.registration_email);
        mPhoneView = (EditText) findViewById(R.id.registration_phone);
        mPasswordlView = (EditText) findViewById(R.id.registration_password);
        mPassword2View = (EditText) findViewById(R.id.registration_password_2);
        mBioView = (EditText) findViewById(R.id.registration_bio);
        mCepView  = (EditText) findViewById(R.id.registration_cepi);
        mCidadeView = (EditText) findViewById(R.id.registration_cidade);

        mApiService = ApiUtils.getApiService();

        Button mRegisterButton = (Button) findViewById(R.id.registration_submit_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRegistrationForm();
            }
        });

        mRegistrationFormView = findViewById(R.id.registration_form);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPhoneView.addTextChangedListener(new PhoneNumberFormattingTextWatcher() );
        }

        // Set strDate to today's date formated as dd-MM-yyyy
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MM-yyyy");
        strDate = mdformat.format(calendar.getTime());
    }

    private void submitRegistrationForm() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordlView.setError(null);
        mPassword2View.setError(null);
        mNameView.setError(null);

        // Store values at the time of the submit attempt.
        String nome = mNameView.getText().toString();
        String email = mEmailView.getText().toString();
        String phone = mPhoneView.getText().toString();
        String password = mPasswordlView.getText().toString();
        String password2 = mPassword2View.getText().toString();
        String bio = mBioView.getText().toString();
        String cep = mCepView.getText().toString();
        String cidade = mCidadeView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordlView.setError(getString(R.string.error_field_required));
            focusView = mPasswordlView;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            mPasswordlView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordlView;
            cancel = true;
        } else if (!isPasswordEqual(password, password2)) {
            mPassword2View.setError(getString(R.string.error_different_password));
            focusView = mPassword2View;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        // Check for name field.
        if (TextUtils.isEmpty(nome)) {
            mNameView.setError(getString(R.string.error_field_required));
            focusView = mNameView;
            cancel = true;
        }
//        else if (!isNameValid(nome)) {
//            mNameView.setError(getString(R.string.error_invalid_email));
//            focusView = mNameView;
//            cancel = true;
//        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            // showProgress(true);
            cadastraUsuario(new Usuario(0,email,nome,password,bio,strDate,phone, cep, cidade));
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isNameValid(String name) {
        //TODO: Replace this with your own logic
        return name.length() > 4;
    }

    private boolean isPasswordEqual(String password, String password2) {
        return TextUtils.equals(password,password2);
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 3;
    }

    private void cadastraUsuario(Usuario usuario) {
        Call<ResultStatus> call = mApiService.novoUsuario(usuario);

        call.enqueue(new Callback<ResultStatus>() {
            @Override
            public void onResponse(Call<ResultStatus> call, Response<ResultStatus> response) {
                Log.i(TAG,"CADASTRO ENVIADO. " + response.body());
                if (response.body().getStatus()) {
                    Log.i(TAG,"Cadastrado com sucesso. " + response.body().toString());
                    terminateActivity();
                } else {
                    Log.i(TAG,"Usuario ja existe. " + response.body().toString());
                    mEmailView.setError("Usuario ja existe");
                    mEmailView.requestFocus();
                }
            }

            @Override
            public void onFailure(Call<ResultStatus> call, Throwable t) {
                Log.e(TAG, "Ocorreu algum erro. " + t.getMessage());
            }
        });

    }

    private void terminateActivity() {
        this.finish();
    }
}