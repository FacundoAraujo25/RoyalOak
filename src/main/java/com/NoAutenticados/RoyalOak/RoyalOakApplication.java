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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
			Cliente cliente2 = new Cliente("Facu", "Araujo", "facu@gmail.com", "264654564", passwordEncoder.encode("123"));
			Cliente cliente3 = new Cliente("Daphne", "Collao", "daphnecollao@gmail.com", "5649848594", "123");
			Cliente cliente4 = new Cliente("Nacho", "Ferrero", "nacho@gmail.com", "78895656", "123");
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

			Producto producto1 = new Producto("Classic", "Hamburguesa clásica con carne,queso cheddar,verduras y Ali oli.", "https://drive.google.com/file/d/1GFaoNmz_a0XmEjLqMai1nJrM1K2swvyj/view?usp=sharing", 25, 550);
			producto1.setIngredientes(Arrays.stream(("medallón_de_carne cheddar lechuga tomate cebolla morada Ali_oli").split(" ")).collect(Collectors.toList()));
			Producto producto2 = new Producto("Baccon","Bacon y cheddar con hamburguesa acompañada de mayonesa y cebolla caramelizada.","https://drive.google.com/file/d/1kApw5t-rMRLxDYwtFutbdD3Ff9qSViac/view?usp=sharing",20,650);
			producto2.setIngredientes(Arrays.stream(("dos_medallones_de_carne cheddar lechuga tomate cebolla morada mayonesa_casera").split(" ")).collect(Collectors.toList()));
			Producto producto3 = new Producto("Butter Burger","Un medallón, cheddar,cebolla caramelizada con manteca en el medallón.","https://drive.google.com/file/d/1zd8ro-jtzghSjmBGrwxiHyQ81RwkRbiZ/view?usp=sharing",15,600);
			Producto producto4 = new Producto("Crispy Burger","Medallón simple, cheddar, lechuga, tomate, cebolla crispy y Alí Oli.","https://drive.google.com/file/d/1VFGVp4J7CJnrEqCfm3TVGPxZv4GmlZBC/view?usp=sharing",35,600);
			Producto producto5 = new Producto("Doble Cuarto","Dos medallones, extra cheddar, cebolla caramelizada, pepinos alemanes, mostaza y Ketchup Heinz.","https://drive.google.com/file/d/17541BXC7PWl4_6Yfnie1P_Wr3YJWGjbz/view?usp=sharing",15,700);
			Producto producto6 = new Producto("Guacamole Burger","Un medallón, cheddar, queso dambo, guacamole con limón, cebolla picada y mayonesa.","https://drive.google.com/file/d/1NHC6XZJXYldzLCSZR-zbDx23FdonP1aR/view?usp=sharing",15,650);
			Producto producto7 = new Producto("Hamburguesa simple con queso","Dos medallones, extra cheddar y salsa Thousand Islands.","https://drive.google.com/file/d/1gC0UGQKs_QZaebv_rw8t-2zQW6X2FGpO/view?usp=sharing",15,700);
			Producto producto8 = new Producto("Homenaje Stacker","Doble medallón,salsa stacker,cheddar y bacon.","https://drive.google.com/file/d/1F_l2De2QJ7xVmNla9e6GZcHiaTbEVaBf/view?usp=sharing",15,750);
			Producto producto9 = new Producto("Honey Burger","Un medallón, cheddar, pancetas caramelizadas, panes invertidos tostados con manteca y baño de miel.","https://drive.google.com/file/d/1tAoonBGuAewjjR9SRwFR7OAjtrls8yd-/view?usp=sharing",15,650);
			Producto producto10 = new Producto("Mimozza Burger","Medallón simple, cheddar, panceta, bastones de mozzarella y salsa barbacoa.","https://drive.google.com/file/d/1fRmxFZhzi2DUGoZa1Ldr4BzWHweHEqpV/view?usp=sharing",15,700);
			Producto producto11 = new Producto("Oklahoma","Un medallón, extra cheddar, pepino alemanes, cebolla blanca a la plancha, Ketchup y mostaza.","https://drive.google.com/file/d/1QlJyVyi2xQ2cJi96BPHtjYVzFHUEzm0_/view?usp=sharing",15,700);
			Producto producto12 = new Producto("Onion Rings","Un medallón, cheddar, panceta, aros de cebolla y salsa barbacoa.","https://drive.google.com/file/d/1qhPM6QGJ8jhD7e5TrBVnUu5Uyv2e6KUB/view?usp=sharing",15,700);
			Producto producto13 = new Producto("Promo Kids","2 hamburguesas con un medallón cada una, 2 fetas de cheddar c/u, salsa thousand islands o lechuga y tomate a elección.","https://drive.google.com/file/d/1qk1oMY2n4vDF0Uh6sFYu6bDxpeAzFApR/view?usp=sharing",15,700);
			Producto producto14 = new Producto("Travis Scott","Medallón simple, cheddar, panceta, lechuga, cebolla caramelizada, pepinos almanes, salsa Thousland Islands.","https://drive.google.com/file/d/15bjzFVh5vZvcluS4wYR9-F46wvceIgJQ/view?usp=sharing",15,700);
			Producto producto15 = new Producto("Veggie Classic","Un medallón de seitán y avena, cheddar vegano, Alí Oli, cebolla morada, lechuga y tomate.","https://drive.google.com/file/d/1Wlf9f329EHpoDJYMUTIAhn4iEQGjtFqy/view?usp=sharing",15,700);
			Producto producto16 = new Producto("Veggie Crispy","Medallón simple, cheddar x 2, Alí Oli, lechuga, tomete, cebolla crispy.","https://drive.google.com/file/d/1mcF_NE8hebcadngJPpDKcenRGwFaKgp8/view?usp=sharing",15,700);
			Producto producto17 = new Producto("Veggie Onion","Un medallón, cheddar, Alí oli, 4 aros de cebolla.","https://drive.google.com/file/d/17rVJj8MYjT7_Q5oZaaaEtYDEaQE-t7U1/view?usp=sharing",15,700);
			Producto producto18 = new Producto("Veggie Scott","Medallón simple, cheddar, pepinos, cebolla caramelizadas, lechuga y salsa Thousand Islands.","https://drive.google.com/file/d/1qhCKpGjKSHJ9W1ceEb47EQGDC90q_MLX/view?usp=sharing",15,700);


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