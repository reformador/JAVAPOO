package Modelo;
public class Autores {
    private int aut_cod;
    private String aut_nom;
    private String aut_fnac;
    private String aut_fdef;

    //Constructores
    public Autores() {
    }

    public Autores(String aut_nom) {
        this.aut_nom = aut_nom;
    }

    
    public Autores(int aut_cod, String aut_nom) {
        this.aut_cod = aut_cod;
        this.aut_nom = aut_nom;
    }
    
    
    public Autores(int aut_cod, String aut_nom, String aut_fnac, String aut_fdef) {
        this.aut_cod = aut_cod;
        this.aut_nom = aut_nom;
        this.aut_fnac = aut_fnac;
        this.aut_fdef = aut_fdef;
    }

    //Mutadores
    public int getAut_cod() {
        return aut_cod;
    }

    public void setAut_cod(int aut_cod) {
        this.aut_cod = aut_cod;
    }

    public String getAut_nom() {
        return aut_nom;
    }

    public void setAut_nom(String aut_nom) {
        this.aut_nom = aut_nom;
    }

    public String getAut_fnac() {
        return aut_fnac;
    }

    public void setAut_fnac(String aut_fnac) {
        this.aut_fnac = aut_fnac;
    }

    public String getAut_fdef() {
        return aut_fdef;
    }

    public void setAut_fdef(String aut_fdef) {
        this.aut_fdef = aut_fdef;
    }
    //Sobrescritura
    @Override
    public String toString(){
        return aut_nom;
    }
}
