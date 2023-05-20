package cloud.juanko.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static String url="jdbc:sqlite:G:\\Mi unidad\\SEMESTRE IV\\PROGRAMACION EN AMBIENTE WEB\\javaweb\\base-project-jsf\\base-project-jsf\\empleado.sqlite";
    //private static String url = "jdbc:postgresql://localhost:5432/empleados";

    public static Connection getConnection(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection(url,"postgres","admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
