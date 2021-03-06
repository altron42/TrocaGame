package tk.trocagame.trocagame.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import tk.trocagame.trocagame.model.Comentario;
import tk.trocagame.trocagame.model.Console;
import tk.trocagame.trocagame.model.Jogo;
import tk.trocagame.trocagame.model.Oferta;
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
//USUARIO
    @Headers( "Content-Type: application/json" )
    @POST("usuario/verifica_login")
    Call<List<Usuario>> verificaLogin(@Body Usuario usuario);

    @Headers( "Content-Type: application/json" )
    @POST("usuario/cadastra_usuario")
    Call<ResultStatus> novoUsuario(@Body Usuario usuario);

    @Headers( "Content-Type: application/json" )
    @POST("usuario/busca_usuario_por_id")
    Call<List<Usuario>> buscaUsuarioPorId(@Body Usuario usuario);

    @Headers( "Content-Type: application/json" )
    @POST("usuario/altera_usuario")
    Call<ResultStatus> updateUsuario(@Body Usuario usuario);
//JOGO
    @Headers( "Content-Type: application/json" )
    @POST("jogo/busca_jogos_por_console")
    Call<List<Jogo>> buscaJogosConsole(@Body Console console);


//    Chama a função que retorna Comentários por Jogo (Passa o Jogo e recebe
//    uma lista de comentários
    @Headers( "Content-Type: application/json" )
    @POST("comentario/busca_comentario_por_id")
    Call<List<Comentario>> buscaComentariosPorId(@Body Jogo jogo);

    @GET("jogo/busca_all_jogos")
    Call<List<Jogo>> buscaAllJogos();

//OFERTA
    @Headers( "Content-Type: application/json" )
    @POST("oferta/cadastra_oferta")
    Call<ResultStatus> cadastraOferta(@Body Oferta oferta);

    @Headers( "Content-Type: application/json" )
    @POST("oferta/busca_oferta_por_jogo")
    Call<List<Oferta>> buscaOfertasJogo(@Body Oferta oferta);
}
