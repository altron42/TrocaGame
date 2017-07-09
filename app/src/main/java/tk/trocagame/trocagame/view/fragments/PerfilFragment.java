package tk.trocagame.trocagame.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.api.ApiService;
import tk.trocagame.trocagame.api.ApiUtils;
import tk.trocagame.trocagame.model.ResultStatus;
import tk.trocagame.trocagame.model.Usuario;
import tk.trocagame.trocagame.utils.LocalStorage;
import tk.trocagame.trocagame.view.RegisterActivity;


public class PerfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = RegisterActivity.class.getName();
    private ApiService mApiService;

    private String name;
    private String email;
    private String dercricao;
    private String phone;
    private String password;

    private EditText mNameView;
    private EditText mEmailView;
    private EditText mPhoneView;
    private EditText mPasswordlView;
    private EditText mBioView;
    private Usuario usuario;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Perfil");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);
        mApiService = ApiUtils.getApiService();

         usuario = LocalStorage.getInstance(rootView.getContext()).getObject(LocalStorage.ACTIVE_USER, Usuario.class);

        // Ate aqui esta funcionando.
        Log.i("NOME DO USUARIO: ", usuario.getNome());

        /*
         * Depois daqui da crash.
         * Provavelmente nao esta conseguindo encontrar a ID do textView
         * Verificar e corrigir os textViews no xml desse fragment
        */
        mNameView = (EditText) rootView.findViewById(R.id.text_nome);
        mNameView.setText(usuario.getNome());
        mEmailView = (EditText) rootView.findViewById(R.id.text_login);
        mEmailView.setText(usuario.getLogin());
        mBioView = (EditText) rootView.findViewById(R.id.text_descricao);
        mBioView.setText(usuario.getDescricao());
        mPhoneView = (EditText) rootView.findViewById(R.id.text_phone);
        mPhoneView.setText(usuario.getTelefone());
        mPasswordlView = (EditText) rootView.findViewById(R.id.text_password);
        mPasswordlView.setText(usuario.getSenha());

        Button mUpdateButton = (Button) rootView.findViewById(R.id.update_data_user_button);
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRegistrationForm();
            }
        });

        return rootView;
    }


    private void submitRegistrationForm() {


    // Store values at the time of the submit attempt.
    String nome = mNameView.getText().toString();
    String email = mEmailView.getText().toString();
    String phone = mPhoneView.getText().toString();
    String password = mPasswordlView.getText().toString();
    String bio = mBioView.getText().toString();


    // Reset errors.
        mNameView.setError(null);
        mPasswordlView.setError(null);


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
        } else if (!isNameValid(nome)) {
            mNameView.setError(getString(R.string.error_invalid_email));
            focusView = mNameView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            // showProgress(true);
            cadastraUsuario(new Usuario(0,email,nome,password,bio,usuario.getData(),phone));
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
        this.terminateActivity();
    }

}