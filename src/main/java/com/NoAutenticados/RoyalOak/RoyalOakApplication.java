package com.NoAutenticados.RoyalOak;

import com.NoAutenticados.RoyalOak.models.Cliente;
import com.NoAutenticados.RoyalOak.models.Producto;
import com.NoAutenticados.RoyalOak.repositories.ClienteRepositorio;
import com.NoAutenticados.RoyalOak.repositories.FacturaRepositorio;
import com.NoAutenticados.RoyalOak.repositories.ProductoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class RoyalOakApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoyalOakApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClienteRepositorio clienteRepositorio, ProductoRepositorio productoRepositorio, FacturaRepositorio facturaRepositorio){
		return (args) -> {
			Cliente cliente1 = new Cliente("Esteban", "Casile", "esteban@gmail.com", "98735435", Set.of("San Juan"));
			Cliente cliente2 = new Cliente("Facu", "Araujo", "facu@gmail.com", "264654564", Set.of("San Juan"));
			Cliente cliente3 = new Cliente("Daphne", "Collao", "daphnecollao@gmail.com", "5649848594", Set.of("San Juan"));
			Cliente cliente4 = new Cliente("Nacho", "Ferrero", "nacho@gmail.com", "78895656", Set.of("San Juan"));
			Cliente cliente5 = new Cliente("Andres", "Garcia", "andres@gmail.com", "84354635", Set.of("San Juan"));
			Cliente cliente6 = new Cliente("Caro", "Cardiello", "caro@gmail.com", "48964564564", Set.of("San Juan"));
			Cliente cliente7 = new Cliente("Walter", "Peralta", "walter@gmail.com", "6573575357", Set.of("San Juan"));
			clienteRepositorio.save(cliente1);
//			cliente1.addDireccion("Cordoba");
//			clienteRepositorio.save(cliente1);
			clienteRepositorio.save(cliente2);
			clienteRepositorio.save(cliente3);
			clienteRepositorio.save(cliente4);
			clienteRepositorio.save(cliente5);
			clienteRepositorio.save(cliente6);
			clienteRepositorio.save(cliente7);
			clienteRepositorio.save(cliente1);





			Producto producto1 = new Producto("Hamburguesa", "Gorda, grande y jugosa", "urlDeImagen", 25, 550, List.of("Carne", "palta"));
			Producto producto2 = new Producto("Lomito Veggie","pan ciabatta, bife de seitan","urlImagen",20,650, List.of("Carne", "palta"));
			Producto producto3 = new Producto("Bastoncitos de papa","rellenos con queso mozzarella","urlImagen",15,500, List.of("Carne", "palta"));
			Producto producto4 = new Producto("Papas con cheddar","acompañadas del mejor cheddar de la zona","urlImagen",35,600, List.of("Carne", "palta"));
			Producto producto5 = new Producto("Picada para 2 personas","aros de cebolla, aceitunas y fiambres y quesos varios","urlImagen",15,900, List.of("Carne", "palta"));
			productoRepositorio.save( producto1);
			productoRepositorio.save( producto2);
			productoRepositorio.save( producto3);
			productoRepositorio.save( producto4);
			productoRepositorio.save( producto5);


		};

	}

}
