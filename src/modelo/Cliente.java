package modelo;

/**
 *
 * @author caill
 */
public class Cliente {

    private int idCliente;
    private String nombre;
    private String rut;
    private String contacto;
    private String direccion;
    private String nota;
    private int idAbogado;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String rut, String contacto, String direccion, String nota, int idAbogado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.rut = rut;
        this.contacto = contacto;
        this.direccion = direccion;
        this.nota = nota;
        this.idAbogado = idAbogado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(int idAbogado) {
        this.idAbogado = idAbogado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", rut=" + rut + ", contacto=" + contacto + ", direccion=" + direccion + ", nota=" + nota + ", idAbogado=" + idAbogado + '}';
    }

  
}
