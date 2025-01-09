package conexion;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;

/**
 *
 * @author caill
 */
public class Conexion {

    // Establece la conexión a la base de datos
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/bd_estudiojuridico?useSSL=false&allowPublicKeyRetrieval=true";
        String usuario = "root";
        String contraseña = "admin";

        try {
            Connection cn = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión establecida con éxito.");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexión local: " + e.getMessage());
        }
        return null;
    }

    // Método para obtener la conexión (si es necesario)
    public static Connection getConexion() {
        // Lógica si se necesita obtener una conexión de alguna otra fuente, si no, se puede eliminar
        return conectar(); // Por ejemplo, aquí lo puedes usar para llamar al método conectar()
    }
}
