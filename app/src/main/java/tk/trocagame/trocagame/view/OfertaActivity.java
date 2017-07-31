package tk.trocagame.trocagame.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.api.ApiService;
import tk.trocagame.trocagame.api.ApiUtils;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.model.Oferta;
import tk.trocagame.trocagame.model.ResultStatus;
import tk.trocagame.trocagame.model.Usuario;
import tk.trocagame.trocagame.utils.LocalStorage;

import static android.content.ContentValues.TAG;

public class OfertaActivity extends Activity {
    private ApiService mApiService;
    Button btn_ofertar;
    Jogo jogo;
    Usuario usuario;
    TextView text_title;
    EditText ano_compra;
    EditText estado_jogo;
    ImageView imagem_oferta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_oferta );
        mApiService = ApiUtils.getApiService();

        jogo = LocalStorage.getInstance(this).getObject(LocalStorage.JOGO_CLICADO,Jogo.class);
        usuario = LocalStorage.getInstance(this).getObject(LocalStorage.ACTIVE_USER, Usuario.class);

        imagem_oferta = (ImageView) findViewById( R.id.imageView_oferta );
        text_title = (TextView) findViewById(R.id.textView_title);
        text_title.setText("Ofertar "+jogo.getNome());
        ano_compra = (EditText) findViewById(R.id.editText_ano_compra);
        estado_jogo = (EditText) findViewById(R.id.editText_estado_jogo);



        Glide.with(this)
                .load(jogo.getImageUri())
                .into(imagem_oferta);

        btn_ofertar = (Button) findViewById(R.id.button_ofertar);
        btn_ofertar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                enviaOferta();
            }
        });

    }

    public void enviaOferta(){
        // Set strDate to today's date formated as dd-MM-yyyy
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = mdformat.format( calendar.getTime() );

        Oferta oferta = new Oferta();
        oferta.setId_jogo((int) jogo.getId());
        oferta.setEstado_jogo(estado_jogo.getText().toString());
        oferta.setAno_compra(ano_compra.getText().toString());
        oferta.setId_dono((int) usuario.getId());
        oferta.setData_cadastro_sistema(strDate);

        Call<ResultStatus> call = mApiService.cadastraOferta(oferta);
        Toast.makeText(getApplicationContext(), "Oferta Cadastrada com Sucesso!!",Toast.LENGTH_SHORT).show();
        finish();
        call.enqueue(new Callback<ResultStatus>() {
            @Override
            public void onResponse(Call<ResultStatus> call, Response<ResultStatus> response) {
                Log.i(TAG,"CADASTRO ENVIADO. " + response.body());
                Toast.makeText(getApplicationContext(), "RESPOSTA "+response.body(),Toast.LENGTH_SHORT).show();
                if (response.body().getStatus()) {
                    Log.i(TAG,"Cadastrado com sucesso. " + response.body().toString());
                    Toast.makeText(getApplicationContext(), "Oferta Cadastrada com Sucesso!!",Toast.LENGTH_SHORT).show();
                    this.notify();

                } else {
                    Log.i(TAG,"Erro ao cadastrar oferta, tente novamente mais tarde. " + response.body().toString());

                }
            }

            @Override
            public void onFailure(Call<ResultStatus> call, Throwable t) {
                Log.e(TAG, "Ocorreu algum erro. " + t.getMessage());
            }
        });

    }
}
