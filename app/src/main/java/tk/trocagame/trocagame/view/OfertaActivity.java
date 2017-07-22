package tk.trocagame.trocagame.view;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import tk.trocagame.trocagame.R;

public class OfertaActivity extends Activity {

    TextView text_title;
    EditText ano_compra;
    EditText estado_jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_oferta );

        text_title = (TextView) findViewById(R.id.textView_title);
        ano_compra = (EditText) findViewById(R.id.editText_ano_compra);
        estado_jogo = (EditText) findViewById(R.id.editText_estado_jogo);



    }




//    public Oferta(int id, int id_jogo, String estado_jogo, String ano_compra, int id_dono, String data_cadastro_sistema){
//        this.id=id;
//        this.id_jogo=id_jogo;
//        this.estado_jogo=estado_jogo;
//        this.ano_compra=ano_compra;
//        this.id_dono=id_dono;
//        this.data_cadastro_sistema=data_cadastro_sistema;
//
//    }
}
