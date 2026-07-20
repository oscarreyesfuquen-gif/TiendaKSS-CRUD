package com.tiendakss.modelo;

/**
 * Clase que representa la entidad Factura en el sistema Tienda KSS.
 * Cumple con los estándares de codificación JavaBean.
 */
public class Factura {
    private int idFactura;
    private String fecha;
    private String cliente;
    private double total;

    // Constructor vacío
    public Factura() {
    }

    // Constructor con parámetros
    public Factura(int idFactura, String fecha, String cliente, double total) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
    }

    // Métodos Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}