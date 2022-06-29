package com.NoAutenticados.RoyalOak.dtos;

import com.NoAutenticados.RoyalOak.models.ClienteProductoPedido;
import com.NoAutenticados.RoyalOak.models.Factura;
import com.NoAutenticados.RoyalOak.models.Producto;


public class ClienteProductoPedidoDTO {
    private long id;
    private int cantidad;
    private double precio, total;
    private String producto;
    private long idProducto;
    private int stockProducto;

    public ClienteProductoPedidoDTO() {}

    public ClienteProductoPedidoDTO(ClienteProductoPedido clienteProductoPedido) {
        this.id = clienteProductoPedido.getId();
        this.cantidad = clienteProductoPedido.getCantidad();
        this.producto = clienteProductoPedido.getProducto().getNombre();
        this.precio = clienteProductoPedido.getProducto().getPrecio();
        this.total = clienteProductoPedido.getTotal();
        this.idProducto = clienteProductoPedido.getProducto().getId();
        this.stockProducto = clienteProductoPedido.getProducto().getStock();
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
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }
    public int getStockProducto() {
        return stockProducto;
    }
    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }
}
