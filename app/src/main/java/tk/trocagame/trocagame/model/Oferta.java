package tk.trocagame.trocagame.model;

/**
 * Created by primetwo on 22-07-2017.
 */

public class Oferta {

    private long id;
    private long id_dono;
    private String nome_usuario;
    private String foto_uri;
    private long id_jogo;
    private String estado_jogo;
    private String ano_compra;
    private String data_cadastro_sistema;

    public Oferta() {
    }

    public Oferta(long id_jogo) {
        this.id_jogo = id_jogo;
    }

    public Oferta(long id, long id_dono, String nome_usuario, String foto_uri, long id_jogo, String estado_jogo, String ano_compra, String data_cadastro_sistema) {
        this.id = id;
        this.id_dono = id_dono;
        this.nome_usuario = nome_usuario;
        this.foto_uri = foto_uri;
        this.id_jogo = id_jogo;
        this.estado_jogo = estado_jogo;
        this.ano_compra = ano_compra;
        this.data_cadastro_sistema = data_cadastro_sistema;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_dono() {
        return id_dono;
    }

    public void setId_dono(long id_dono) {
        this.id_dono = id_dono;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getFoto_uri() {
        return foto_uri;
    }

    public void setFoto_uri(String foto_uri) {
        this.foto_uri = foto_uri;
    }

    public long getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(long id_jogo) {
        this.id_jogo = id_jogo;
    }

    public String getEstado_jogo() {
        return estado_jogo;
    }

    public void setEstado_jogo(String estado_jogo) {
        this.estado_jogo = estado_jogo;
    }

    public String getAno_compra() {
        return ano_compra;
    }

    public void setAno_compra(String ano_compra) {
        this.ano_compra = ano_compra;
    }

    public String getData_cadastro_sistema() {
        return data_cadastro_sistema;
    }

    public void setData_cadastro_sistema(String data_cadastro_sistema) {
        this.data_cadastro_sistema = data_cadastro_sistema;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", id_dono=" + id_dono +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", foto_uri='" + foto_uri + '\'' +
                ", id_jogo=" + id_jogo +
                ", estado_jogo='" + estado_jogo + '\'' +
                ", ano_compra='" + ano_compra + '\'' +
                ", data_cadastro_sistema='" + data_cadastro_sistema + '\'' +
                '}';
    }
}
