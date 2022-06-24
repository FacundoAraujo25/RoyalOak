package com.NoAutenticados.RoyalOak.dtos;

import com.NoAutenticados.RoyalOak.models.Cliente;
import com.NoAutenticados.RoyalOak.models.Factura;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteDTO {

    private long id;

    private String nombre,apellido,email,telefono;
    private Set<String> direcciones;
    private Set<Factura>facturas = new HashSet<>();


    public ClienteDTO () {}

    public ClienteDTO (Cliente cliente){
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.email = cliente.getEmail();
        this.telefono = cliente.getTelefono();
        this.direcciones = cliente.getDirecciones();
        this.facturas = cliente.getFacturas();

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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set<String> getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(Set<String> direcciones) {
        this.direcciones = direcciones;
    }
    public Set<Factura> getFacturas() {
        return facturas;
    }
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }
}
