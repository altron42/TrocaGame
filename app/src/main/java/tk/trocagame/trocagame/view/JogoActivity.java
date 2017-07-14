package tk.trocagame.trocagame.view;

import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
    private EditText titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        jogo = LocalStorage.getInstance(this).getObject(LocalStorage.JOGO_CLICADO,Jogo.class);

        capa_jogo = (ImageView) findViewById(R.id.view_image_game);
        titulo = (Tex) findViewById(R.id.text_title);

        Glide.with(this)
                .load(jogo.getImageUri())
                .into(capa_jogo);

        titulo.setText(jogo.getNome());
        titulo.setKeyListener(null);

        Toast.makeText(this, jogo.getDescricao(),Toast.LENGTH_SHORT).show();
    }

}
