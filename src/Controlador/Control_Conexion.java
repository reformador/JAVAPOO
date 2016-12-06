package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Control_Conexion {
    //Atributos 
    private String url;
    private String usuario;
    private String password;
    //Atributo de tipo Conexion
    Connection con=null;

    //Constructor
    public Control_Conexion() {
        //Inicializar los atributos de conexion
        this.url="jdbc:mysql://127.0.0.1/museosoft";
        this.usuario="miusuario";
        this.password="123456";
    }
    //Métodos
    //1 - Conectar
        public void conectar(){
        try {
            //Llamar al driver de conexion
            Class.forName("com.mysql.jdbc.Driver");
            //Establecer la conexion al servidor
            con=DriverManager.getConnection(url,usuario,password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Control_Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    //2 - Desconectar
        public void cerrar(){
            con=null;
        }
    //3 - Estado
        public Connection estado(){
            return con;
        }
}
