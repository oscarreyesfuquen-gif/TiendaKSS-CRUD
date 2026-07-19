<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tiendakss.dao.ProductoDAO" %>
<%@ page import="com.tiendakss.modelo.Producto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Tienda KSS - Inventario</title>
</head>
<body>
    <h2>📋 Inventario de Productos Registrados</h2>
    <hr>
    
    <table border="1" cellpadding="8" cellspacing="0">
        <thead style="background-color: #f2f2f2;">
            <tr>
                <th>ID</th>
                <th>Nombre del Producto</th>
                <th>Precio Unitario</th>
                <th>Stock Disponible</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Aquí usamos código Java puro gracias a JSP para traer la lista en tiempo real
                ProductoDAO productoDAO = new ProductoDAO();
                List<Producto> lista = productoDAO.listar();
                
                if (lista == null || lista.isEmpty()) {
            %>
                <tr>
                    <td colspan="4" style="text-align: center;">No hay productos registrados en la base de datos.</td>
                </tr>
            <%
                } else {
                    for (Producto p : lista) {
            %>
                <tr>
                    <td><%= p.getIdProducto() %></td>
                    <td><%= p.getNombre() %></td>
                    <td>$<%= p.getPrecio() %></td>
                    <td><%= p.getStock() %> unidades</td>
                </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    
    <br>
    <a href="index.jsp"><button>Volver al Menú Principal</button></a>
    <a href="formularioProducto.html"><button>Registrar Otro Producto</button></a>
</body>
</html>