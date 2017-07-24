package tk.trocagame.trocagame.model;

/**
 * Created by primetwo on 22-07-2017.
 */

public class Oferta {

    private int id;
    private int id_jogo;
    private String estado_jogo;
    private String ano_compra;
    private int id_dono;
    private String data_cadastro_sistema;

    public Oferta(){
        this.id=0;
        this.id_jogo=0;
        this.estado_jogo=null;
        this.ano_compra=null;
        this.id_dono=0;
        this.data_cadastro_sistema=null;

    }

    public Oferta(int id, int id_jogo, String estado_jogo, String ano_compra, int id_dono, String data_cadastro_sistema){
        this.id=id;
        this.id_jogo=id_jogo;
        this.estado_jogo=estado_jogo;
        this.ano_compra=ano_compra;
        this.id_dono=id_dono;
        this.data_cadastro_sistema=data_cadastro_sistema;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(int id_jogo) {
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

    public int getId_dono() {
        return id_dono;
    }

    public void setId_dono(int id_dono) {
        this.id_dono = id_dono;
    }

    public String getData_cadastro_sistema() {
        return data_cadastro_sistema;
    }

    public void setData_cadastro_sistema(String data_cadastro_sistema) {
        this.data_cadastro_sistema = data_cadastro_sistema;
    }
}
