package tk.trocagame.trocagame.view;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.model.Oferta;
import tk.trocagame.trocagame.model.Usuario;
import tk.trocagame.trocagame.utils.LocalStorage;

public class OfertaActivity extends Activity {

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

        jogo = LocalStorage.getInstance(this).getObject(LocalStorage.JOGO_CLICADO,Jogo.class);
        usuario = LocalStorage.getInstance(this).getObject(LocalStorage.ACTIVE_USER, Usuario.class);

        imagem_oferta = (ImageView) findViewById( R.id.imageView_oferta );
        text_title = (TextView) findViewById(R.id.textView_title);
        text_title.setText("Oferta para "+jogo.getNome());
        ano_compra = (EditText) findViewById(R.id.editText_ano_compra);
        estado_jogo = (EditText) findViewById(R.id.editText_estado_jogo);


        Glide.with(this)
                .load(jogo.getImageUri())
                .into(imagem_oferta);


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
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

    }
}
