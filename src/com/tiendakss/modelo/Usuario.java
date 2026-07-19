package com.tiendakss.modelo;

public class Usuario {
    private int idUsuario;
    private String nombreCompleto;
    private String username;
    private String password;
    private String rol;

    // Constructor vacío (necesario para cuando listamos datos)
    public Usuario() {
    }

    // Constructor con todos los parámetros (para registrar o actualizar)
    public Usuario(int idUsuario, String nombreCompleto, String username, String password, String rol) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    // Métodos Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}