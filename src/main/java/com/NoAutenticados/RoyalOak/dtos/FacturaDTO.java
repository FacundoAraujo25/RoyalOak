package com.NoAutenticados.RoyalOak.dtos;

import com.NoAutenticados.RoyalOak.models.Cliente;
import com.NoAutenticados.RoyalOak.models.Factura;


public class FacturaDTO {
    private long id;
    private Cliente cliente;
    private double total;

    public FacturaDTO() {
    }

    public FacturaDTO(Factura factura) {
        this.id = factura.getId();
        this.cliente = factura.getCliente();
        this.total = factura.getTotal();
    }

    public long getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}
