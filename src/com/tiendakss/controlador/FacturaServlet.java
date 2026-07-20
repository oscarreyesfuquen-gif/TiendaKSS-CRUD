package com.tiendakss.controlador;

import java.util.List;
import com.tiendakss.dao.FacturaDAO;
import com.tiendakss.modelo.Factura;

/**
 * Controlador Servlet simulado para exponer el módulo de Facturas en entorno Web.
 */
public class FacturaServlet {

    private FacturaDAO facturaDAO = new FacturaDAO();

    // Simulación de petición GET para listar facturas en la web
    public void procesarListado() {
        List<Factura> facturas = facturaDAO.listarFacturas();
        System.out.println("[Servlet Web] Procesando solicitudes de facturación... Total encontradas: " + facturas.size());
    }
}