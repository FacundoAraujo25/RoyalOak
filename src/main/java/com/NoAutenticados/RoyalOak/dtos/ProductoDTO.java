package com.NoAutenticados.RoyalOak.dtos;

import com.NoAutenticados.RoyalOak.models.Producto;
import com.NoAutenticados.RoyalOak.models.Subtipo;
import com.NoAutenticados.RoyalOak.models.Tipo;

import java.util.ArrayList;
import java.util.List;

public class ProductoDTO {

    private long id;
    private String nombre, descripcion, imagen;
    private int stock;
    private double precio;
    private boolean activo;
    private Tipo tipo;
    private Subtipo subtipo;


    public ProductoDTO() {}

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.imagen = producto.getImagen();
        this.stock = producto.getStock();
        this.precio = producto.getPrecio();
        this.activo = producto.isActivo();
        this.tipo = producto.getTipo();
        this.subtipo = producto.getSubtipo();
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

    public Tipo getTipo() {
        return tipo;
    }
    public Subtipo getSubtipo() {
        return subtipo;
    }

    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
