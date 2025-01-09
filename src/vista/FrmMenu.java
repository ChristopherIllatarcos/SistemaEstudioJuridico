
package vista;

import com.itextpdf.text.DocumentException;
import controlador.Ctrl_Reportes;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author caill
 */
public class FrmMenu extends javax.swing.JFrame {

    public static JDesktopPane jDesktoPane_menu;

    public FrmMenu() {
        initComponents();
        this.setSize(new Dimension(1200, 700));
        this.setExtendedState(FrmMenu.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Estudio Jurídico M&M");

        this.setLayout(null);
        jDesktoPane_menu = new JDesktopPane();

        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        // Crear JDesktopPane con imagen de fondo
        jDesktoPane_menu = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Cargar imagen de fondo
                ImageIcon icon = new ImageIcon("src/img/fondo_justicia.jpg"); // Ruta 
                Image img = icon.getImage(); // Convertir la imagen a un objeto Image
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this); // Dibujar la imagen redimensionada
            }
        };

        jDesktoPane_menu.setBounds(0, 0, ancho, alto - 110);
        this.add(jDesktoPane_menu);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_nuevo_cliente = new javax.swing.JMenuItem();
        jMenuItem_gestionar_cliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_nuevo_abogado = new javax.swing.JMenuItem();
        jMenuItem_gestionar_abogado = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_nueva_causa = new javax.swing.JMenuItem();
        jMenuItem_gestionar_causa = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem_nueva_audiencia = new javax.swing.JMenuItem();
        jMenuItem_gestionar_audiencias = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem_reporte_clientes = new javax.swing.JMenuItem();
        jMenuItem_reporte_causas = new javax.swing.JMenuItem();
        jMenuItem_reporte_audiencias = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem_cerrar_sesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));

        jMenu1.setBackground(new java.awt.Color(0, 0, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        jMenu1.setText("Clientes");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu1.setMinimumSize(new java.awt.Dimension(250, 50));
        jMenu1.setPreferredSize(new java.awt.Dimension(180, 50));

        jMenuItem_nuevo_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_nuevo_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-cliente.png"))); // NOI18N
        jMenuItem_nuevo_cliente.setText("Nuevo Cliente");
        jMenuItem_nuevo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevo_clienteActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_nuevo_cliente);

        jMenuItem_gestionar_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_gestionar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenuItem_gestionar_cliente.setText("Gestionar Clientes");
        jMenuItem_gestionar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_clienteActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_gestionar_cliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abogado.png"))); // NOI18N
        jMenu2.setText("Abogados");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu2.setMinimumSize(new java.awt.Dimension(160, 50));
        jMenu2.setPreferredSize(new java.awt.Dimension(250, 50));

        jMenuItem_nuevo_abogado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_nuevo_abogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abogado.png"))); // NOI18N
        jMenuItem_nuevo_abogado.setText("Nuevo Abogado");
        jMenuItem_nuevo_abogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevo_abogadoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_nuevo_abogado);

        jMenuItem_gestionar_abogado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_gestionar_abogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenuItem_gestionar_abogado.setText("Gestionar Abogado");
        jMenuItem_gestionar_abogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_abogadoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_gestionar_abogado);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/causas.png"))); // NOI18N
        jMenu3.setText("Causas");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setMinimumSize(new java.awt.Dimension(160, 50));
        jMenu3.setPreferredSize(new java.awt.Dimension(250, 22));

        jMenuItem_nueva_causa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_nueva_causa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/causas.png"))); // NOI18N
        jMenuItem_nueva_causa.setText("Nueva Causa");
        jMenuItem_nueva_causa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nueva_causaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_nueva_causa);

        jMenuItem_gestionar_causa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_gestionar_causa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenuItem_gestionar_causa.setText("Gestionar Causas");
        jMenuItem_gestionar_causa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_causaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_gestionar_causa);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/audiencia.png"))); // NOI18N
        jMenu4.setText("Audiencias");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setMinimumSize(new java.awt.Dimension(160, 50));
        jMenu4.setPreferredSize(new java.awt.Dimension(250, 50));

        jMenuItem_nueva_audiencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_nueva_audiencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/audiencia.png"))); // NOI18N
        jMenuItem_nueva_audiencia.setText("Nueva Audiencia");
        jMenuItem_nueva_audiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nueva_audienciaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_nueva_audiencia);

        jMenuItem_gestionar_audiencias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_gestionar_audiencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenuItem_gestionar_audiencias.setText("Gestionar Audiencias");
        jMenuItem_gestionar_audiencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_audienciasActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_gestionar_audiencias);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/documentos.png"))); // NOI18N
        jMenu5.setText("Reportes");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setMinimumSize(new java.awt.Dimension(160, 50));
        jMenu5.setPreferredSize(new java.awt.Dimension(250, 50));

        jMenuItem_reporte_clientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_reporte_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_reporte_clientes.setText("Reporte Clientes");
        jMenuItem_reporte_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reporte_clientesActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_reporte_clientes);

        jMenuItem_reporte_causas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_reporte_causas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_reporte_causas.setText("Reporte Causas");
        jMenuItem_reporte_causas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reporte_causasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_reporte_causas);

        jMenuItem_reporte_audiencias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_reporte_audiencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_reporte_audiencias.setText("Reporte Audiencias");
        jMenuItem_reporte_audiencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reporte_audienciasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_reporte_audiencias);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jMenu6.setText("Cerrar Sesión");
        jMenu6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu6.setPreferredSize(new java.awt.Dimension(210, 50));

        jMenuItem_cerrar_sesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jMenuItem_cerrar_sesion.setText("Cerrar Sesión");
        jMenuItem_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_cerrar_sesionActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_cerrar_sesion);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_nuevo_abogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevo_abogadoActionPerformed
        InterAbogado interAbogado = new InterAbogado();
        jDesktoPane_menu.add(interAbogado);
        interAbogado.setVisible(true);
    }//GEN-LAST:event_jMenuItem_nuevo_abogadoActionPerformed

    private void jMenuItem_gestionar_abogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_abogadoActionPerformed
        InterGestionarAbogados interGestionarAbogados = new InterGestionarAbogados();
        jDesktoPane_menu.add(interGestionarAbogados);
        interGestionarAbogados.setVisible(true);
    }//GEN-LAST:event_jMenuItem_gestionar_abogadoActionPerformed

    private void jMenuItem_nuevo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevo_clienteActionPerformed
        InterCliente interCliente = new InterCliente();
        jDesktoPane_menu.add(interCliente);
        interCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem_nuevo_clienteActionPerformed

    private void jMenuItem_gestionar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_clienteActionPerformed
        InterGestionCliente interGestionCliente = new InterGestionCliente();
        jDesktoPane_menu.add(interGestionCliente);
        interGestionCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem_gestionar_clienteActionPerformed

    private void jMenuItem_gestionar_causaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_causaActionPerformed
        InterGestionCausa interGestionCausa = new InterGestionCausa();
        jDesktoPane_menu.add(interGestionCausa);
        interGestionCausa.setVisible(true);
    }//GEN-LAST:event_jMenuItem_gestionar_causaActionPerformed

    private void jMenuItem_nueva_causaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nueva_causaActionPerformed
        InterCausa interCausa = new InterCausa();
        jDesktoPane_menu.add(interCausa);
        interCausa.setVisible(true);
    }//GEN-LAST:event_jMenuItem_nueva_causaActionPerformed

    private void jMenuItem_nueva_audienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nueva_audienciaActionPerformed
        InterAudiencia interAudiencia = new InterAudiencia();
        jDesktoPane_menu.add(interAudiencia);
        interAudiencia.setVisible(true);
    }//GEN-LAST:event_jMenuItem_nueva_audienciaActionPerformed

    private void jMenuItem_gestionar_audienciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_audienciasActionPerformed
        InterGestionAudiencia interGestionAudiencia = new InterGestionAudiencia();
        jDesktoPane_menu.add(interGestionAudiencia);
        interGestionAudiencia.setVisible(true);
    }//GEN-LAST:event_jMenuItem_gestionar_audienciasActionPerformed

    private void jMenuItem_reporte_causasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reporte_causasActionPerformed
        Ctrl_Reportes reporte = new Ctrl_Reportes();
        try {
            reporte.generarReporteTabla();
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem_reporte_causasActionPerformed

    private void jMenuItem_reporte_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reporte_clientesActionPerformed
        Ctrl_Reportes reporte = new Ctrl_Reportes();
        try {
            reporte.generarReporteClientes();
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem_reporte_clientesActionPerformed

    private void jMenuItem_reporte_audienciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reporte_audienciasActionPerformed
        Ctrl_Reportes reporte = new Ctrl_Reportes();
        try {
            reporte.generarReporteAudiencias();
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem_reporte_audienciasActionPerformed

    private void jMenuItem_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_cerrar_sesionActionPerformed
           // Crear un cuadro de diálogo para mostrar el mensaje "Cargando"
        JDialog dialogoCargando = new JDialog(this, "Cargando", true);
        JLabel etiquetaMensaje = new JLabel("Cerrando sesión, por favor espere...", SwingConstants.CENTER);
        etiquetaMensaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dialogoCargando.add(etiquetaMensaje);
        dialogoCargando.setSize(300, 100);
        dialogoCargando.setLocationRelativeTo(this);

        // Crear un temporizador para cerrar el cuadro de diálogo después de 3 segundos
        Timer timer = new Timer(3000, e -> {
            dialogoCargando.dispose(); // Cerrar el cuadro de diálogo

            // Cerrar la ventana actual
            this.dispose();

            // Abrir el formulario de inicio de sesión
            FrmLogin formularioUsuario = new FrmLogin();
            formularioUsuario.setVisible(true);
        });

        // Iniciar el temporizador
        timer.setRepeats(false); // Solo se ejecuta una vez
        timer.start();

        // Mostrar el cuadro de diálogo
        dialogoCargando.setVisible(true);
    }//GEN-LAST:event_jMenuItem_cerrar_sesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_cerrar_sesion;
    private javax.swing.JMenuItem jMenuItem_gestionar_abogado;
    private javax.swing.JMenuItem jMenuItem_gestionar_audiencias;
    private javax.swing.JMenuItem jMenuItem_gestionar_causa;
    private javax.swing.JMenuItem jMenuItem_gestionar_cliente;
    private javax.swing.JMenuItem jMenuItem_nueva_audiencia;
    private javax.swing.JMenuItem jMenuItem_nueva_causa;
    private javax.swing.JMenuItem jMenuItem_nuevo_abogado;
    private javax.swing.JMenuItem jMenuItem_nuevo_cliente;
    private javax.swing.JMenuItem jMenuItem_reporte_audiencias;
    private javax.swing.JMenuItem jMenuItem_reporte_causas;
    private javax.swing.JMenuItem jMenuItem_reporte_clientes;
    // End of variables declaration//GEN-END:variables
}
