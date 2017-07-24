package tk.trocagame.trocagame.view;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.utils.LocalStorage;

public class TrocaActivity extends Activity {
    private Jogo jogo;
    private ImageView imagem_jogo;
    private TextView title_ofertas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troca);

        jogo = LocalStorage.getInstance(this).getObject(LocalStorage.JOGO_CLICADO,Jogo.class);

        imagem_jogo = (ImageView) findViewById(R.id.image_jogo_troca);
        title_ofertas = (TextView) findViewById(R.id.text_title_ofertas);
        title_ofertas.setText("Ofertas para " + jogo.getNome());


        Glide.with(this)
                .load(jogo.getImageUri())
                .into(imagem_jogo);
    }

}
