package tk.trocagame.trocagame.view;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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
import tk.trocagame.trocagame.adapter.CommentRecyclerAdapter;
import tk.trocagame.trocagame.utils.LocalStorage;

public class JogoActivity extends Activity {

    private static final String TAG = JogoActivity.class.getName();

    private Jogo jogo;
    private ImageView capa_jogo;
    private TextView titulo;
    private TextView descricao;
    private TextView genero;
    private TextView ano_lancamento;
    private TextView produtor;
    private TextView distribuidor;

    private List<Comentario> mCommentList = new ArrayList<>();
    private RecyclerView commentRecyclerView;
    private CommentRecyclerAdapter cSetAdapter;

    private ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        mApiService = ApiUtils.getApiService();


        jogo = LocalStorage.getInstance(this).getObject(LocalStorage.JOGO_CLICADO, Jogo.class);

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


        Button btnOferta = (Button) findViewById(R.id.button_oferta);
        btnOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOfertaActivity(jogo);
            }
        });


        Glide.with(this)
                .load(jogo.getImageUri())
                .placeholder(R.drawable.trocagame_progess_orange)
                .into(capa_jogo);


        Button btnTrocar = (Button) findViewById(R.id.button_trocar);
        btnTrocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTrocaActivity();
            }
        });

        commentRecyclerView = (RecyclerView) findViewById(R.id.rv_jogo_comentario);

        if (mCommentList.isEmpty()) {
            buscaComentarios();
        }

        cSetAdapter = new CommentRecyclerAdapter(mCommentList);
        
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,true);

        commentRecyclerView.setHasFixedSize(true);
        commentRecyclerView.setLayoutManager(mLayoutManager1);
        commentRecyclerView.setItemAnimator(new DefaultItemAnimator());
        commentRecyclerView.setAdapter(cSetAdapter);
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

    public void openOfertaActivity(Jogo jogo) {
        if (jogo != null) {
//            LocalStorage.getInstance(this).addToStorage(LocalStorage.JOGO_CLICADO, jogo);
            Intent intent = new Intent(this,OfertaActivity.class);
            this.startActivity(intent);
        } else {
            Toast.makeText(this,"Erro, objeto jogo = null",Toast.LENGTH_SHORT).show();
        }
    }

    private void buscaComentarios() {
        mApiService.buscaComentariosPorId(jogo).enqueue(new Callback<List<Comentario>>() {
            @Override
            public void onResponse(Call<List<Comentario>> call, Response<List<Comentario>> response) {
                if (response.isSuccessful()) {
                    populateDataSet(response.body());
                } else {
                    Log.e(TAG, "RESPONSE ERROR CODE: " + response.code() + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Comentario>> call, Throwable t) {

            }
        });
    }

    private void populateDataSet(List<Comentario> response) {
        if (response.isEmpty()) {
            Toast.makeText(this,"Nao ha comentarios",Toast.LENGTH_SHORT).show();
        } else {
            mCommentList.clear();
            mCommentList.addAll(response);
            cSetAdapter.notifyDataSetChanged();
        }
    }
}
