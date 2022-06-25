package com.NoAutenticados.RoyalOak.controllers;

import com.NoAutenticados.RoyalOak.dtos.ClienteDTO;
import com.NoAutenticados.RoyalOak.models.Cliente;
import com.NoAutenticados.RoyalOak.repositories.ClienteRepositorio;
import com.NoAutenticados.RoyalOak.services.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/clientes")
    public ResponseEntity<Object> registrarCliente(@RequestParam String nombre,
                                           @RequestParam String apellido,
                                           @RequestParam String email,
                                           @RequestParam String telefono,
                                           @RequestParam String direccion,
                                           @RequestParam String contraseña){

        if(nombre.isEmpty()){
            return new ResponseEntity<>("Faltan datos: Nombre", HttpStatus.FORBIDDEN);
        }
        if(apellido.isEmpty()){
            return new ResponseEntity<>("Faltan datos: Apellido", HttpStatus.FORBIDDEN);
        }
        if(email.isEmpty()){
            return new ResponseEntity<>("Faltan datos: Email", HttpStatus.FORBIDDEN);
        }
        if(telefono.isEmpty()){
            return new ResponseEntity<>("Faltan datos: Telefono", HttpStatus.FORBIDDEN);
        }
        if(direccion.isEmpty()){
            return new ResponseEntity<>("Faltan datos: Dirección", HttpStatus.FORBIDDEN);
        }
        if(contraseña.isEmpty()){
            return new ResponseEntity<>("Faltan datos: Contraseña", HttpStatus.FORBIDDEN);
        }
        if(clienteServicio.findByEmail(email) != null){
            return new ResponseEntity<>("El email ingresado ya existe", HttpStatus.FORBIDDEN);
        }
        if(clienteServicio.findByTelefono(telefono) != null){
            return new ResponseEntity<>("El telefono ingresado ya existe", HttpStatus.FORBIDDEN);
        }
        Cliente cliente = new Cliente(nombre, apellido,email,telefono, contraseña);
        cliente.addDireccion(direccion);
        clienteRepositorio.save(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
