package tk.trocagame.trocagame.model;

/**
 * Created by primetwo on 22-07-2017.
 */

public class Troca {

    private int id;
    private int id_dono_one;
    private int id_jogo_one;
    private int id_dono_two;
    private int id_jogo_two;
    private String data_troca;

    public Troca(int id, int id_dono_one, int id_jogo_one, int id_dono_two, int id_jogo_two, String data_troca ){
        this.id = id;
        this.id_dono_one = id_dono_one;
        this.id_jogo_one = id_jogo_one;
        this.id_dono_two = id_dono_two;
        this.id_jogo_two = id_jogo_two;
        this.data_troca = data_troca;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dono_one() {
        return id_dono_one;
    }

    public void setId_dono_one(int id_dono_one) {
        this.id_dono_one = id_dono_one;
    }

    public int getId_jogo_one() {
        return id_jogo_one;
    }

    public void setId_jogo_one(int id_jogo_one) {
        this.id_jogo_one = id_jogo_one;
    }

    public int getId_dono_two() {
        return id_dono_two;
    }

    public void setId_dono_two(int id_dono_two) {
        this.id_dono_two = id_dono_two;
    }

    public int getId_jogo_two() {
        return id_jogo_two;
    }

    public void setId_jogo_two(int id_jogo_two) {
        this.id_jogo_two = id_jogo_two;
    }

    public String getData_troca() {
        return data_troca;
    }

    public void setData_troca(String data_troca) {
        this.data_troca = data_troca;
    }
}
