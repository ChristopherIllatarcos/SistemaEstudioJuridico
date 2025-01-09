package controlador;

import java.sql.*;
import modelo.Audiencia;
import conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author caill
 */
public class Ctrl_Audiencia {

    // MÉTODO PARA REGISTRAR AUDIENCIAS
//    public boolean guardar(Audiencia audiencia, int idAbogado) {
//        boolean respuesta = false;
//
//        String sql = "INSERT INTO tb_audiencias (tipo, rol, tribunal, fecha, hora, lugar, estado, observaciones, id_abogado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {
//            pst.setString(1, audiencia.getTipo());
//            pst.setString(2, audiencia.getRol());
//            pst.setString(3, audiencia.getTribunal());
//            pst.setString(4, audiencia.getFecha());
//            pst.setString(5, audiencia.getHora());  // Usar la hora concatenada
//            pst.setString(6, audiencia.getLugar());
//            pst.setString(7, audiencia.getEstado());
//            pst.setString(8, audiencia.getObservaciones());
//            pst.setInt(9, idAbogado);
//
//            // Ejecutar la consulta de inserción
//            if (pst.executeUpdate() > 0) {
//                respuesta = true; // Si se insertó con éxito
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al registrar la audiencia: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return respuesta;
//    }
    
    

    public boolean Guardar(Audiencia audiencia) {
        String sql = "INSERT INTO tb_audiencias (tipo, rol, tribunal, fecha, hora, lugar, estado, observaciones, id_abogado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {

            // Verificación para asegurarse de que los valores no son nulos o vacíos
            if (audiencia.getTipo() == null || audiencia.getTipo().isEmpty()
                    || audiencia.getRol() == null || audiencia.getRol().isEmpty()
                    || audiencia.getTribunal() == null || audiencia.getTribunal().isEmpty()
                    || audiencia.getFecha() == null
                    || audiencia.getHora() == null || audiencia.getHora().isEmpty()
                    || audiencia.getLugar() == null || audiencia.getLugar().isEmpty()
                    || audiencia.getEstado() == null || audiencia.getEstado().isEmpty()
                    || audiencia.getObservaciones() == null || audiencia.getObservaciones().isEmpty()) {
                System.out.println("Error: Algunos campos obligatorios están vacíos.");
                return false;
            }

            // Asignación de valores al PreparedStatement
            pst.setString(1, audiencia.getTipo());
            pst.setString(2, audiencia.getRol());
            pst.setString(3, audiencia.getTribunal());
            pst.setString(4, audiencia.getFecha());
            pst.setString(5, audiencia.getHora());
            pst.setString(6, audiencia.getLugar());
            pst.setString(7, audiencia.getEstado());
            pst.setString(8, audiencia.getObservaciones());

            // Verificación del id_abogado, si es 0, no es válido
            if (audiencia.getIdAbogado() <= 0) {
                System.out.println("Error: Abogado no válido.");
                return false;
            }
            pst.setInt(9, audiencia.getIdAbogado());

            // Ejecutar la inserción y retornar el resultado
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar la audiencia: " + e.getMessage());
            return false;
        }
    }
    public boolean existeAudienciaPorRol(String rol) {
        boolean respuesta = false;
        String sql = "SELECT id_audiencia FROM tb_audiencias WHERE LOWER(rol) = LOWER(?)"; // Búsqueda insensible a mayúsculas/minúsculas

        try (Connection cn = Conexion.getConexion(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, rol.trim()); // Usamos el rol para buscar la audiencia
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                respuesta = true; // Si se encuentra una audiencia con ese rol, se devuelve true
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la audiencia por rol: " + e.getMessage());
        }
        return respuesta;
    }

    public boolean actualizar(Audiencia audiencia, int idAudiencia, int idAbogado) {
        boolean respuesta = false;

        // Consulta SQL adaptada para actualizar solo los campos de la tabla tb_audiencias
        String sql = "UPDATE tb_audiencias "
                + "SET tipo = ?, rol = ?, tribunal = ?, fecha = ?, hora = ?, lugar = ?,  estado = ?, observaciones = ?, id_abogado = ? "
                + "WHERE id_audiencia = ?";  // Se usa id_audiencia como clave primaria

        try (Connection cn = Conexion.getConexion(); PreparedStatement consulta = cn.prepareStatement(sql)) {
            // Asignar los parámetros
            consulta.setString(1, audiencia.getTipo());         // Tipo de audiencia
            consulta.setString(2, audiencia.getRol());          // Rol
            consulta.setString(3, audiencia.getTribunal());     // Tribunal
            consulta.setString(4, audiencia.getFecha());
            consulta.setString(5, audiencia.getHora());        // Hora de la audiencia
            consulta.setString(6, audiencia.getLugar());       // Lugar de la audiencia
            consulta.setString(7, audiencia.getEstado());      // Estado
            consulta.setString(8, audiencia.getObservaciones());  // Observaciones de la audiencia

            // Asignar el ID del abogado (nuevo parámetro)
            consulta.setInt(9, idAbogado);
            // Asignar el ID de la audiencia para actualizar el registro específico
            consulta.setInt(10, idAudiencia);

            // Ejecutar la actualización
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // Si se actualiza al menos un registro
            } else {
                System.out.println("No se encontró el registro con el ID de audiencia: " + idAudiencia);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar audiencia: " + e.getMessage());
            e.printStackTrace();
        }
        return respuesta;
    }

    // MÉTODO PARA ELIMINAR UNA AUDIENCIA
    public boolean eliminar(int idAudiencia) {
        boolean respuesta = false;
        String sql = "DELETE FROM tb_audiencias WHERE id_audiencia= ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {
            consulta.setInt(1, idAudiencia);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la Audiencia registrada: " + e);
        }
        return respuesta;
    }

    public ArrayList<Audiencia> BuscarCausaRol(String rol) {
        ArrayList<Audiencia> listaAudiencias = new ArrayList<>();
        String sql = "SELECT * FROM tb_audiencias WHERE 1=1"; // Base de la consulta

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
                    Audiencia audiencia = new Audiencia();
                    audiencia.setIdAudiencia(rs.getInt("id_audiencia"));
                    audiencia.setTipo(rs.getString("tipo"));
                    audiencia.setRol(rs.getString("rol"));
                    audiencia.setTribunal(rs.getString("tribunal"));
                    audiencia.setFecha(rs.getString("fecha"));
                    audiencia.setHora(rs.getString("hora"));
                    audiencia.setLugar(rs.getString("lugar"));
                    audiencia.setEstado(rs.getString("estado"));
                    audiencia.setObservaciones(rs.getString("observaciones"));
                    audiencia.setIdAbogado(rs.getInt("id_abogado"));

                    listaAudiencias.add(audiencia);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar la causa por rol: " + e.getMessage());
        }

        return listaAudiencias;
    }
}
