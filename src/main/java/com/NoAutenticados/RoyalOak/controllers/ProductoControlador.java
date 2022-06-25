package com.NoAutenticados.RoyalOak.controllers;

import com.NoAutenticados.RoyalOak.dtos.ProductoDTO;
import com.NoAutenticados.RoyalOak.models.Producto;
import com.NoAutenticados.RoyalOak.services.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<ProductoDTO> getAll(){
        return productoServicio.getAll();
    }

    @PostMapping("/productos")
    public ResponseEntity<Object> agregarProductos(@RequestParam String nombre,
                                                   @RequestParam String descripcion,
                                                   @RequestParam String imagen,
                                                   @RequestParam int stock,
                                                   @RequestParam double precio,
                                                   @RequestParam int stock,
                                                   @RequestParam String ingredientes,
                                                   @RequestParam boolean activo) {

        if(nombre.isEmpty()){
            return new ResponseEntity<>("Faltan datos: Nombre", HttpStatus.FORBIDDEN);
        }
        if(descripcion.isEmpty()){
            return new ResponseEntity<>("Faltan datos: Descripcion", HttpStatus.FORBIDDEN);
        }
        if(imagen.isEmpty()){
            return new ResponseEntity<>("Faltan datos: url imagen", HttpStatus.FORBIDDEN);
        }
        if(stock < 0){
            return new ResponseEntity<>("Stock debe ser mayor o igual a 0", HttpStatus.FORBIDDEN);
        }
        if(precio < 0){
              return new ResponseEntity<>("El precio no puede ser menor o igual a 0", HttpStatus.FORBIDDEN);
        }
        if(ingredientes.isEmpty()){
            return new ResponseEntity<>("Faltan datos: Ingredientes", HttpStatus.FORBIDDEN);
        }


        String[] ingredientesArray = ingredientes.split(" ");
        Producto producto = new Producto(nombre, descripcion, imagen, stock, precio);
        producto.setIngredientes(Arrays.stream(ingredientesArray).collect(Collectors.toList()));
        productoServicio.guardarProducto(producto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
