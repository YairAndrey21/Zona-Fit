package zona_fit.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {

    public static Connection getConnection() {
        Connection conexion = null;
        var baseDatos = "zona_fit_db";
        var usuario = System.getenv("DB_USER");
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var password = System.getenv("DB_PASSWORD");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch (Exception e){
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}


