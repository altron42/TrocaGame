package tk.trocagame.trocagame.view;

import android.os.Bundle;
import android.app.Activity;

import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.utils.LocalStorage;

public class JogoActivity extends Activity {

    private Jogo jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        jogo = LocalStorage.getInstance(this).getObject(LocalStorage.JOGO_CLICADO,Jogo.class);
    }

}
