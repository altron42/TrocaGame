package tk.trocagame.trocagame.utils;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.api.ApiService;
import tk.trocagame.trocagame.api.ApiUtils;
import tk.trocagame.trocagame.model.Comentario;
import tk.trocagame.trocagame.model.Usuario;
import tk.trocagame.trocagame.view.JogoActivity;
import tk.trocagame.trocagame.view.LoginActivity;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_SHORT;
import static tk.trocagame.trocagame.R.string.error_incorrect_login;

/**
 * Created by primetwo on 19-07-2017.
 */

public class Adapter_comentario extends ArrayAdapter<Comentario> {
    private ApiService mApiService;


    private final Context context;
    private final ArrayList<Comentario> comentarios;
    private Usuario usuario;
    private View mProgressView;


    public Adapter_comentario(Context context, ArrayList<Comentario> comentarios) {
        super(context, R.layout.linha_comentario, comentarios);
        this.context = context;
        this.comentarios = comentarios;
    }

    public View getView(int position, View converView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_comentario, parent, false);
        usuario = LocalStorage.getInstance(this.getContext()).getObject(LocalStorage.ACTIVE_USER, Usuario.class);
        mApiService = ApiUtils.getApiService();
        final TextView nomeDonoMensagem = (TextView) rowView.findViewById(R.id.nome_dono_mensagem);
        TextView dataMensagem = (TextView) rowView.findViewById(R.id.data_mensagem);
        TextView textMensagem = (TextView) rowView.findViewById(R.id.text_mensagem);

        mApiService.buscaUsuarioPorId(new Usuario(comentarios.get(position).getId_dono())).enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful()) {

                    Log.i( TAG, "POST enviado para API. " + response.body() );
                    if (response.body().isEmpty()) {
                        Log.i( TAG, "Erro na busca do usuario do comentario" );
                    } else {
                        Usuario usuario = response.body().get( 0 );
                        nomeDonoMensagem.setText( usuario.getNome() );
                    }
                } else {
                    Log.e( TAG, "RESPONSE ERROR CODE: " + response.code() + response.raw() );
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {

            }
        });


        dataMensagem.setText(comentarios.get(position).getData());
        textMensagem.setText(comentarios.get(position).getMensagem());

        return rowView;

    }
}
