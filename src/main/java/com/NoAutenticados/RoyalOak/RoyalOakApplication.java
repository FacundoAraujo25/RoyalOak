package com.NoAutenticados.RoyalOak;

import com.NoAutenticados.RoyalOak.models.*;
import com.NoAutenticados.RoyalOak.repositories.ClienteProductoPedidoRepositorio;
import com.NoAutenticados.RoyalOak.repositories.ClienteRepositorio;
import com.NoAutenticados.RoyalOak.repositories.FacturaRepositorio;
import com.NoAutenticados.RoyalOak.repositories.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class RoyalOakApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoyalOakApplication.class, args);
	}

	@Autowired
	public PasswordEncoder passwordEncoder;
	@Bean
	public CommandLineRunner initData(ClienteRepositorio clienteRepositorio, ProductoRepositorio productoRepositorio, FacturaRepositorio facturaRepositorio, ClienteProductoPedidoRepositorio clienteProductoPedidoRepositorio){
		return (args) -> {
			Cliente cliente1 = new Cliente("Esteban", "Casile", "esteban@gmail.com", "98735435", "123");
			Cliente cliente2 = new Cliente("Facu", "Araujo", "facu@gmail.com", "264654564", "123");
			Cliente cliente3 = new Cliente("Daphne", "Collao", "daphnecollao@gmail.com", "5649848594", "123");
			Cliente cliente4 = new Cliente("Nacho", "Ferrero", "nacho@gmail.com", "78895656", passwordEncoder.encode("123"));
			Cliente cliente5 = new Cliente("Andres", "Garcia", "andres@gmail.com", "84354635", "123");
			Cliente cliente6 = new Cliente("Caro", "Cardiello", "caro@gmail.com", "48964564564", "123");
			Cliente cliente7 = new Cliente("Walter", "Peralta", "walter@gmail.com", "6573575357", "123");
			String direccion = "Cordoba";
			String direccion1 = "San Juan";
			String direccion2 = "Salta";
			cliente1.setRolUsuario(RolUsuario.ADMIN);
			cliente2.setRolUsuario(RolUsuario.ADMIN);
			cliente3.setRolUsuario(RolUsuario.ADMIN);
			cliente1.addDireccion(direccion);
			cliente2.addDireccion(direccion1);
			cliente3.addDireccion(direccion2);
			cliente4.addDireccion(direccion1);
			cliente5.addDireccion(direccion);
			cliente6.addDireccion(direccion2);
			cliente7.addDireccion(direccion1);
			cliente1.addDireccion(direccion1);
			cliente1.setEnable(true);
			cliente2.setEnable(true);
			cliente3.setEnable(true);
			cliente4.setEnable(true);
			cliente5.setEnable(true);
			cliente6.setEnable(true);
			cliente7.setEnable(true);
			clienteRepositorio.save(cliente1);
			clienteRepositorio.save(cliente2);
			clienteRepositorio.save(cliente3);
			clienteRepositorio.save(cliente4);
			clienteRepositorio.save(cliente5);
			clienteRepositorio.save(cliente6);
			clienteRepositorio.save(cliente7);
			Producto producto1 = new Producto("Hamburguesa", "Gorda, grande y jugosa", "urlDeImagen", 25, 550);
			Producto producto2 = new Producto("Lomito Veggie","pan ciabatta, bife de seitan","urlImagen",20,650);
			Producto producto3 = new Producto("Bastoncitos de papa","rellenos con queso mozzarella","urlImagen",15,500);
			Producto producto4 = new Producto("Papas con cheddar","acompañadas del mejor cheddar de la zona","urlImagen",35,600);
			Producto producto5 = new Producto("Picada para 2 personas","aros de cebolla, aceitunas y fiambres y quesos varios","urlImagen",15,900);
			producto1.setActivo(true);
			producto2.setActivo(true);
			producto3.setActivo(true);
			producto4.setActivo(true);
			producto5.setActivo(true);


			productoRepositorio.save( producto1);
			productoRepositorio.save( producto2);
			productoRepositorio.save( producto3);
			productoRepositorio.save( producto4);
			productoRepositorio.save( producto5);
			Factura factura = new Factura();
			factura.setEstadoFactura(EstadoFactura.CARRITO);
			factura.setCliente(cliente1);
			facturaRepositorio.save(factura);
			ClienteProductoPedido pedido = new ClienteProductoPedido(2, factura, producto2);
			clienteProductoPedidoRepositorio.save(pedido);
			ClienteProductoPedido pedido1 = new ClienteProductoPedido(3, factura, producto1);
			clienteProductoPedidoRepositorio.save(pedido1);
		};
	}
}