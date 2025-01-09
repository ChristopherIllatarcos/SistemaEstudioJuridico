package controlador;

import conexion.Conexion;
import modelo.Abogado;
import java.sql.*;

/**
 *
 * @author caill
 */
public class Ctrl_Abogado {

    public boolean Guardar(Abogado objeto) {
        boolean respuesta = false;

        String sql = "INSERT INTO tb_abogados(nombre, especialidad, contacto) VALUES(?,?,?)";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {

            // Configurar los parámetros
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getEspecialidad());
            consulta.setString(3, objeto.getContacto());

            // Ejecutar la consulta
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            // Manejo de errores
            System.err.println("Error al guardar nombre del abogado: " + e.getMessage());
        }

        return respuesta;
    }

    // Método para consultar si existe el abogado
    public boolean existeAbogado(String abogado) {
        boolean respuesta = false;
        String sql = "SELECT nombre FROM tb_abogados WHERE nombre = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {

            // Configurar el parámetro
            pst.setString(1, abogado);

            // Ejecutar la consulta
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    respuesta = true;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar el nombre del abogado: " + e.getMessage());
        }

        return respuesta;
    }

    //METODO PARA ACTUALIZAR
    public boolean actualizar(Abogado objeto, int idAbogado) {
        boolean respuesta = false;
        String sql = "UPDATE tb_abogados SET nombre = ?, especialidad = ?, contacto = ? WHERE id_abogado = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {

            // Configurar parámetros de la consulta
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getEspecialidad());
            consulta.setString(3, objeto.getContacto());
            consulta.setInt(4, idAbogado);

            // Ejecutar la consulta y verificar el resultado
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar datos del abogado: " + e.getMessage());
        }
        return respuesta;
    }

    //METODO PARA ELIMINAR
    public boolean eliminar(int idAbogado) {
        boolean respuesta = false;
        String sql = "DELETE FROM tb_abogados WHERE id_abogado = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {

            // Configurar el parámetro de la consulta
            consulta.setInt(1, idAbogado);

            // Ejecutar la consulta y verificar el resultado
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar datos del Abogado: " + e.getMessage());
        }

        return respuesta;
    }

    // Método para obtener el ID del abogado por su nombre
    public int obtenerIdAbogadoPorNombre(String nombreAbogado) {
        int idAbogado = 0;
        Connection cn = Conexion.conectar();
        String sql = "SELECT id_abogado FROM tb_abogados WHERE nombre = ?";
        PreparedStatement ps;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombreAbogado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idAbogado = rs.getInt("id_abogado");
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del abogado: " + e.getMessage());
        }

        return idAbogado;
    }


    public Abogado obtenerAbogadoPorId(int idAbogado) {
        if (idAbogado <= 0) {
            System.out.println("ID del abogado no es válido: " + idAbogado);
            return null;  // Devolver null si el ID no es válido
        }
        Abogado abogado = null;
        String sql = "SELECT * FROM tb_abogados WHERE id_abogado = ?";  // Consulta que obtiene el abogado por ID

        try (Connection cn = Conexion.getConexion(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, idAbogado);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Crear un objeto Abogado con los resultados de la consulta
                    abogado = new Abogado(
                            rs.getInt("id_abogado"),
                            rs.getString("nombre"),
                            rs.getString("especialidad"),
                            rs.getString("contacto")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el abogado por ID: " + e.getMessage());
        }

        return abogado;
    }

}
