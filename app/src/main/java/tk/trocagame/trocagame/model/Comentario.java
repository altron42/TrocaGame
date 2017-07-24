package tk.trocagame.trocagame.model;

/**
 * Created by primetwo on 19-07-2017.
 */

public class Comentario {

    private static final String ID = "id";
    private static final String USUARIO = "nome_usuario";
    private static final String ID_JOGO = "id_jogo";
    private static final String ID_CONSOLE = "id_console";
    private static final String DATA = "data";
    private static final String MENSAGEM = "mensagem";
    private static final String FOTO_URI = "foto_uri";

    private int id;
    private String nome_usuario;
    private int id_jogo;
    private int id_console;
    private String data;
    private String mensagem;
    private String foto_uri;

    public Comentario(int id, String nome_usuario, int id_jogo, int id_console, String data, String mensagem, String foto_uri) {
        this.id = id;
        this.nome_usuario = nome_usuario;
        this.id_jogo = id_jogo;
        this.id_console = id_console;
        this.data = data;
        this.mensagem = mensagem;
        this.foto_uri = foto_uri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public int getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(int id_jogo) {
        this.id_jogo = id_jogo;
    }

    public int getId_console() {
        return id_console;
    }

    public void setId_console(int id_console) {
        this.id_console = id_console;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getFoto_uri() {
        return foto_uri;
    }

    public void setFoto_uri(String foto_uri) {
        this.foto_uri = foto_uri;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", id_jogo=" + id_jogo +
                ", id_console=" + id_console +
                ", data='" + data + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", foto_uri='" + foto_uri + '\'' +
                '}';
    }
}
