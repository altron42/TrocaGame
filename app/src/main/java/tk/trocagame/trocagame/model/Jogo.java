package tk.trocagame.trocagame.model;

import android.net.Uri;

/**
 * Created by micael on 6/18/17.
 */

public class Jogo {

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String CONSOLE = "console";
    public static final String DESCRICAO = "descricao";
    public static final String ANO_LANCAMENTO = "ano_lancamento";
    public static final String DISTRIBUIDOR = "distribuidor";
    public static final String PRODUTOR = "produtor";
    public static final String GENERO = "genero";
    public static final String IMAGEM = "src_imagem";

    private long id;
    private String nome;
    private long console;
    private String descricao;
    private String ano_lancamento;
    private String distribuidor;
    private String produtor;
    private String genero;
    private String src_imagem;

    public Jogo(long id, String nome, long console, String descricao,
                String ano_lancamento, String distribuidor, String produtor,
                String genero, String src_imagem) {
        this.id = id;
        this.nome = nome;
        this.console = console;
        this.descricao = descricao;
        this.ano_lancamento = ano_lancamento;
        this.distribuidor = distribuidor;
        this.produtor = produtor;
        this.genero = genero;
        this.src_imagem = src_imagem;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getConsole() {
        return console;
    }

    public void setConsole(long console) {
        this.console = console;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(String ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSrc_imagem() {
        return src_imagem;
    }

    public void setSrc_imagem(String src_imagem) {
        this.src_imagem = src_imagem;
    }

    public Uri getImageUri() {
        return Uri.parse(src_imagem);
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", console=" + console +
                ", descricao='" + descricao + '\'' +
                ", ano_lancamento='" + ano_lancamento + '\'' +
                ", distribuidor='" + distribuidor + '\'' +
                ", produtor='" + produtor + '\'' +
                ", genero='" + genero + '\'' +
                ", src_imagem='" + src_imagem + '\'' +
                '}';
    }
}
