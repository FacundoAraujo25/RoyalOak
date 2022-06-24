package com.NoAutenticados.RoyalOak.dtos;

import com.NoAutenticados.RoyalOak.models.ClienteProductoPedido;
import com.NoAutenticados.RoyalOak.models.Factura;
import com.NoAutenticados.RoyalOak.models.Producto;


public class ClienteProductoPedidoDTO {
    private long id, idFactura;
    private int cantidad;
    private Factura factura;
    private Producto producto;

    public ClienteProductoPedidoDTO() {}

    public ClienteProductoPedidoDTO(ClienteProductoPedido clienteProductoPedido) {
        this.id = clienteProductoPedido.getId();
        this.idFactura = clienteProductoPedido.getFactura().getId();
        this.cantidad = clienteProductoPedido.getCantidad();
        this.factura = clienteProductoPedido.getFactura();
        this.producto = clienteProductoPedido.getProducto();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
