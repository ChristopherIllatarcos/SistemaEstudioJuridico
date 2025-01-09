package controlador;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author caill
 */
public class Ctrl_Reportes {

    public void TicketRetiro(int idFuncionario) {
        Document documento = new Document();
        String ruta = System.getProperty("user.home") + "/OneDrive/Escritorio/Reporte_causas.pdf";

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // Cargar la imagen del encabezado
            try {
                Image header = Image.getInstance("src/img/registro.png");
                header.scaleToFit(100, 100);
                header.setAlignment(Chunk.ALIGN_CENTER);
                documento.add(header);
            } catch (IOException ex) {
                System.out.println("Error al cargar la imagen del encabezado: " + ex);
            }

            // Conexión y consulta a la base de datos
            try (Connection cn = Conexion.conectar()) {
                String sql = "SELECT * FROM tb_causas WHERE id_causas = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, idFuncionario);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    // Encabezado del ticket
                    Paragraph parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add("Sistema de Ingreso y Registro \n ©M&M Abogados\n\n");
                    parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
                    parrafo.add("_____________________________________________________\n\n");
                    documento.add(parrafo);

                    // Contenido del ticket
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = dateFormat.format(rs.getString("fecha"));

                    Paragraph contenido = new Paragraph();
                    contenido.setAlignment(Paragraph.ALIGN_LEFT);
                    contenido.add("Tipo: " + rs.getString("tipo") + "\n");
                    contenido.add("Rol: " + rs.getString("rol") + "\n");
                    contenido.add("Tribunal: " + rs.getString("tribunal") + "\n");
                    contenido.add("fecha" + rs.getString("fecha") + "\n\n");
                    contenido.add("Estado: " + rs.getString("estado") + "\n\n");
                    contenido.add("Detalle:" + rs.getString("detalle") + "\n\n");
                    contenido.add("abogado" + rs.getString("id_abogado") + "\n\n");
                    contenido.add("_____________________________________________________\n\n");
                    contenido.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.BLACK));

