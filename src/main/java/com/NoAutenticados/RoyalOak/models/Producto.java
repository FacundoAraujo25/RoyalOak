package com.NoAutenticados.RoyalOak.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy =  "native")
    private long id;
    private String nombre, descripcion, imagen;
    private int stock;
    private double precio;
    private Tipo tipo;
    private Subtipo subtipo;
    @ElementCollection
    @Column(name="ingredientes")
    private List<String> ingredientes = new ArrayList<>();

    @OneToMany(mappedBy="producto", fetch=FetchType.EAGER)
    private Set<ClienteProductoPedido> clienteProductoPedidos = new HashSet<>();
    private boolean activo;

    public Producto() {}

    public Producto(String nombre, String descripcion, String imagen, int stock, double precio, Tipo tipo, Subtipo subtipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.stock = stock;
        this.precio = precio;
        this.activo = false;
        this.tipo = tipo;
        this.subtipo = subtipo;
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
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public Subtipo getSubtipo() {
        return subtipo;
    }
    public void setSubtipo(Subtipo subtipo) {
        this.subtipo = subtipo;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Set<ClienteProductoPedido> getClienteProductoPedidos() {
        return clienteProductoPedidos;
    }
    public void setClienteProductoPedidos(Set<ClienteProductoPedido> clienteProductoPedidos) {
        this.clienteProductoPedidos = clienteProductoPedidos;
    }
    public Set<Factura> getFacturas(){
        return clienteProductoPedidos.stream().map(factura -> factura.getFactura()).collect(Collectors.toSet());
    }
    public void addClienteProductoPedido(ClienteProductoPedido clienteProductoPedido) {
        clienteProductoPedido.setProducto(this);
        clienteProductoPedidos.add(clienteProductoPedido);
    }
}
