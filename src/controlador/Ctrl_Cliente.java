package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author caill
 */
public class Ctrl_Cliente {

    //METODO PARA GUARDAR CLIENTE
    public boolean Guardar(Cliente cliente) {
        boolean respuesta = false;
        String sql = "INSERT INTO tb_clientes (nombre, rut, contacto, direccion, notas, idAbogado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {

            // Asignar los parámetros a la consulta
            consulta.setString(1, cliente.getNombre());
            consulta.setString(2, cliente.getRut());
            consulta.setString(3, cliente.getContacto());
            consulta.setString(4, cliente.getDireccion());
            consulta.setString(5, cliente.getNota());
            consulta.setInt(6, cliente.getIdAbogado());  // El ID del abogado

            // Ejecutar la consulta
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar Cliente: " + e);
        }
        return respuesta;
    }

    //METODO PARA CONSULTAR SI EL CLIENTE YA ESTA REGISTRADO EN LA TABLA   
    public boolean existeCliente(String rut) {
        boolean respuesta = false;
        String sql = "SELECT rut FROM tb_clientes WHERE rut = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, rut);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                respuesta = true; // Si hay un resultado, el cliente existe
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar Cliente: " + e);
        }
        return respuesta;
    }

    public boolean actualizar(Cliente objeto, int idCliente, int idAbogado) {
        boolean respuesta = false;
        // Agregar la columna idAbogado en la consulta SQL
        String sql = "UPDATE tb_clientes SET nombre = ?, rut = ?, contacto = ?, direccion = ?, notas = ?, idAbogado = ? WHERE id_cliente = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getRut());
            consulta.setString(3, objeto.getContacto());
            consulta.setString(4, objeto.getDireccion());
            consulta.setString(5, objeto.getNota());
            consulta.setInt(6, idAbogado);  // Asignar el idAbogado
            consulta.setInt(7, idCliente);  // Asignar el idCliente para la condición

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar Cliente: " + e);
        }
        return respuesta;
    }

    //METODO PARA ELIMINAR UN CLIENTE
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        String sql = "DELETE FROM tb_clientes WHERE id_cliente = ?";

        try (Connection cn = Conexion.conectar(); PreparedStatement consulta = cn.prepareStatement(sql)) {
            consulta.setInt(1, idCliente);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar Cliente: " + e);
        }
        return respuesta;
    }

    public ArrayList<Cliente> BuscarClienteNombreRut(String nombre, String rut) {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM tb_clientes WHERE 1=1"; // Siempre verdadero para facilitar concatenación

        // Condiciones dinámicas según los parámetros no vacíos
        if (!nombre.isEmpty()) {
            sql += " AND nombre LIKE ?";
        }
        if (!rut.isEmpty()) {
            sql += " AND rut LIKE ?";
        }

        try (Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {
            int index = 1;

            // Asignar valores a los parámetros dinámicos
            if (!nombre.isEmpty()) {
                pst.setString(index++, "%" + nombre + "%");
            }
            if (!rut.isEmpty()) {
                pst.setString(index++, "%" + rut + "%");
            }

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("id_cliente"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setRut(rs.getString("rut"));
                    cliente.setContacto(rs.getString("contacto"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setNota(rs.getString("notas"));
                    cliente.setIdAbogado(rs.getInt("idAbogado"));

                    listaCliente.add(cliente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por nombre o RUT: " + e.getMessage());
        }

        return listaCliente;
    }

}
