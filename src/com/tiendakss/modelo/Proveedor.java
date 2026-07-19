package com.tiendakss.modelo;

public class Proveedor {
    private int idProveedor;
    private String nitRut;
    private String razonSocial;
    private String contacto;
    private String telefono;
    private String direccion;

    // Constructor vacío
    public Proveedor() {
    }

    // Constructor con parámetros
    public Proveedor(int idProveedor, String nitRut, String razonSocial, String contacto, String telefono, String direccion) {
        this.idProveedor = idProveedor;
        this.nitRut = nitRut;
        this.razonSocial = razonSocial;
        this.contacto = contacto;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Métodos Getters y Setters
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNitRut() {
        return nitRut;
    }

    public void setNitRut(String nitRut) {
        this.nitRut = nitRut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
