package com.tiendakss.vista;

import com.tiendakss.dao.ProductoDAO;
import com.tiendakss.modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=======================================");
            System.out.println("      SISTEMA CRUD - TIENDA KSS        ");
            System.out.println("=======================================");
            System.out.println("1. Registrar nuevo producto");
            System.out.println("2. Listar todos los productos");
            System.out.println("3. Actualizar un producto");
            System.out.println("4. Eliminar un producto");
            System.out.println("5. Salir del sistema");
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
                                System.out.println("ID: " + p.getIdProducto() + 
                                                   " | Nombre: " + p.getNombre() + 
                                                   " | Precio: $" + p.getPrecio() + 
                                                   " | Stock: " + p.getStock());
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
                        System.out.println("\n¡Gracias por usar el sistema de la Tienda KSS! Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
            }
        } while (opcion != 5);

        teclado.close();
    }
}