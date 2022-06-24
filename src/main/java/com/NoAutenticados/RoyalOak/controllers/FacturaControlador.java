package com.NoAutenticados.RoyalOak.controllers;

import com.NoAutenticados.RoyalOak.dtos.FacturaDTO;
import com.NoAutenticados.RoyalOak.services.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class FacturaControlador {
    @Autowired
    private FacturaServicio facturaServicio;

    @GetMapping("/facturas")
    public Set<FacturaDTO> getFacturasDTO(){
        return facturaServicio.getFacturasDTO();
    }
}
