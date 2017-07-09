package tk.trocagame.trocagame.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import tk.trocagame.trocagame.model.ResultStatus;
import tk.trocagame.trocagame.model.Usuario;

/**
 * Created by micael on 6/16/17.
 *
 * Essa e' a interface que tem os metodos que vao ser usados para
 * fazer as requisoçoes para para o servidor.
 *
 * Usar @POST quando for preciso enviar dados para o servidor
 * Usar @GET quando for preciso apenas receber dados do servidor
 *
 * A classe do metodo e' o tipo que a resposta do servidor vai ser
 * depois que os parses forem feitos.
 *
 */

public interface ApiService {

    @Headers( "Content-Type: application/json" )
    @POST("usuario/verifica_login")
    Call<List<Usuario>> verificaLogin(@Body Usuario usuario);

    @Headers( "Content-Type: application/json" )
    @POST("usuario/cadastra_usuario")
    Call<ResultStatus> novoUsuario(@Body Usuario usuario);

    @Headers( "Content-Type: application/json" )
    @POST("usuario/altera_usuario")
    Call<ResultStatus> updateUsuario(@Body Usuario usuario);
    
}
