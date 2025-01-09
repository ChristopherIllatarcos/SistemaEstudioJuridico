package vista;

import com.mysql.jdbc.Statement;
import conexion.Conexion;
import controlador.Ctrl_Abogado;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Abogado;

public class InterGestionarAbogados extends javax.swing.JInternalFrame {

    private int idAbogado;

    public InterGestionarAbogados() {
        initComponents();
        this.setSize(new Dimension(700, 500));
        this.setTitle("Gestión y Registro de Abogados");

        this.CargarTablaAbogado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_registro_abogado = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_especialidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_contacto = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestión y Registro de Abogados");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable_registro_abogado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable_registro_abogado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_registro_abogado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 420, 350));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(0, 153, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        jButton_actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 40));

        jButton_eliminar.setBackground(new java.awt.Color(255, 0, 0));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jButton_eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 220, 120));

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txt_nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Especialidad:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_especialidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_especialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contacto:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txt_contacto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txt_contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 220, 210));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo4.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 6, 690, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        if (!txt_nombre.getText().isEmpty() && !txt_especialidad.getText().isEmpty() && !txt_contacto.getText().isEmpty()) {
            Abogado abogado = new Abogado();
            Ctrl_Abogado controlAbogado = new Ctrl_Abogado();

            abogado.setNombre(txt_nombre.getText().trim());
            abogado.setEspecialidad(txt_especialidad.getText().trim());
            abogado.setContacto(txt_contacto.getText().trim());

            if (controlAbogado.actualizar(abogado, idAbogado)) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                txt_nombre.setText("");
                txt_especialidad.setText("");
                txt_contacto.setText("");
                this.CargarTablaAbogado();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un nombre");
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        // Verificar que los campos no estén vacíos
        if (!txt_nombre.getText().isEmpty() && !txt_especialidad.getText().isEmpty() && !txt_contacto.getText().isEmpty()) {
            Ctrl_Abogado controlAbogado = new Ctrl_Abogado();

            // Mostrar advertencia de confirmación
            int confirmacion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro de que desea eliminar datos del Abogado registrado?",
                    "Confirmación de Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            // Verificar la respuesta del usuario
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Intentar eliminar el registro
                if (controlAbogado.eliminar(idAbogado)) {
                    JOptionPane.showMessageDialog(null, "¡Abogado eliminado con éxito!");
                    // Limpiar campos
                    txt_nombre.setText("");
                    txt_especialidad.setText("");
                    txt_contacto.setText("");
                    // Actualizar la tabla
                    this.CargarTablaAbogado();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el abogado. Verifique nuevamente.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un abogado para eliminar.");
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_registro_abogado;
    private javax.swing.JTextField txt_contacto;
    private javax.swing.JTextField txt_especialidad;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    private void CargarTablaAbogado() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT id_abogado, nombre, especialidad, contacto FROM tb_abogados";
        Statement st;

        try {
            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarAbogados.jTable_registro_abogado = new JTable(model);
            InterGestionarAbogados.jScrollPane1.setViewportView(InterGestionarAbogados.jTable_registro_abogado);

            model.addColumn("id");
            model.addColumn("nombre");
            model.addColumn("especilidad");
            model.addColumn("contacto");

            while (rs.next()) {
                Object fila[] = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla registro de Abogados" + e);
        }

        jTable_registro_abogado.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_registro_abogado.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idAbogado = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosAbogadosSeleccionado(idAbogado);
                }
            }
        });
    }

    private void EnviarDatosAbogadosSeleccionado(int idAbogado) {

        try {
            try (Connection con = Conexion.conectar()) {
                PreparedStatement pst = con.prepareStatement(
                        "SELECT * FROM tb_abogados where id_abogado = '" + idAbogado + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    txt_nombre.setText(rs.getString("nombre"));
                    txt_especialidad.setText(rs.getString("especialidad"));
                    txt_contacto.setText(rs.getString("contacto"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al seleccionar Abogado" + e);
        }
    }
}
