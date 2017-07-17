package tk.trocagame.trocagame.model;

/**
 * Created by micael on 7/12/17.
 */

public class Console {
    public static final int PS4 = 1;
    public static final int PS3 = 2;
    public static final int XBOX360 = 3;
    public static final int XBOXONE = 4;
    public static final int WII = 5;
    public static final int SWITCH = 6;

    public static final String ID = "id";
    public static final String NOME_CONSOLE = "nome_console";
    public static final String ANO_LANCAMENTO = "ano_lancamento";
    public static final String DESCRICAO = "descricao";

    private int id;
    private String nome_console;
    private String ano_lancamento;
    private String descricao;

    public Console(int id) {
        this.id = id;
    }

    public Console(int id, String nome_console, String ano_lancamento, String descricao) {
        this.id = id;
        this.nome_console = nome_console;
        this.ano_lancamento = ano_lancamento;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_console() {
        return nome_console;
    }

    public void setNome_console(String nome_console) {
        this.nome_console = nome_console;
    }

    public String getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(String ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
