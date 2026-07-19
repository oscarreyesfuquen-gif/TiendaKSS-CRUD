package com.tiendakss.vista;

import com.tiendakss.dao.ProductoDAO;
import com.tiendakss.dao.UsuarioDAO;
import com.tiendakss.dao.ClienteDAO;
import com.tiendakss.dao.ProveedorDAO;
import com.tiendakss.modelo.Producto;
import com.tiendakss.modelo.Usuario;
import com.tiendakss.modelo.Cliente;
import com.tiendakss.modelo.Proveedor;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("=======================================");
        System.out.println("   INGRESO AL SISTEMA - TIENDA KSS    ");
        System.out.println("=======================================");
        System.out.print("Username: ");
        String userLogin = teclado.nextLine();
        System.out.print("Contraseña: ");
        String passLogin = teclado.nextLine();

        Usuario usuarioLogueado = usuarioDAO.validarLogin(userLogin, passLogin);

        if (usuarioLogueado != null) {
            System.out.println("\n¡Bienvenido/a al sistema, " + usuarioLogueado.getNombreCompleto() + "!");
            System.out.println("Rol actual: [" + usuarioLogueado.getRol() + "]");
            
            int opcion = 0;
            do {
                System.out.println("\n=======================================");
                System.out.println("      SISTEMA CRUD - TIENDA KSS        ");
                System.out.println("=======================================");
                System.out.println("1. Registrar nuevo producto");
                System.out.println("2. Listar todos los productos");
                System.out.println("3. Actualizar un producto");
                System.out.println("4. Eliminar un producto");
                System.out.println("5. Ver usuarios del sistema");
                System.out.println("6. Registrar nuevo usuario");
                System.out.println("7. Ver clientes registrados");
                System.out.println("8. Registrar nuevo cliente");
                System.out.println("9. Ver proveedores registrados");
                System.out.println("10. Registrar nuevo proveedor");
                System.out.println("11. Salir del sistema");
                System.out.print("Seleccione una opción: ");
                
                try {
                    opcion = Integer.parseInt(teclado.nextLine());
                    
                    switch (opcion) {
                        case 1:
                            System.out.println("\n--- Registrar Producto ---");
                            System.out.print("Nombre del producto: ");
                            String nombre = teclado.nextLine();
                            System.out.print("Precio: ");
                            double precio = Double.parseDouble(teclado.nextLine());
                            System.out.print("Stock inicial: ");
                            int stock = Integer.parseInt(teclado.nextLine());

                            Producto nuevo = new Producto(0, nombre, precio, stock);
                            if (productoDAO.insertar(nuevo)) {
                                System.out.println("¡Producto registrado con éxito!");
                            } else {
                                System.out.println("No se pudo registrar el producto.");
                            }
                            break;

                        case 2:
                            System.out.println("\n--- Lista de Productos ---");
                            List<Producto> lista = productoDAO.listar();
                            if (lista.isEmpty()) {
                                System.out.println("No hay productos registrados en la base de datos.");
                            } else {
                                for (Producto p : lista) {
                                    System.out.println("ID: " + p.getIdProducto() + " | Nombre: " + p.getNombre() + " | Precio: $" + p.getPrecio() + " | Stock: " + p.getStock());
                                }
                            }
                            break;

                        case 3:
                            System.out.println("\n--- Actualizar Producto ---");
                            System.out.print("Ingrese el ID del producto a modificar: ");
                            int idAct = Integer.parseInt(teclado.nextLine());
                            System.out.print("Nuevo nombre: ");
                            String nomAct = teclado.nextLine();
                            System.out.print("Nuevo precio: ");
                            double preAct = Double.parseDouble(teclado.nextLine());
                            System.out.print("Nuevo stock: ");
                            int stkAct = Integer.parseInt(teclado.nextLine());

                            Producto modificado = new Producto(idAct, nomAct, preAct, stkAct);
                            if (productoDAO.actualizar(modificado)) {
                                System.out.println("¡Producto actualizado correctamente!");
                            } else {
                                System.out.println("Error: Verifique el ID o la conexión.");
                            }
                            break;

                        case 4:
                            System.out.println("\n--- Eliminar Producto ---");
                            System.out.print("Ingrese el ID del producto que desea borrar: ");
                            int idEli = Integer.parseInt(teclado.nextLine());
                            System.out.print("¿Está seguro de eliminar el producto? (S/N): ");
                            String confirma = teclado.nextLine();

                            if (confirma.equalsIgnoreCase("S")) {
                                if (productoDAO.eliminar(idEli)) {
                                    System.out.println("¡Producto eliminado exitosamente!");
                                } else {
                                    System.out.println("No se pudo eliminar el producto.");
                                }
                            } else {
                                System.out.println("Operación cancelada.");
                            }
                            break;

                        case 5:
                            System.out.println("\n--- Lista de Usuarios del Sistema ---");
                            List<Usuario> listaU = usuarioDAO.listar();
                            for (Usuario u : listaU) {
                                System.out.println("ID: " + u.getIdUsuario() + " | Nombre: " + u.getNombreCompleto() + " | Username: " + u.getUsername() + " | Rol: " + u.getRol());
                            }
                            break;

                        case 6:
                            System.out.println("\n--- Registrar Nuevo Usuario ---");
                            System.out.print("Nombre completo: ");
                            String nomComp = teclado.nextLine();
                            System.out.print("Username para el login: ");
                            String uName = teclado.nextLine();
                            System.out.print("Contraseña: ");
                            String uPass = teclado.nextLine();
                            System.out.print("Rol (Administrador/Vendedor): ");
                            String uRol = teclado.nextLine();

                            Usuario nuevoU = new Usuario(0, nomComp, uName, uPass, uRol);
                            if (usuarioDAO.insertar(nuevoU)) {
                                System.out.println("¡Usuario registrado exitosamente!");
                            } else {
                                System.out.println("Error al guardar el usuario.");
                            }
                            break;

                        case 7:
                            System.out.println("\n--- Lista de Clientes Registrados ---");
                            List<Cliente> listaC = clienteDAO.listar();
                            if (listaC.isEmpty()) {
                                System.out.println("No hay clientes registrados.");
                            } else {
                                for (Cliente c : listaC) {
                                    System.out.println("ID: " + c.getIdCliente() + " | Doc: " + c.getDocumento() + " | Nombre: " + c.getNombre() + " | Tel: " + c.getTelefono());
                                }
                            }
                            break;

                        case 8:
                            System.out.println("\n--- Registrar Nuevo Cliente ---");
                            System.out.print("Documento: ");
                            String doc = teclado.nextLine();
                            System.out.print("Nombre completo: ");
                            String nomCli = teclado.nextLine();
                            System.out.print("Teléfono: ");
                            String telCli = teclado.nextLine();
                            System.out.print("Correo: ");
                            String correoCli = teclado.nextLine();

                            Cliente nuevoC = new Cliente(0, doc, nomCli, telCli, correoCli);
                            if (clienteDAO.insertar(nuevoC)) {
                                System.out.println("¡Cliente registrado exitosamente!");
                            } else {
                                System.out.println("Error al guardar el cliente.");
                            }
                            break;

                        case 9:
                            System.out.println("\n--- Lista de Proveedores ---");
                            List<Proveedor> listaP = proveedorDAO.listar();
                            if (listaP.isEmpty()) {
                                System.out.println("No hay proveedores registrados.");
                            } else {
                                for (Proveedor p : listaP) {
                                    System.out.println("ID: " + p.getIdProveedor() + " | NIT/RUT: " + p.getNitRut() + " | Razón Social: " + p.getRazonSocial() + " | Contacto: " + p.getContacto());
                                }
                            }
                            break;

                        case 10:
                            System.out.println("\n--- Registrar Nuevo Proveedor ---");
                            System.out.print("NIT / RUT: ");
                            String nit = teclado.nextLine();
                            System.out.print("Razón Social (Nombre Empresa): ");
                            String razon = teclado.nextLine();
                            System.out.print("Nombre de Contacto: ");
                            String cont = teclado.nextLine();
                            System.out.print("Teléfono: ");
                            String telProv = teclado.nextLine();
                            System.out.print("Dirección: ");
                            String dirProv = teclado.nextLine();

                            Proveedor nuevoP = new Proveedor(0, nit, razon, cont, telProv, dirProv);
                            if (proveedorDAO.insertar(nuevoP)) {
                                System.out.println("¡Proveedor registrado con éxito!");
                            } else {
                                System.out.println("Error al guardar el proveedor. Verifique que el NIT no esté repetido.");
                            }
                            break;

                        case 11:
                            System.out.println("\n¡Gracias por usar la Tienda KSS! Cerrando sesión...");
                            break;

                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingrese un número válido.");
                }
            } while (opcion != 11);

        } else {
            System.out.println("\n[ERROR]: Credenciales incorrectas. Acceso denegado.");
        }

        teclado.close();
    }
}
