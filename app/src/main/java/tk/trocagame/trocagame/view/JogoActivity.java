package tk.trocagame.trocagame.view;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.api.ApiService;
import tk.trocagame.trocagame.api.ApiUtils;
import tk.trocagame.trocagame.model.Comentario;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.model.Usuario;
import tk.trocagame.trocagame.utils.Adapter_comentario;
import tk.trocagame.trocagame.utils.LocalStorage;

import static android.content.ContentValues.TAG;

public class JogoActivity extends Activity {

    private Jogo jogo;
    private ImageView capa_jogo;
    private TextView titulo;
    private TextView descricao;
    private TextView genero;
    private TextView ano_lancamento;
    private TextView produtor;
    private TextView distribuidor;
    private ListView lv_comentarios;
    private ApiService mApiService;
    private Usuario usuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        jogo = LocalStorage.getInstance(this).getObject(LocalStorage.JOGO_CLICADO,Jogo.class);

        capa_jogo = (ImageView) findViewById(R.id.view_image_game);
        titulo = (TextView) findViewById(R.id.text_title);
        descricao = (TextView) findViewById(R.id.text_description);
        titulo.setText(jogo.getNome());
        descricao.setText(jogo.getDescricao());
        genero = (TextView) findViewById(R.id.text_genero);
        genero.setText(jogo.getGenero());
        ano_lancamento = (TextView) findViewById(R.id.text_ano_lancamento);
        ano_lancamento.setText(jogo.getAno_lancamento());
        produtor = (TextView) findViewById(R.id.text_produtor);
        produtor.setText(jogo.getProdutor());
        distribuidor = (TextView) findViewById(R.id.text_distribuidor);
        distribuidor.setText(jogo.getDistribuidor());
        lv_comentarios = (ListView) findViewById(R.id.lv_comentarios);


        Glide.with(this)
                .load(jogo.getImageUri())
                .into(capa_jogo);

//        Toast.makeText(this, jogo.getDescricao(),Toast.LENGTH_SHORT).show();


        Button mEmailSignInButton = (Button) findViewById(R.id.button_trocar);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTrocaActivity();
            }
        });

        ArrayList<Comentario> mensagens = adicionaMensagens();
        ArrayAdapter adapter = new Adapter_comentario( this, adicionaMensagens());
//        lv_mensagens
    }
    private ArrayList<Comentario> adicionaMensagens() {
//        jogo = LocalStorage.getInstance(this).getObject(LocalStorage.ACTIVE_USER, Usuario.class);
//        mApiService = ApiUtils.getApiService();


        ArrayList<Comentario> comentarios= new ArrayList<Comentario>(  );
        Comentario comentario = new Comentario(1, 1, 180,5, "24-24-2017", "Foda esse Game");
        comentarios.add( comentario );
        comentario = new Comentario(2, 2, 180,2, "24-24-2017", "Foda esse Game2");
        comentarios.add( comentario );

        return comentarios;

//        mApiService.buscaComentariosPorId(new Jogo(jogo.getId())).enqueue(new Callback<List<Comentario>>() {
//            @Override
//            public void onResponse(Call<List<Comentario>> call, Response<List<Comentario>> response) {
//                if (response.isSuccessful()) {
//
//                    Log.i( TAG, "POST enviado para API. " + response.body() );
//                    if (response.body().isEmpty()) {
//                        Log.i( TAG, "Erro na busca do usuario do comentario" );
//                    } else {
//                        Usuario usuario = response.body().get( 0 );
//                        nomeDonoMensagem.setText( usuario.getNome() );
//                    }
//                } else {
//                    Log.e( TAG, "RESPONSE ERROR CODE: " + response.code() + response.raw() );
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Usuario>> call, Throwable t) {
//                Log.e(TAG, "Ocorreu algum erro. " + t.getMessage());
//            }
//        });

//        return null;
    }

    public void openTrocaActivity() {
        if (jogo != null) {
//            LocalStorage.getInstance(this).addToStorage(LocalStorage.JOGO_CLICADO, jogo);
            Intent intent = new Intent(this,TrocaActivity.class);
            this.startActivity(intent);
        } else {
            Toast.makeText(this,"Erro, objeto jogo = null",Toast.LENGTH_SHORT).show();
        }
    }
}
