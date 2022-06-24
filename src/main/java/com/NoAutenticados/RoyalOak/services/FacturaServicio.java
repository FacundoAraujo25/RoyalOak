package com.NoAutenticados.RoyalOak.services;

import com.NoAutenticados.RoyalOak.dtos.FacturaDTO;

import java.util.Set;

public interface FacturaServicio {
    Set<FacturaDTO> getFacturasDTO();
}
