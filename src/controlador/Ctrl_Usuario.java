package controlador;

import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;

/**
 *
 * @author caill
 */
public class Ctrl_Usuario {

    // Método para iniciar sesión
    public boolean login(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql = "SELECT usuario FROM tb_usuario WHERE usuario = ? AND contrasena = SHA2(?, 256)";
        //String sql = "SELECT usuario, contrasena FROM tb_usuario WHERE usuario = ? AND contrasena = ?";

        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            // Asignar los valores a los parámetros
            pst.setString(1, objeto.getUsuario());
            pst.setString(2, objeto.getContrasena());

            // Ejecutar la consulta
            ResultSet rs = pst.executeQuery();

            // Si existe un registro, el inicio de sesión es válido
            if (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e);
        }

        return respuesta;
    }
}


