package edu.cibertec.capitulo10.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexion {

    //La URL con la cual nos conectaremos a la base de datos
    private static final String URL = 
            "jdbc:mysql://localhost/sysventa?serverTimezone=UTC";
    //El usuario de la base de datos
    private static final String USUARIO = "root";
    //La clave del usuario de la base de datos
    private static final String CLAVE = "sa";
    //Metodo para obtener la conexion con la base de datos
    public static synchronized Connection getConexion() {
        Connection cn = null;
        try {
            //Cargamos el driver y le decimos que vamos a usar
            //una conexion con mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtenemos la conexion
            cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (Exception e) {
            e.printStackTrace();
            cn = null;
        } finally {
            return cn;
        }
    }

    //Metodo utilizado para cerrar el resulset de datos
    public static synchronized void cerrarResultSet(ResultSet rs) {
        try{rs.close();} catch (Exception e) {}
    }

    //Metodo utilizado para cerrar la conexion
    public static synchronized void cerrarConexion(Connection cn) {
        try{cn.close();} catch (Exception e) {}
    }
    
}
