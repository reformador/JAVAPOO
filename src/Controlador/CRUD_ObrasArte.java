package Controlador;

import Modelo.ObrasArte;
import Modelo.Tipo_Obras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD_ObrasArte {
    ArrayList<ObrasArte> datos=new ArrayList<>();
    //Instancia a Control_Conexion
    Control_Conexion con=new Control_Conexion();
    //Leer
    public ArrayList leer(String buscar){
        try {
            //Limpiar ArrayList
            datos.clear();
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement(""
            + "SELECT oa_cod,oa_titulo, oa_fcrea, oa_fing, aut_nom FROM " 
            + " obras_arte INNER JOIN autores ON (obras_arte.aut_cod = autores.aut_cod) " 
            + "INNER JOIN tipo_obras ON (obras_arte.to_cod = tipo_obras.to_cod)");
            //Ejecutar consulta sql y representar en formato de tabla
            //Para recorrer filas y columnas y asignarlas a ArrayList
            ResultSet res=sql.executeQuery();
            //Estructura para recorrer res
            while(res.next()){
                //Agregar los datos al ArrayList
                datos.add(new ObrasArte(res.getInt("oa_cod"), 
                        res.getString("oa_titulo"), 
                        res.getString("oa_fcrea"), 
                        res.getString("oa_fing"), 
                        res.getString("aut_nom")));
            }
                  
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TipoObras.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return datos;
    }
    //Insertar
    public boolean insertar(String titulo, String fcrea, String fingreso, int autor, int tipo){
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement(""
            + "INSERT INTO obras_arte(oa_titulo, oa_fcrea, oa_fing, aut_cod, to_cod) VALUES('"+
                            titulo+"','"+fcrea+"','"+fingreso+"','"+autor+"','"+tipo+"')");
            sql.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TipoObras.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
}
