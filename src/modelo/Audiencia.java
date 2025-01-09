package modelo;

import java.util.Date;

/**
 *
 * @author caill
 */
public class Audiencia {

    private int idAudiencia;
    private int idAbogado;
    private String tipo;
    private String rol;
    private String tribunal;
    private String fecha;
    private String hora;
    private String lugar;
    private String estado;
    private String observaciones;

    public Audiencia() {
    }

    public Audiencia(int idAudiencia, int idAbogado, String tipo, String rol, String tribunal, String fecha, String hora, String lugar, String estado, String observaciones) {
        this.idAudiencia = idAudiencia;
        this.idAbogado = idAbogado;
        this.tipo = tipo;
        this.rol = rol;
        this.tribunal = tribunal;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public int getIdAudiencia() {
        return idAudiencia;
    }

    public void setIdAudiencia(int idAudiencia) {
        this.idAudiencia = idAudiencia;
    }

    public int getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(int idAbogado) {
        this.idAbogado = idAbogado;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Audiencia{" + "idAudiencia=" + idAudiencia + ", idAbogado=" + idAbogado + ", tipo=" + tipo + ", rol=" + rol + ", tribunal=" + tribunal + ", fecha=" + fecha + ", hora=" + hora + ", lugar=" + lugar + ", estado=" + estado + ", observaciones=" + observaciones + '}';
    }

    
}
