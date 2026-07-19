package com.tiendakss.controlador;

import com.tiendakss.dao.ProductoDAO;
import com.tiendakss.modelo.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Esta anotación mapea la URL del formulario con este Servlet
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
    
    private ProductoDAO productoDAO = new ProductoDAO();

    // El método POST recibe los datos del formulario HTML
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // Atrapamos los parámetros usando el atributo 'name' del HTML
            String nombre = request.getParameter("txtNombre");
            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            int stock = Integer.parseInt(request.getParameter("txtStock"));

            // Instanciamos el modelo con los datos recolectados
            Producto nuevoProducto = new Producto(0, nombre, precio, stock);

            // Ejecutamos la inserción mediante nuestro DAO ya existente
            boolean exito = productoDAO.insertar(nuevoProducto);

            if (exito) {
                // Si guarda, redirigimos a la lista de productos
                response.sendRedirect("listaProductos.jsp");
            } else {
                response.getWriter().println("<h3>Error: No se pudo registrar el producto en la base de datos.</h3>");
            }
            
        } catch (NumberFormatException e) {
            response.getWriter().println("<h3>Error: Datos numéricos inválidos.</h3>");
        }
    }
}