package Controlador;



import Modelo.Usuarios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD_Usuarios {
    //Instanciar clase conexion
    Control_Conexion con=new Control_Conexion();
    
//ArrayList de Usuarios
    ArrayList<Usuarios> datos=new ArrayList<>();
     ArrayList<Usuarios> busqueda = new ArrayList<>();
    
    //constructor
     public CRUD_Usuarios() {    
       
    }

   
    
    //Verificar Usuario
    public String verificar_usuario(String email, String password){
        
        try {
            //Establecer comunicación con el servidor
            con.conectar();
            //Crear la consulta SQL
            PreparedStatement sql=con.estado().prepareStatement(""
            + "SELECT nombreUsuario FROM Usuarios WHERE emailUsuario='"+email+"' AND "
            + "passwordUsuario='"+password+"'");
            //Contenedor de consulta SQL
            ResultSet res=sql.executeQuery();
            if (res.next()) {
                return res.getString("nombreUsuario");
            }
            //Cerrar la conexión
            con.cerrar();
       
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
}
