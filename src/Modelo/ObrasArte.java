package Modelo;
public class ObrasArte extends Autores{
    //Atributos
    private int oa_cod;
    private String oa_titulo;
    private String oa_fcrea;
    private String oa_fing;

    //Constructores
    public ObrasArte() {
    }

    public ObrasArte(int oa_cod, String oa_titulo, String oa_fcrea, String oa_fing) {
        this.oa_cod = oa_cod;
        this.oa_titulo = oa_titulo;
        this.oa_fcrea = oa_fcrea;
        this.oa_fing = oa_fing;
    }

    public ObrasArte(int oa_cod, String oa_titulo, String oa_fcrea, String oa_fing, String aut_nom) {
        super(aut_nom);
        this.oa_cod = oa_cod;
        this.oa_titulo = oa_titulo;
        this.oa_fcrea = oa_fcrea;
        this.oa_fing = oa_fing;
    }

    
    
    //Mutadores
    public int getOa_cod() {
        return oa_cod;
    }

    public void setOa_cod(int oa_cod) {
        this.oa_cod = oa_cod;
    }

    public String getOa_titulo() {
        return oa_titulo;
    }

    public void setOa_titulo(String oa_titulo) {
        this.oa_titulo = oa_titulo;
    }

    public String getOa_fcrea() {
        return oa_fcrea;
    }

    public void setOa_fcrea(String oa_fcrea) {
        this.oa_fcrea = oa_fcrea;
    }

    public String getOa_fing() {
        return oa_fing;
    }

    public void setOa_fing(String oa_fing) {
        this.oa_fing = oa_fing;
    }
    
}
