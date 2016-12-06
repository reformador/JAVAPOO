package Controlador;

import Modelo.Tipo_Obras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD_TipoObras {
    //ArrayList
    ArrayList<Tipo_Obras> datos=new ArrayList<>();
    //Instancia a Control_Conexion
    Control_Conexion con=new Control_Conexion();
    //Leer
    public ArrayList leer(String buscar){
        try {
            //Limpiar ArrayList
            datos.clear();
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement(""
            + "SELECT * FROM Tipo_Obras WHERE to_des LIKE '%"+buscar+"%' ORDER BY to_des");
            //Ejecutar consulta sql y representar en formato de tabla
            //Para recorrer filas y columnas y asignarlas a ArrayList
            ResultSet res=sql.executeQuery();
            //Estructura para recorrer res
            while(res.next()){
                //Agregar los datos al ArrayList
                datos.add(new Tipo_Obras(
                        res.getInt("to_cod"), 
                        res.getString("to_des")));
            }
                  
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TipoObras.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return datos;
    }
    //Insertar
    public boolean insertar(String nombre){
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement(""
            + "INSERT INTO Tipo_Obras(to_des) VALUES('"+nombre+"')");
            sql.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TipoObras.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    //Modificar
    public boolean modificar(int codigo,String nombre){
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement(""
            + "UPDATE Tipo_Obras SET to_des='"+
                    nombre+"' WHERE to_cod='"+codigo+"'");
            sql.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_TipoObras.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    //Eliminar
    public boolean eliminar(int codigo){
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement(""
            + "DELETE FROM Tipo_Obras WHERE to_cod='"+codigo+"'");
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
