package com.NoAutenticados.RoyalOak.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ClienteProductoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private int cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="factura_id")
    private Factura factura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="producto_id")
    private Producto producto;

    public ClienteProductoPedido() {}

    public ClienteProductoPedido(int cantidad, Factura factura, Producto producto) {
        this.cantidad = cantidad;
        this.factura = factura;
        this.producto = producto;
    }

    public long getId() {
        return id;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
