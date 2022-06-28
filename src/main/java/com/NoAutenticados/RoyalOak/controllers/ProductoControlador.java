package com.NoAutenticados.RoyalOak.controllers;

import com.NoAutenticados.RoyalOak.dtos.ProductoDTO;
import com.NoAutenticados.RoyalOak.models.Producto;
import com.NoAutenticados.RoyalOak.models.SubTipo;
import com.NoAutenticados.RoyalOak.models.Tipo;
import com.NoAutenticados.RoyalOak.services.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                                                   @RequestParam double precio,
                                                   @RequestParam int stock,
                                                   @RequestParam String ingredientes,
                                                   @RequestParam boolean activo,
                                                   @RequestParam Tipo tipo,
                                                   @RequestParam SubTipo subTipo) {

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
        if(tipo.toString().isEmpty()){
            return new ResponseEntity<>("Faltan datos: Tipo", HttpStatus.FORBIDDEN);
        }
        if(subTipo.toString().isEmpty()){
            return new ResponseEntity<>("Faltan datos: SubTipo", HttpStatus.FORBIDDEN);
        }
        String[] ingredientesArray = ingredientes.split(" ");
        Producto producto = new Producto(nombre, descripcion, imagen,stock, precio, tipo, subTipo);
        producto.setActivo(activo);
        producto.setIngredientes(Arrays.stream(ingredientesArray).collect(Collectors.toList()));
        productoServicio.guardarProducto(producto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PatchMapping("/productos")
    public ResponseEntity<Object> modificarProductos(@RequestParam String nombre,
                                                   @RequestParam String descripcion,
                                                   @RequestParam String imagen,
                                                   @RequestParam double precio,
                                                   @RequestParam int stock,
                                                   @RequestParam String ingredientes,
                                                   @RequestParam boolean activo,
                                                   @RequestParam long idProducto,
                                                   @RequestParam Tipo tipo,
                                                   @RequestParam SubTipo subTipo) {


        if(productoServicio.findById(idProducto)==null)
        {
            return new ResponseEntity<>("El producto no existe.", HttpStatus.FORBIDDEN);
        }

        Producto producto = productoServicio.findById(idProducto);

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
        if(tipo.toString().isEmpty()){
            return new ResponseEntity<>("Faltan datos: Tipo", HttpStatus.FORBIDDEN);
        }
        if(subTipo.toString().isEmpty()){
            return new ResponseEntity<>("Faltan datos: SubTipo", HttpStatus.FORBIDDEN);
        }

        String[] ingredientesArray = ingredientes.split(" ");
        producto.setIngredientes(Arrays.stream(ingredientesArray).collect(Collectors.toList()));

        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setImagen(imagen);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setActivo(activo);
        producto.setTipo(tipo);
        producto.setSubTipo(subTipo);
        productoServicio.guardarProducto(producto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/productos")
    public ResponseEntity<Object> borrarProducto(@RequestParam long idProducto){

        if(productoServicio.findById(idProducto)==null)
        {
            return new ResponseEntity<>("El producto no existe.", HttpStatus.FORBIDDEN);
        }
        Producto producto = productoServicio.findById(idProducto);
        producto.setActivo(false);
        productoServicio.guardarProducto(producto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
