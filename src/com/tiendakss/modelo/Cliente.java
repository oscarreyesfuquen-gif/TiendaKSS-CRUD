package com.tiendakss.modelo;

public class Cliente {
    private int idCliente;
    private String documento;
    private String nombre;
    private String telefono;
    private String correo;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(int idCliente, String documento, String nombre, String telefono, String correo) {
        this.idCliente = idCliente;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Métodos Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }
}