package com.NoAutenticados.RoyalOak.services.implementacion;

import com.NoAutenticados.RoyalOak.dtos.FacturaDTO;
import com.NoAutenticados.RoyalOak.repositories.FacturaRepositorio;
import com.NoAutenticados.RoyalOak.services.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FacturaServicioImp implements FacturaServicio {
    @Autowired
    FacturaRepositorio facturaRepositorio;

    @Override
    public Set<FacturaDTO> getFacturasDTO() {
        return facturaRepositorio.findAll().stream().map(factura -> new FacturaDTO(factura)).collect(Collectors.toSet());
    }
}
