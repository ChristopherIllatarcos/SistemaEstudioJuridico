package vista;

//import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import controlador.Ctrl_Abogado;
import controlador.Ctrl_Causa;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Abogado;
import modelo.Causas;

/**
 *
 * @author caill
 */
public class InterCausa extends javax.swing.JInternalFrame {


    public InterCausa() {
        initComponents();
        this.setSize(new Dimension(530, 500));
        this.setTitle("Registro de Cuasas");

        this.cargarComboAbogado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_tipo = new javax.swing.JTextField();
        txt_rol = new javax.swing.JTextField();
        txt_tribunal = new javax.swing.JTextField();
        txt_estado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_abogado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_detalle = new javax.swing.JTextField();
        jDateChooser_fecha = new com.toedter.calendar.JDateChooser();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Causas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rol:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tribunal:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Abogado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));
        getContentPane().add(txt_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 220, 30));
        getContentPane().add(txt_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 220, 30));
        getContentPane().add(txt_tribunal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 220, 30));
        getContentPane().add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 220, 30));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 220, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estado:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jComboBox_abogado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_abogado.setModel(jComboBox_abogado.getModel());
        jComboBox_abogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_abogadoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_abogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 220, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Detalle:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));
        getContentPane().add(txt_detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 282, 220, 30));
        getContentPane().add(jDateChooser_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 220, 30));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo-causa.png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Causas causas = new Causas();
        Ctrl_Causa controlCausa = new Ctrl_Causa();
        Ctrl_Abogado controlAbogado = new Ctrl_Abogado(); // Instancia el controlador de abogados

        // Obtener los datos del cliente
        String tipo = txt_tipo.getText().trim();
        String rol = txt_rol.getText().trim();
        String tribunal = txt_tribunal.getText().trim();
        Date fechaDate = jDateChooser_fecha.getDate();
        String fecha = (fechaDate != null) ? new SimpleDateFormat("yyyy-MM-dd").format(fechaDate) : ""; // Convertir a String si no es null
        String estado = txt_estado.getText().trim();
        String detalle = txt_detalle.getText().trim();

        // Validar campos vacíos
        if (tipo.isEmpty() || rol.isEmpty() || tribunal.isEmpty() || fecha.isEmpty()
                || estado.isEmpty() || detalle.isEmpty()) {
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
        if (idAbogado <= 0) { // Mejora: Usar <= 0 en lugar de solo == 0
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del abogado");
            return;
        }

        // Verificar si el rol ya existe
        if (controlCausa.existeCausa(rol)) {
            JOptionPane.showMessageDialog(null, "El rol ya está registrado");
            return;
        }

        // Asignar los datos al objeto Causas
        causas.setTipo(tipo);
        causas.setRol(rol);
        causas.setTribunal(tribunal);
        causas.setFecha(fecha);
        causas.setEstado(estado);
        causas.setDetalle(detalle);
        causas.setIdAbogado(idAbogado); // Asignar el ID del abogado
      

        // Intentar guardar la causa
        try {
            if (controlCausa.Guardar(causas)) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el registro");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
            System.out.println("Error al guardar causa: " + e);
        }

        // Limpiar los campos
        txt_tipo.setText("");
        txt_rol.setText("");
        txt_tribunal.setText("");
        jDateChooser_fecha.setDate(null);  // Limpiar la fecha
        txt_estado.setText("");
        txt_detalle.setText("");
        jComboBox_abogado.setSelectedItem("Seleccione Abogado:");


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox_abogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_abogadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_abogadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JComboBox<String> jComboBox_abogado;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_detalle;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_rol;
    private javax.swing.JTextField txt_tipo;
    private javax.swing.JTextField txt_tribunal;
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