                    documento.add(contenido);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un funcionario con el ID proporcionado.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al acceder a la base de datos: " + ex);
            }

            // Mensaje de éxito
            JOptionPane.showMessageDialog(null, "Ticket creado con éxito en: " + ruta);
        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error al generar el documento: " + ex);
        } finally {
            // Cierre seguro del documento
            if (documento.isOpen()) {
                documento.close();
            }
        }
    }

    public void generarReporteTabla() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        Document documento = new Document();
        String ruta = System.getProperty("user.home") + "/OneDrive/Escritorio/Reporte_Tabla_Registro_causas.pdf";

        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        documento.open();

        // Añadir encabezado
        try {
            Image header = Image.getInstance("src/img/header2.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(header);
        } catch (IOException ex) {
            System.out.println("Error al cargar la imagen del encabezado: " + ex);
        }

        // Título del reporte
        Paragraph titulo = new Paragraph("Informe Control de Ingreso de Causas\n",
                FontFactory.getFont("Tahoma", 20, java.awt.Font.BOLD, BaseColor.DARK_GRAY));
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        // Línea separadora
        Paragraph separador = new Paragraph(
                "____________________________________________________________\n\n");
        documento.add(separador);

        // Agregar el nombre del creador del reporte
        Paragraph creadoPor = new Paragraph(" ©M&M Abogados\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        creadoPor.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(creadoPor);

        // Agregar el nombre de la profesión
        Paragraph profesion = new Paragraph("Abogados Asociados M&M\n\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        profesion.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(profesion);

        // Agregar el nombre de la escuela
        Paragraph escuela = new Paragraph(" ©M&M Abogados\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        escuela.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(escuela);

        // Otra línea separadora
        Paragraph separador2 = new Paragraph("_____________________________________________________\n\n");
        separador2.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(separador2);

        // Conexión y consulta de datos
        try (Connection cn = Conexion.conectar()) {
            String sql = "SELECT c.id_causa, c.tipo, c.rol, c.tribunal, c.fecha, c.estado, c.detalle, a.nombre AS nombre_abogado "
                    + "FROM tb_causas c "
                    + "INNER JOIN tb_abogados a ON c.id_abogado = a.id_abogado";

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Crear tabla PDF
            PdfPTable tabla = new PdfPTable(8); // 8 columnas
            tabla.setWidthPercentage(110);
            tabla.setWidths(new float[]{1.5f, 3f, 2f, 3f, 2f, 3f, 3f, 3f}); // Anchos de columnas
            tabla.setSpacingBefore(10f);

            // Encabezados de la tabla
            tabla.addCell(new PdfPCell(new Phrase("ID", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Tipo", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Rol", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Tribunal", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Fecha", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Estado", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Detalle", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Abogado", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });

            // Llenar tabla con datos de la base
            while (rs.next()) {
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(rs.getInt("id_causa")))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("tipo"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("rol"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("tribunal"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("fecha"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("estado"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("detalle"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("nombre_abogado")))); // Mostrar nombre del abogado
            }

            // Añadir la tabla al documento
            documento.add(tabla);

        } catch (SQLException ex) {
            System.out.println("Error al acceder a la base de datos: " + ex);
        }

        // Mensaje de éxito
        JOptionPane.showMessageDialog(null, "Reporte generado con éxito en: " + ruta);

        // Cerrar el documento
        if (documento.isOpen()) {
            documento.close();
        }
    }

    public void generarReporteAudiencias() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        Document documento = new Document();
        String ruta = System.getProperty("user.home") + "/OneDrive/Escritorio/Reporte_Registro_audiencia.pdf";

        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        documento.open();

        // Añadir encabezado
        try {
            Image header = Image.getInstance("src/img/header2.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(header);
        } catch (IOException ex) {
            System.out.println("Error al cargar la imagen del encabezado: " + ex);
        }

        // Título del reporte
        Paragraph titulo = new Paragraph("Informe Control de Registro Audiencias\n",
                FontFactory.getFont("Tahoma", 20, java.awt.Font.BOLD, BaseColor.DARK_GRAY));
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        // Línea separadora
        Paragraph separador = new Paragraph(
                "____________________________________________________________\n\n");
        documento.add(separador);

        // Agregar el nombre del creador del reporte
        Paragraph creadoPor = new Paragraph(" ©M&M Abogados\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        creadoPor.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(creadoPor);

        // Agregar el nombre de la profesión
        Paragraph profesion = new Paragraph("Abogados Asociados M&M\n\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        profesion.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(profesion);

        // Agregar el nombre de la escuela
        Paragraph escuela = new Paragraph(" ©M&M Abogados\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        escuela.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(escuela);

        // Otra línea separadora
        Paragraph separador2 = new Paragraph("_____________________________________________________\n\n");
        separador2.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(separador2);

        // Conexión y consulta de datos
        try (Connection cn = Conexion.conectar()) {
            String sql = "SELECT a.id_audiencia, a.tipo, a.rol, a.tribunal, a.fecha, a.hora, a.lugar, a.estado, a.observaciones, ab.nombre AS nombre_abogado "
                    + "FROM tb_audiencias a "
                    + "INNER JOIN tb_abogados ab ON a.id_abogado = ab.id_abogado";

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Crear tabla PDF
            PdfPTable tabla = new PdfPTable(10); // 10 columnas
            tabla.setWidthPercentage(110);
            tabla.setWidths(new float[]{1.5f, 3f, 3f, 3f, 2f, 2f, 3f, 2f, 3f, 3f}); // Anchos de columnas
            tabla.setSpacingBefore(10f);

            // Encabezados de la tabla
            tabla.addCell(new PdfPCell(new Phrase("ID Audiencia", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Tipo", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Rol", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Tribunal", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Fecha", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Hora", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Lugar", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Estado", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Observaciones", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Abogado", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });

            // Llenar tabla con datos de la base
            while (rs.next()) {
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(rs.getInt("id_audiencia")))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("tipo"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("rol"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("tribunal"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("fecha"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("hora"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("lugar"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("estado"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("observaciones"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("nombre_abogado")))); // Mostrar nombre del abogado
            }

            // Añadir la tabla al documento
            documento.add(tabla);

        } catch (SQLException ex) {
            System.out.println("Error al acceder a la base de datos: " + ex);
        }

// Mensaje de éxito
        JOptionPane.showMessageDialog(null, "Reporte generado con éxito en: " + ruta);

// Cerrar el documento
        if (documento.isOpen()) {
            documento.close();
        }
    }

    public void generarReporteClientes() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        Document documento = new Document();
        String ruta = System.getProperty("user.home") + "/OneDrive/Escritorio/Reporte_Registro_clientes.pdf";

        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        documento.open();

        // Añadir encabezado
        try {
            Image header = Image.getInstance("src/img/header2.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(header);
        } catch (IOException ex) {
            System.out.println("Error al cargar la imagen del encabezado: " + ex);
        }

        // Título del reporte
        Paragraph titulo = new Paragraph("Informe Control Registro de Clientes \n",
                FontFactory.getFont("Tahoma", 20, java.awt.Font.BOLD, BaseColor.DARK_GRAY));
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        // Línea separadora
        Paragraph separador = new Paragraph(
                "____________________________________________________________\n\n");
        documento.add(separador);

        // Agregar el nombre del creador del reporte
        Paragraph creadoPor = new Paragraph(" ©M&M Abogados\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        creadoPor.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(creadoPor);

        // Agregar el nombre de la profesión
        Paragraph profesion = new Paragraph("Abogados Asociados M&M\n\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        profesion.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(profesion);

        // Agregar el nombre de la escuela
        Paragraph escuela = new Paragraph(" ©M&M Abogados\n",
                FontFactory.getFont("Tahoma", 14, java.awt.Font.BOLD, BaseColor.BLACK));
        escuela.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(escuela);

        // Otra línea separadora
        Paragraph separador2 = new Paragraph("_____________________________________________________\n\n");
        separador2.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(separador2);

        // Conexión y consulta de datos
        try (Connection cn = Conexion.conectar()) {
            String sql = "SELECT c.id_cliente, c.nombre, c.rut, c.contacto, c.direccion, c.notas, a.nombre AS nombre_abogado "
                    + "FROM tb_clientes c "
                    + "INNER JOIN tb_abogados a ON c.idAbogado = a.id_abogado";

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Crear tabla PDF
            PdfPTable tabla = new PdfPTable(7); // 7 columnas
            tabla.setWidthPercentage(110);
            tabla.setWidths(new float[]{1.5f, 3f, 3f, 3f, 4f, 5f, 3f}); // Anchos de columnas
            tabla.setSpacingBefore(10f);

            // Encabezados de la tabla
            tabla.addCell(new PdfPCell(new Phrase("ID Cliente", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Nombre", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("RUT", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Contacto", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Dirección", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Notas", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });
            tabla.addCell(new PdfPCell(new Phrase("Abogado", FontFactory.getFont("Tahoma", 12, java.awt.Font.BOLD, BaseColor.WHITE))) {
                {
                    setBackgroundColor(BaseColor.GRAY);
                    setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            });

            // Llenar tabla con datos de la base
            while (rs.next()) {
                tabla.addCell(new PdfPCell(new Phrase(String.valueOf(rs.getInt("id_cliente")))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("nombre"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("rut"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("contacto"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("direccion"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("notas"))));
                tabla.addCell(new PdfPCell(new Phrase(rs.getString("nombre_abogado")))); // Mostrar nombre del abogado
            }

            // Añadir la tabla al documento
            documento.add(tabla);

        } catch (SQLException ex) {
            System.out.println("Error al acceder a la base de datos: " + ex);
        }

// Mensaje de éxito
        JOptionPane.showMessageDialog(null, "Reporte generado con éxito en: " + ruta);

// Cerrar el documento
        if (documento.isOpen()) {
            documento.close();
        }
    }
}
