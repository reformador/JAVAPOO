package Modelo;
public class Tipo_Obras {
    private int to_cod;
    private String to_des;

    //Constructores
    public Tipo_Obras() {
    }

    public Tipo_Obras(int to_cod, String to_des) {
        this.to_cod = to_cod;
        this.to_des = to_des;
    }

    //Mutadores o Accesadores
    public int getTo_cod() {
        return to_cod;
    }

    public void setTo_cod(int to_cod) {
        this.to_cod = to_cod;
    }

    public String getTo_des() {
        return to_des;
    }

    public void setTo_des(String to_des) {
        this.to_des = to_des;
    }
    //Sobrescritura
    public String toString(){
        return to_des;
    }
}
