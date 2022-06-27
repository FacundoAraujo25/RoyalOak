package com.NoAutenticados.RoyalOak.dtos;

import com.NoAutenticados.RoyalOak.models.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDTO {

    private long id;
    private String nombre, descripcion, imagen;
    private int stock;
    private double precio;
    private boolean activo;
    private List<String> ingredientes = new ArrayList<>();

    public ProductoDTO() {}

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.imagen = producto.getImagen();
        this.stock = producto.getStock();
        this.precio = producto.getPrecio();
        this.ingredientes = producto.getIngredientes();
        this.activo = producto.isActivo();
    }

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public List<String> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
