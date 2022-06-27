package com.NoAutenticados.RoyalOak.services;

import com.NoAutenticados.RoyalOak.dtos.FacturaDTO;
import com.NoAutenticados.RoyalOak.models.Factura;

import java.util.Set;

public interface FacturaServicio {
    Set<FacturaDTO> getFacturasDTO();
    Factura getFacturaEnCarrito();
    void guardarFactura(Factura factura);
}
