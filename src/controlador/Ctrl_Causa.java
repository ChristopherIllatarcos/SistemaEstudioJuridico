package controlador;

import java.sql.*;
import modelo.Causas;
import conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author caill
 */
public class Ctrl_Causa {

    //METODO PARA REGISTRAR CAUSAS 
    public boolean Guardar(Causas causas) {
        String sql = "INSERT INTO tb_causas (tipo, rol, tribunal, fecha, estado, detalle, id_abogado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {

            // Verificación para asegurarse de que los valores no son nulos o vacíos
            if (causas.getTipo() == null || causas.getTipo().isEmpty()
                    || causas.getRol() == null || causas.getRol().isEmpty()
                    || causas.getTribunal() == null || causas.getTribunal().isEmpty()
                    || causas.getFecha() == null || causas.getFecha().isEmpty()
                    || causas.getEstado() == null || causas.getEstado().isEmpty()
                    || causas.getDetalle() == null || causas.getDetalle().isEmpty()) {
                System.out.println("Error: Algunos campos obligatorios están vacíos.");
                return false;
            }

            // Asignación de valores al PreparedStatement
            pst.setString(1, causas.getTipo());
            pst.setString(2, causas.getRol());
            pst.setString(3, causas.getTribunal());
            pst.setString(4, causas.getFecha());
            pst.setString(5, causas.getEstado());
            pst.setString(6, causas.getDetalle());

            // Verificación del id_abogado, si es 0, no es válido
            if (causas.getIdAbogado() <= 0) {
                System.out.println("Error: Abogado no válido.");
                return false;
            }
            pst.setInt(7, causas.getIdAbogado());

            // Ejecutar la inserción y retornar el resultado
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar la causa: " + e.getMessage());
            return false;
        }
    }

    //METODO PARA CONSULTAR SI LA CAUSA YA ESTA REGISTRADO EN LA TABLA   
    public boolean existeCausa(String rol) {
        boolean respuesta = false;
        String sql = "SELECT rol FROM tb_causas WHERE rol = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, rol);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar Causa: " + e);
        }
        return respuesta;
    }

    //METODO PARA ACTUIALIZAR LOS DATOS REGISTRADOS
    public boolean actualizar(Causas objeto, int idCausa, int idAbogado) {
        boolean respuesta = false;
        String sql = "UPDATE tb_causas SET tipo = ?, rol = ?, tribunal = ?, fecha = ?, estado = ?, detalle = ?, id_abogado = ? WHERE id_causa = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {
            // Establecer los parámetros de la consulta
            consulta.setString(1, objeto.getTipo());
            consulta.setString(2, objeto.getRol());
            consulta.setString(3, objeto.getTribunal());
            consulta.setString(4, objeto.getFecha());
            consulta.setString(5, objeto.getEstado());
            consulta.setString(6, objeto.getDetalle());
            consulta.setInt(7, objeto.getIdAbogado());

            // Establecer el id_causa que se va a actualizar
            consulta.setInt(8, idCausa);

            // Ejecutar la actualización
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            } else {
                System.out.println("No se actualizó ningún registro con el ID de causa: " + idCausa);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar causa: " + e.getMessage());
            e.printStackTrace(); // Detallar el error para facilitar el debug
        }
        return respuesta;
    }

    //METODO PARA ELIMINAR UNA CAUSA
    public boolean eliminar(int idCausa) {
        boolean respuesta = false;
        String sql = "DELETE FROM tb_causas WHERE id_causa = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {
            consulta.setInt(1, idCausa);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la Causa registrada: " + e);
        }
        return respuesta;
    }

    //METODO PARA BUSCAR LA CAUSA POR ROL 
    public ArrayList<Causas> BuscarCausaRol(String rol) {
        ArrayList<Causas> listaCausas = new ArrayList<>();
        String sql = "SELECT * FROM tb_causas WHERE 1=1"; // Base de la consulta

        // Condición adicional si se proporciona el rol
        if (rol != null && !rol.isEmpty()) {
            sql += " AND rol LIKE ?";
        }

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {
            int index = 1;

            // Asignar el parámetro del rol si se proporciona
            if (rol != null && !rol.isEmpty()) {
                pst.setString(index++, "%" + rol + "%");
            }

            // Ejecutar la consulta y procesar los resultados
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Causas causas = new Causas();
                    causas.setIdCausa(rs.getInt("id_causa"));
                    causas.setTipo(rs.getString("tipo"));
                    causas.setRol(rs.getString("rol"));
                    causas.setTribunal(rs.getString("tribunal"));
                    causas.setFecha(rs.getString("fecha"));
                    causas.setEstado(rs.getString("estado"));
                    causas.setDetalle(rs.getString("detalle"));
                    causas.setIdAbogado(rs.getInt("id_abogado"));

                    listaCausas.add(causas);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar la causa por rol: " + e.getMessage());
        }

        return listaCausas;
    }

    //METODO PARA OBTENER LA CAUSAS POR ROL 
    public int obtenerIdCausaPorRol(String rol) {
        int idCausa = 0;
        String sql = "SELECT id_causa FROM tb_causas WHERE rol = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setString(1, rol);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                idCausa = rs.getInt("id_causa");
            } else {
                System.out.println("No se encontró ninguna causa con el rol: " + rol);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ID de causa: " + e.getMessage());
        }

        return idCausa;
    }

    // Suponiendo que tienes un método para obtener la conexión a la base de datos
    public Causas obtenerCausaPorRol(String rol) {
        Causas causa = null;
        String sql = "SELECT * FROM tb_causas WHERE rol = ?";  // Consulta que obtiene la causa por el rol

        try (Connection cn = Conexion.getConexion(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, rol);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Crear un objeto Causas con los resultados de la consulta
                    causa = new Causas(
                            rs.getInt("id_causa"),
                            rs.getString("tipo"),
                            rs.getString("rol"),
                            rs.getString("tribunal"),
                            rs.getString("fecha"),
                            rs.getString("estado"),
                            rs.getString("detalle"),
                            rs.getInt("id_abogado")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la causa por rol: " + e.getMessage());
        }

        return causa;
    }
}
