package com.NoAutenticados.RoyalOak.dtos;

import com.NoAutenticados.RoyalOak.models.Cliente;
import com.NoAutenticados.RoyalOak.models.Factura;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class FacturaDTO {
    private long id;
    private Cliente cliente;
    private double total;
    private Set<ClienteProductoPedidoDTO> pedidos = new HashSet<>();

    public FacturaDTO() {
    }

    public FacturaDTO(Factura factura) {
        this.id = factura.getId();
        this.cliente = factura.getCliente();
        this.total = factura.getTotal();
        this.pedidos = factura.getClienteProductoPedidos().stream().map(clienteProductoPedido -> new ClienteProductoPedidoDTO(clienteProductoPedido)).collect(Collectors.toSet());
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
