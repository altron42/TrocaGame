package tk.trocagame.trocagame.model;

/**
 * Created by primetwo on 19-07-2017.
 */

public class Comentario {

    private int id;
    private int id_dono;
    private int id_jogo;
    private int id_console;
    private String data;
    private String mensagem;

    public Comentario(int id, int id_dono, int id_jogo, int id_console, String data, String mensagem){
        this.id = id;
        this.id_dono = id_dono;
        this.id_jogo = id_jogo;
        this.id_console = id_console;
        this.data = data;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dono() {
        return id_dono;
    }

    public void setId_dono(int id_dono) {
        this.id_dono = id_dono;
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

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", id_dono='" + id_dono + '\'' +
                ", id_jogo=" + id_jogo +
                ", id_console='" + id_console + '\'' +
                ", data='" + data + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
