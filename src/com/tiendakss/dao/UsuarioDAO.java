package com.tiendakss.dao;

import java.util.ArrayList;
import java.util.List;
import com.tiendakss.modelo.Usuario;

/**
 * Clase DAO para la entidad Usuario.
 * Retorna un objeto Usuario válido para cumplir con el inicio de sesión de App.java.
 */
public class UsuarioDAO {

  public Usuario validarLogin(String username, String password) {
        // Cambio "Administrador KSS" por mi nombre propio
        Usuario usuarioSimulado = new Usuario(1, "Oscar Reyes Fuquen", username, password, "Administrador");
        return usuarioSimulado;
    }

    public boolean insertar(Usuario usuario) {
        return true;
    }

    public List<Usuario> listar() {
        return new ArrayList<>();
    }
}