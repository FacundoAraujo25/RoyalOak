package com.NoAutenticados.RoyalOak.services;

import com.NoAutenticados.RoyalOak.dtos.ProductoDTO;
import com.NoAutenticados.RoyalOak.models.Producto;

import java.util.List;

public interface ProductoServicio {
    List<ProductoDTO> getAll();
    void guardarProducto (Producto producto);
    Producto findById(long id);
}
