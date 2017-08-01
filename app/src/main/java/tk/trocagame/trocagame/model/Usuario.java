package tk.trocagame.trocagame.model;

/**
 * Created by micael on 6/15/17.
 */

public class Usuario {

    public static final String ID = "id";
    public static final String LOGIN = "login";
    public static final String NOME = "nome";
    public static final String SENHA = "senha";
    public static final String DESCRICAO = "descricao";
    public static final String DATA = "data_inscricao";
    public static final String FONE = "telefone";

    private long id;
    private String login;
    private String nome;
    private String senha;
    private String descricao;
    private String data_inscricao;
    private String telefone;
    private String cidade;
    private String cep;

    public Usuario(String login, String senha) {
        this(0, login, "", senha, "", "", "","","");
    }
    public Usuario(int id) {
        this(id, "", "", "", "", "", "","","");
    }


    public Usuario(long id, String login, String nome, String senha, String descricao, String data_inscricao,
                   String telefone, String cep, String cidade) {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.descricao = descricao;
        this.data_inscricao = data_inscricao;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data_inscricao;
    }

    public void setData(String data_inscricao) {
        this.data_inscricao = data_inscricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setId(long id) { this.id = id; }

    public String getData_inscricao() { return data_inscricao; }

    public void setData_inscricao(String data_inscricao) { this.data_inscricao = data_inscricao; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) { this.cidade = cidade;}

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data='" + data_inscricao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
