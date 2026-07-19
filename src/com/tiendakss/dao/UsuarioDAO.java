package com.tiendakss.dao;

import com.tiendakss.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // 1. REGISTRAR UN NUEVO USUARIO
    public boolean insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre_completo, username, password, rol) VALUES (?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombreCompleto());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getRol());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    // 2. LISTAR TODOS LOS USUARIOS
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombreCompleto(rs.getString("nombre_completo"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRol(rs.getString("rol"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    // 3. VALIDAR LOGIN (Función de seguridad)
    public Usuario validarLogin(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setIdUsuario(rs.getInt("id_usuario"));
                    u.setNombreCompleto(rs.getString("nombre_completo"));
                    u.setUsername(rs.getString("username"));
                    u.setRol(rs.getString("rol"));
                    return u; // Retorna el usuario si las credenciales son correctas
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la validación de login: " + e.getMessage());
        }
        return null; // Retorna null si no encuentra coincidencia
    }
}