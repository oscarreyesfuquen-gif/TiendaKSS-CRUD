package com.tiendakss.modelo;

public class Producto {
    // Variables según los estándares (empiezan en minúscula)
    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor vacío (obligatorio en muchos estándares)
    public Producto() {}

    // Constructor con parámetros para registrar datos fácilmente
    public Producto(int idProducto, String nombre, double precio, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos de encapsulamiento Getters y Setters (Estándar de nombramiento)
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}