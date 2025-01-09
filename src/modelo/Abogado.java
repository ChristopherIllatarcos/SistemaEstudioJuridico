package modelo;

/**
 *
 * @author caill
 */
public class Abogado {

    private int idAbogado;
    private String nombre;
    private String especialidad;
    private String contacto;

    public Abogado() {
    }

    public Abogado(int idAbogado, String nombre, String especialidad, String contacto) {
        this.idAbogado = idAbogado;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.contacto = contacto;
    }

    public int getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(int idAbogado) {
        this.idAbogado = idAbogado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return nombre; // Solo devuelve el nombre del abogado
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
