package com.NoAutenticados.RoyalOak.dtos;

import com.NoAutenticados.RoyalOak.models.ClienteProductoPedido;
import com.NoAutenticados.RoyalOak.models.Factura;
import com.NoAutenticados.RoyalOak.models.Producto;
import com.itextpdf.text.pdf.PdfPCell;


public class ClienteProductoPedidoDTO {
    private long id;
    private int cantidad;
    private double precio;
    private double total;
    private String producto;

    public ClienteProductoPedidoDTO() {}

    public ClienteProductoPedidoDTO(ClienteProductoPedido clienteProductoPedido) {
        this.id = clienteProductoPedido.getId();
        this.cantidad = clienteProductoPedido.getCantidad();
        this.producto = clienteProductoPedido.getProducto().getNombre();
        this.precio = clienteProductoPedido.getProducto().getPrecio();
        this.total = clienteProductoPedido.getTotal();
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
}
