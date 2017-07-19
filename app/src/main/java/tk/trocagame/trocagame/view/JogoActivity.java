package tk.trocagame.trocagame.view;

import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.utils.GameRecyclerAdapter;
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


        Glide.with(this)
                .load(jogo.getImageUri())
                .into(capa_jogo);

//        Toast.makeText(this, jogo.getDescricao(),Toast.LENGTH_SHORT).show();
    }

}
