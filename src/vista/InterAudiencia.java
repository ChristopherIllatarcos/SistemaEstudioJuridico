package vista;


import com.mysql.jdbc.Statement;
import conexion.Conexion;
import controlador.Ctrl_Abogado;
import controlador.Ctrl_Audiencia;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Abogado;
import modelo.Audiencia;


/**
 *
 * @author caill
 */
public class InterAudiencia extends javax.swing.JInternalFrame {

    public InterAudiencia() {
        initComponents();
        this.setSize(new Dimension(530, 548));
        this.setTitle("Registro de Audiencias");

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
        txt_lugar = new javax.swing.JTextField();
        jButton_registrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_abogado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_observacion = new javax.swing.JTextField();
        jDateChooser_fecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txt_estado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_hora = new javax.swing.JComboBox<>();
        jComboBox_minutos = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Audiencias");
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
        jLabel6.setText(":");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 20, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Abogado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));
        getContentPane().add(txt_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 230, 30));
        getContentPane().add(txt_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 230, 30));
        getContentPane().add(txt_tribunal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 230, 30));
        getContentPane().add(txt_lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 230, 30));

        jButton_registrar.setBackground(new java.awt.Color(51, 51, 51));
        jButton_registrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrar.setText("REGISTRAR");
        jButton_registrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 230, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Lugar:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jComboBox_abogado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_abogado.setModel(jComboBox_abogado.getModel());
        jComboBox_abogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_abogadoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_abogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 230, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Observación:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));
        getContentPane().add(txt_observacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 230, 30));
        getContentPane().add(jDateChooser_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 230, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Estado:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));
        getContentPane().add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 230, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jComboBox_hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hora:", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        getContentPane().add(jComboBox_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 100, -1));

        jComboBox_minutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min:", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        getContentPane().add(jComboBox_minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 240, 110, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Hora:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo-causa.png"))); // NOI18N
        jLabel_wallpaper.setPreferredSize(new java.awt.Dimension(530, 570));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 520, 540));
        jLabel_wallpaper.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed
        Audiencia audiencia = new Audiencia();
        Ctrl_Audiencia controlAudiencia = new Ctrl_Audiencia();
        Ctrl_Abogado controlAbogado = new Ctrl_Abogado(); // Instancia el controlador de abogados

        // Obtener los datos del cliente
        String tipo = txt_tipo.getText().trim();
        String rol = txt_rol.getText().trim();
        String tribunal = txt_tribunal.getText().trim();
        Date fechaDate = jDateChooser_fecha.getDate();
        String fecha = (fechaDate != null) ? new SimpleDateFormat("yyyy-MM-dd").format(fechaDate) : ""; // Convertir a String si no es null
        String hora = jComboBox_hora.getSelectedItem().toString();
        String minutos = jComboBox_minutos.getSelectedItem().toString();
        String lugar = txt_lugar.getText().trim();
        String estado = txt_estado.getText().trim();
        String observaciones = txt_observacion.getText();

        // Validar campos vacíos
        if (tipo.isEmpty() || rol.isEmpty() || tribunal.isEmpty() || fecha.isEmpty()
                || hora.isEmpty() || minutos.isEmpty() || lugar.isEmpty() || estado.isEmpty() || observaciones.isEmpty()) {
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
        if (controlAudiencia.existeAudienciaPorRol(rol)) {
            JOptionPane.showMessageDialog(null, "El rol ya está registrado");
            return;
        }

        // Concatenar hora y minutos para formar la hora completa
        String horaCompleta = hora + ":" + minutos;

        // Asignar los datos al objeto Audiencia
        audiencia.setTipo(tipo);
        audiencia.setRol(rol);
        audiencia.setTribunal(tribunal);
        audiencia.setFecha(fecha);
        audiencia.setHora(horaCompleta);  // Usar la hora completa concatenada
        audiencia.setLugar(lugar);
        audiencia.setEstado(estado);
        audiencia.setObservaciones(observaciones);
        audiencia.setIdAbogado(idAbogado); // Asignar el ID del abogado

        //guardar la causa
        try {
            if (controlAudiencia.Guardar(audiencia)) {
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
        txt_lugar.setText("");
        txt_estado.setText(""); // Limpiar estado
        txt_observacion.setText("");
        jComboBox_abogado.setSelectedItem("Seleccione Abogado:");
        jComboBox_hora.setSelectedItem("Hora:");  // Limpiar hora
        jComboBox_minutos.setSelectedItem("Min:");  // Limpiar minutos


    }//GEN-LAST:event_jButton_registrarActionPerformed

    private void jComboBox_abogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_abogadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_abogadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_registrar;
    public static javax.swing.JComboBox<String> jComboBox_abogado;
    private javax.swing.JComboBox<String> jComboBox_hora;
    private javax.swing.JComboBox<String> jComboBox_minutos;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_lugar;
    private javax.swing.JTextField txt_observacion;
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
