package com.lab1.lab1_20227191.model;

public class equipo {

    private String nombre;
    private String tipo;
    private String codigoActivo;
    private String fechaAdquisicion;

    //CONSTRUCTOR


    public equipo(String nombre, String tipo, String codigoActivo, String fechaAdquisicion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.codigoActivo = codigoActivo;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    //get and sett

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(String codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }
}
