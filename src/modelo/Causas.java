package modelo;

/**
 *
 * @author caill
 */
public class Causas {

    private int idCausa;
    private String tipo;
    private String rol;
    private String tribunal;
    private String fecha;
    private String estado;
    private String detalle;
    private int idAbogado;

    public Causas() {
    }

    public Causas(int idCausa, String tipo, String rol, String tribunal, String fecha, String estado, String detalle, int idAbogado) {
        this.idCausa = idCausa;
        this.tipo = tipo;
        this.rol = rol;
        this.tribunal = tribunal;
        this.fecha = fecha;
        this.estado = estado;
        this.detalle = detalle;
        this.idAbogado = idAbogado;
    }

    public int getIdCausa() {
        return idCausa;
    }

    public void setIdCausa(int idCausa) {
        this.idCausa = idCausa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(int idAbogado) {
        this.idAbogado = idAbogado;
    }

    @Override
    public String toString() {
        return "Causas{"
                + "idCausa=" + idCausa
                + ", tipo='" + tipo + '\''
                + ", rol='" + rol + '\''
                + ", tribunal='" + tribunal + '\''
                + ", fecha='" + fecha + '\''
                + ", estado='" + estado + '\''
                + ", detalle='" + detalle + '\''
                + ", idAbogado=" + idAbogado
                + '}';
    }
}
