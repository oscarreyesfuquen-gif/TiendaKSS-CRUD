package com.tiendakss.modelo;

/**
 * Clase de modelo para la entidad Usuario.
 * Adaptada con los métodos requeridos por la interfaz de la vista.
 */
public class Usuario {
    private int idUsuario;
    private String nombreCompleto;
    private String username;
    private String password;
    private String rol;

    // Constructor vacío obligatorio
    public Usuario() {
    }

    // Constructor de 5 parámetros exigido por la vista (Lín. 143)
    public Usuario(int idUsuario, String nombreCompleto, String username, String password, String rol) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    // Métodos específicos requeridos por App.java (Lín. 33, 128)
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

    // Getters y Setters estándar adicionales
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
