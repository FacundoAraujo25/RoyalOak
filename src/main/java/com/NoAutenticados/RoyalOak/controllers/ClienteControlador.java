package com.NoAutenticados.RoyalOak.controllers;

import com.NoAutenticados.RoyalOak.dtos.ClienteDTO;
import com.NoAutenticados.RoyalOak.repositories.ClienteRepositorio;
import com.NoAutenticados.RoyalOak.services.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteControlador {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Autowired
    ClienteServicio clienteServicio;


    @RequestMapping("/clientes") //asigna ruta a un controlador específico
    public List<ClienteDTO> getClientes() {

        //return clientRepository.findAll().stream().map(client -> new ClientDTO(client)).collect(toList());
//La función stream permite procesar y transformar (con map) cada elemento de la lista que retorna findAll(), map ejecuta el constructor de la clase ClientDTO y le pasa como parámetro el elemento Client que está procesando en ese momento

//se puede simplificar un poco, como lo único que hace map es ejecutar el método constructor que está en ClientDTO, se puede indicar la referencia a ese método sin tener que declarar toda una expresión lambda:
        return clienteServicio.getClientesDto();

    }

    @RequestMapping("clientes/{id}")
    public ClienteDTO getCliente(@PathVariable Long id) {

        return clienteServicio.getCliente(id);

    }


    //@RequestMapping("/clients/current")

    //public ClienteDTO getAll(Authentication authentication) {

        //return clientService.getCurrentClient(authentication.getName());   //getName = getUsernameParameter("mail")

        //return new ClienteDTO(clienteRepositorio.findByEmail(authentication.getName()));

    //}


}
