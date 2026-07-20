package com.tiendakss.dao;

import java.util.ArrayList;
import java.util.List;
import com.tiendakss.modelo.Factura;

/**
 * Clase DAO para gestionar las operaciones simuladas de Facturación.
 */
public class FacturaDAO {

    // Simula la creación o registro de una nueva factura
    public boolean registrarFactura(Factura factura) {
        return true;
    }

    // Simula la consulta o listado de todas las facturas emitidas
    public List<Factura> listarFacturas() {
        List<Factura> lista = new ArrayList<>();
        // Agregamos una factura de prueba para verificar el flujo
        lista.add(new Factura(1001, "19/07/2026", "Cliente General", 150000.0));
        return lista;
    }
}
