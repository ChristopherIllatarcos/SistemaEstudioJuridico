package vista;

//import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import controlador.Ctrl_Abogado;
import controlador.Ctrl_Cliente;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Abogado;
import modelo.Cliente;

/**
 *
 * @author caill
 */
public class InterCliente extends javax.swing.JInternalFrame {



    public InterCliente() {
        initComponents();
        this.setSize(new Dimension(530, 426));
        this.setTitle("Registro de Clientes");

        this.cargarComboAbogado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_rut = new javax.swing.JTextField();
        txt_contacto = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_nota = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_abogado = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rut:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contacto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirección:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Abogado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 220, 30));
        getContentPane().add(txt_rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 220, 30));
        getContentPane().add(txt_contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 220, 30));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 220, 30));
        getContentPane().add(txt_nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 220, 30));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REGISTRAR");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 220, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Notas:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jComboBox_abogado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_abogado.setModel(jComboBox_abogado.getModel());
        jComboBox_abogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_abogadoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_abogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 220, 30));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo5.png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Cliente cliente = new Cliente();
        Ctrl_Cliente controlCliente = new Ctrl_Cliente();
        Ctrl_Abogado controlAbogado = new Ctrl_Abogado();  // Instancia el controlador de abogados

        // Obtener los datos del cliente
        String nombre = txt_nombre.getText().trim();
        String rut = txt_rut.getText().trim();
        String contacto = txt_contacto.getText().trim();
        String direccion = txt_direccion.getText().trim();
        String nota = txt_nota.getText().trim();

        // Validar campos vacíos
        if (nombre.isEmpty() || rut.isEmpty() || contacto.isEmpty() || direccion.isEmpty() || nota.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return; // Salir si falta algún campo
        }

        // Obtener el nombre del abogado seleccionado desde el JComboBox
        String nombreAbogadoSeleccionado = (String) jComboBox_abogado.getSelectedItem();
        if (nombreAbogadoSeleccionado == null || "Seleccione Abogado:".equals(nombreAbogadoSeleccionado)) {
            JOptionPane.showMessageDialog(null, "Seleccione un abogado válido");
            return; // Salir si no se selecciona un abogado válido
        }

        // Obtener el ID del abogado utilizando el nombre
        int idAbogado = controlAbogado.obtenerIdAbogadoPorNombre(nombreAbogadoSeleccionado);
        if (idAbogado == 0) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del abogado");
            return;
        }

        // Verificar si el cliente ya existe
        if (controlCliente.existeCliente(nombre) || controlCliente.existeCliente(rut)) {
            JOptionPane.showMessageDialog(null, "El cliente ya está registrado");
            return;
        }

        // Asignar los datos al objeto cliente
        cliente.setNombre(nombre);
        cliente.setRut(rut);
        cliente.setContacto(contacto);
        cliente.setDireccion(direccion);
        cliente.setNota(nota);
        cliente.setIdAbogado(idAbogado); // Asignar el ID del abogado

        // Intentar guardar el cliente
        if (controlCliente.Guardar(cliente)) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar el registro");
        }

        // Limpiar los campos
        txt_nombre.setText("");
        txt_rut.setText("");
        txt_contacto.setText("");
        txt_direccion.setText("");
        txt_nota.setText("");  // Limpiar también el campo de nota
        jComboBox_abogado.setSelectedIndex(0); // Resetear el ComboBox
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox_abogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_abogadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_abogadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JComboBox<String> jComboBox_abogado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_contacto;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nota;
    private javax.swing.JTextField txt_rut;
    // End of variables declaration//GEN-END:variables

    private void cargarComboAbogado() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_abogados";
        Statement st;

        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_abogado.removeAllItems();
            jComboBox_abogado.addItem("Seleccione Abogado:");

            while (rs.next()) {
                // Crear objeto Abogado y agregarlo al ComboBox
                Abogado abogado = new Abogado(
                        rs.getInt("id_abogado"),
                        rs.getString("nombre"),
                        rs.getString("especialidad"),
                        rs.getString("contacto")
                );
                jComboBox_abogado.addItem(abogado.getNombre());

            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar Abogado");
        }
    }

}
