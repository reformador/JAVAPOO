package Controlador;

import Modelo.Autores;
import Modelo.Tipo_Obras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD_Autores {
    //ArrayList
    ArrayList<Autores> datos=new ArrayList<>();
    //Instancia a Control_Conexion
    Control_Conexion con=new Control_Conexion();
    //Leer
    public ArrayList leer(String buscar){
        try {
            //Limpiar ArrayList
            datos.clear();
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement(""
            + "SELECT * FROM Autores WHERE aut_nom LIKE '%"+buscar+"%' ORDER BY aut_nom");
            //Ejecutar consulta sql y representar en formato de tabla
            //Para recorrer filas y columnas y asignarlas a ArrayList
            ResultSet res=sql.executeQuery();
            //Estructura para recorrer res
            while(res.next()){
                //Agregar los datos al ArrayList
                datos.add(new Autores(
                        res.getInt("aut_cod"), 
                        res.getString("aut_nom")));
            }
                  
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TipoObras.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return datos;
    }    
}
