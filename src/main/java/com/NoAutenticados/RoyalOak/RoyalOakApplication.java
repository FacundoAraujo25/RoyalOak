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


			Producto producto1 = new Producto("Classic", "Hamburguesa clásica con carne,queso cheddar,verduras y Ali oli.", "https://i.imgur.com/7n3AQpO.jpg", 25, 550,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto2 = new Producto("Bacon","Bacon y cheddar con hamburguesa acompañada de mayonesa y cebolla caramelizada.","https://i.imgur.com/NB5THSY.jpg",20,650,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto3 = new Producto("Butter Burger","Un medallón, cheddar,cebolla caramelizada con manteca en el medallón.","https://i.imgur.com/52tsTkG.jpg",15,600,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto4 = new Producto("Crispy Burger","Medallón simple, cheddar, lechuga, tomate, cebolla crispy y Alí Oli.","https://i.imgur.com/46E6lnG.jpg",35,600,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto5 = new Producto("Doble Cuarto","Dos medallones, extra cheddar, cebolla caramelizada, pepinos alemanes, mostaza y Ketchup Heinz.","https://i.imgur.com/twjNv49.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto6 = new Producto("Guacamole Burger","Un medallón, cheddar, queso dambo, guacamole con limón, cebolla picada y mayonesa.","https://i.imgur.com/FwSEQff.jpg",15,650,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto7 = new Producto("Hamburguesa simple con queso","Dos medallones, extra cheddar y salsa Thousand Islands.","https://i.imgur.com/5X7lT23.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto8 = new Producto("Homenaje Stacker","Doble medallón,salsa stacker,cheddar y bacon.","https://i.imgur.com/yF7qz75.jpg",15,750,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto9 = new Producto("Honey Burger","Un medallón, cheddar, pancetas caramelizadas, panes invertidos tostados con manteca y baño de miel.","https://i.imgur.com/XhpdZNY.jpg",15,650,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto10 = new Producto("Mimozza Burger","Medallón simple, cheddar, panceta, bastones de mozzarella y salsa barbacoa.","https://i.imgur.com/uqdGKzy.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto11 = new Producto("Oklahoma","Un medallón, extra cheddar, pepino alemanes, cebolla blanca a la plancha, Ketchup y mostaza.","https://i.imgur.com/L2lS50X.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto12 = new Producto("Onion Rings","Un medallón, cheddar, panceta, aros de cebolla y salsa barbacoa.","https://i.imgur.com/dpG0ReL.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto13 = new Producto("Promo Kids","2 hamburguesas con un medallón cada una, 2 fetas de cheddar c/u, salsa thousand islands o lechuga y tomate a elección.","https://i.imgur.com/6rCpvdW.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto14 = new Producto("Travis Scott","Medallón simple, cheddar, panceta, lechuga, cebolla caramelizada, pepinos almanes, salsa Thousland Islands.","https://i.imgur.com/zTkxH63.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto15 = new Producto("Veggie Classic","Un medallón de seitán y avena, cheddar vegano, Alí Oli, cebolla morada, lechuga y tomate.","https://i.imgur.com/6F09PKa.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto16 = new Producto("Veggie Crispy","Medallón simple, cheddar x 2, Alí Oli, lechuga, tomete, cebolla crispy.","https://i.imgur.com/RU31jCO.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto17 = new Producto("Veggie Onion","Un medallón, cheddar, Alí oli, 4 aros de cebolla.","https://i.imgur.com/5fOyoh7.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			Producto producto18 = new Producto("Veggie Scott","Medallón simple, cheddar, pepinos, cebolla caramelizadas, lechuga y salsa Thousand Islands.","https://i.imgur.com/Jv3zCeN.jpg",15,700,Tipo.COMIDA,SubTipo.HAMBURGUESAS);
			productoRepositorio.save( producto1);
			productoRepositorio.save( producto2);
			productoRepositorio.save( producto3);
			productoRepositorio.save( producto4);
			productoRepositorio.save( producto5);
			productoRepositorio.save( producto6);
			productoRepositorio.save( producto7);
			productoRepositorio.save( producto8);
			productoRepositorio.save( producto9);
			productoRepositorio.save( producto10);
			productoRepositorio.save( producto11);
			productoRepositorio.save( producto12);
			productoRepositorio.save( producto13);
			productoRepositorio.save( producto14);
			productoRepositorio.save( producto15);
			productoRepositorio.save( producto16);
			productoRepositorio.save( producto17);
			productoRepositorio.save( producto18);
			producto1.setActivo(true);
			producto2.setActivo(true);
			producto3.setActivo(true);
			producto4.setActivo(true);
			producto5.setActivo(true);
			producto6.setActivo(true);
			producto7.setActivo(true);
			producto8.setActivo(true);
			producto9.setActivo(true);
			producto10.setActivo(true);
			producto11.setActivo(true);
			producto12.setActivo(true);
			producto13.setActivo(true);
			producto14.setActivo(true);
			producto15.setActivo(true);
			producto16.setActivo(true);
			producto17.setActivo(true);
			producto18.setActivo(true);

	//		Producto producto1 = new Producto("Hamburguesa", "Gorda, grande y jugosa", "urlDeImagen", 25, 550, Tipo.COMIDA, SubTipo.HAMBURGUESAS);
	//		Producto producto2 = new Producto("Lomito Veggie","pan ciabatta, bife de seitan","urlImagen",20,650, Tipo.COMIDA, SubTipo.LOMITOS);
	//		Producto producto3 = new Producto("Bastoncitos de papa","rellenos con queso mozzarella","urlImagen",15,500, Tipo.COMIDA, SubTipo.PICADAS);
	//		Producto producto4 = new Producto("Papas con cheddar","acompañadas del mejor cheddar de la zona","urlImagen",35,600, Tipo.COMIDA, SubTipo.PICADAS);
	//		Producto producto5 = new Producto("Picada para 2 personas","aros de cebolla, aceitunas y fiambres y quesos varios","urlImagen",15,900, Tipo.COMIDA, SubTipo.PICADAS);

			Producto producto19 = new Producto("Almejas sagradas","Harina italiana, salsa de crema, mozzarella, camarones, mejillones, palta, rúcula, salsa secreta","https://i.imgur.com/NtKm82W.png",15,900,Tipo.COMIDA,SubTipo.PIZZAS);
			Producto producto20 = new Producto("Capricciosa clasica","Harina italiana, salsa de tomate integral, mozzarella, tocino, tomates, champiñones, aceitunas","https://i.imgur.com/s058ySc.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto21 = new Producto("Jamon","Harina italiana, salsa de tomate integral, mozzarella, PROSCUITTO, rúcula, tomates cherry, tomate seco, alcaparras, orégano, parmesano","https://i.imgur.com/5gMLjAw.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto22 = new Producto("Margarita","Harina italiana, salsa de tomate integral, mozzarella, tomates, pesto, orégano","https://i.imgur.com/xrx0x0M.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto23 = new Producto("Multi carne","Harina italiana, salsa de tomate entera, mozzarella, ternera, cerdo hervido, pepperoni, salchichas de caza, pimiento morrón, cebolla de Crimea, salsa barbacoa, orégano","https://i.imgur.com/o9mzLq5.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto24 = new Producto("Pepperoni","Harina italiana, mozzarella, salsa de tomate entera, pepperoni italiano real, pimientos picantes, alcaparras, orégano","https://i.imgur.com/yQlYIGO.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto25 = new Producto("Pollo con champiñones","Harina italiana, parmesano y salsa de crema, mozzarella, Dorblu, pollo al horno, champiñones, pimiento morrón, orégano","https://i.imgur.com/v9aQHSt.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto26 = new Producto("Pollo con ananá","Harina italiana, salsa de tomate integral, mozzarella, pollo al horno, piña, pimiento morrón, mostaza de naranja, arándano, orégano","https://i.imgur.com/2MQVLns.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto27 = new Producto("Queso de cabra","Harina italiana, salsa de crema secreta de la abuela de alguien, mozzarella, queso de cabra, tubérculos, piñones","https://i.imgur.com/nqJYq2j.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto28 = new Producto("Queso de primera calidad","Harina italiana, salsa de nata y parmesano, mozzarella, DorBlue, parmesano, nuez, arándano","https://i.imgur.com/bG1skWd.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto29 = new Producto("Salami","Harina italiana, mozzarella, salsa de tomate integral, salami premium, orégano","https://i.imgur.com/0LYWujF.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto30 = new Producto("Salmon y espinaca","Harina italiana, salsa de tomate integral, mozzarella, salmón, tomate, espinaca, Dorblu, ajo, limón, piñones, aceitunas, orégano.","https://i.imgur.com/Mt1xB6r.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto31 = new Producto("Panceta","Harina italiana, salsa de tomate integral, mozzarella, dorblu, tocino seco, pimiento picante, orégano","https://i.imgur.com/51YOG7S.png",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			productoRepositorio.save(producto19);
			productoRepositorio.save(producto20);
			productoRepositorio.save(producto21);
			productoRepositorio.save(producto22);
			productoRepositorio.save(producto23);
			productoRepositorio.save(producto24);
			productoRepositorio.save(producto25);
			productoRepositorio.save(producto26);
			productoRepositorio.save(producto27);
			productoRepositorio.save(producto28);
			productoRepositorio.save(producto29);
			productoRepositorio.save(producto30);
			productoRepositorio.save(producto31);
			producto19.setActivo(true);
			producto20.setActivo(true);
			producto21.setActivo(true);
			producto22.setActivo(true);
			producto23.setActivo(true);
			producto24.setActivo(true);
			producto25.setActivo(true);
			producto26.setActivo(true);
			producto27.setActivo(true);
			producto28.setActivo(true);
			producto29.setActivo(true);
			producto30.setActivo(true);
			producto31.setActivo(true);

			Producto producto32 = new Producto("Baru","mix verdes, tomate, queso en cubos, calabaza asada y huevo","https://i.imgur.com/FX8K2a7.jpg",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto33 = new Producto("Hawaii","mix verdes, pollo grill , queso en cubos, queso crema y nueces","https://i.imgur.com/YWMMHDK.jpg",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto34 = new Producto("Ibiza","mix verdes, arroz yamani queso tybo, zanahoria, choclo y huevo","https://i.imgur.com/vT8GFrk.jpg",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto35 = new Producto("Indonesia","mix verdes, salmon rosado, palta, queso crema, arroz yamani","https://i.imgur.com/o3RLOzS.jpg",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto36 = new Producto("Jamaica","mix de verdes, tomate, queso en cubos, fideos tirabuzon y huevo","https://i.imgur.com/F3PVrWD.jpg",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto37 = new Producto("Praga","lechuga romana, pollo grill, queso en hebras, croutons, huevo, salsa cesar","https://i.imgur.com/3eSAAT5.jpg",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto38 = new Producto("Rio","mix verdes, tomate, pollo grill, queso en cubos y palta","https://i.imgur.com/7gVuULw.jpg",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto39 = new Producto("Tulum","mix verdes, arroz yamani, tomate, choclo y huevo","https://i.imgur.com/mtdpvP4.jpg",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			productoRepositorio.save(producto32);
			productoRepositorio.save(producto33);
			productoRepositorio.save(producto34);
			productoRepositorio.save(producto35);
			productoRepositorio.save(producto36);
			productoRepositorio.save(producto37);
			productoRepositorio.save(producto38);
			productoRepositorio.save(producto39);
			producto32.setActivo(true);
			producto33.setActivo(true);
			producto34.setActivo(true);
			producto35.setActivo(true);
			producto36.setActivo(true);
			producto37.setActivo(true);
			producto38.setActivo(true);
			producto39.setActivo(true);

			Producto producto40 = new Producto("Papas Americanas","papas con bacon y cheddar de excelente calidad","https://i.imgur.com/iCNjRMn.jpg",15,550, Tipo.COMIDA, SubTipo.PICADAS);
			Producto producto41 = new Producto("Papas Criollas","papas con salsa criolla y huevos fritos","https://i.imgur.com/04onzhI.jpg",15,550, Tipo.COMIDA, SubTipo.PICADAS);
			Producto producto42 = new Producto("Picada 4 elementos","Abundante tabla de picada de fiambres,quesos,nuggets de pollo,papas y rabas.","https://i.imgur.com/tVqTiiw.jpg",15,550, Tipo.COMIDA, SubTipo.PICADAS);
			Producto producto43 = new Producto("Picada Colombiana","Excelente tabla de picada con trocitos de carne,costillitas de cerdo,embutidos, verduras y salsas varias.","https://i.imgur.com/eTdRlG2.jpg",15,550, Tipo.COMIDA, SubTipo.PICADAS);
			Producto producto44 = new Producto("Veracruzanas","Tortillas acompañadas de queso,cebollas picadas,tomates,frijoles refritos con chorizo y jalapeños","https://i.imgur.com/X6YUnMe.jpg",15,550, Tipo.COMIDA, SubTipo.PICADAS);
			Producto producto45 = new Producto("Bastones de Muzza","Bastoncitos rellenos de queso mozzarella","https://i.imgur.com/Ovjma1V.jpg",15,550, Tipo.COMIDA, SubTipo.PICADAS);
			productoRepositorio.save(producto40);
			productoRepositorio.save(producto41);
			productoRepositorio.save(producto42);
			productoRepositorio.save(producto43);
			productoRepositorio.save(producto44);
			productoRepositorio.save(producto45);
			producto40.setActivo(true);
			producto41.setActivo(true);
			producto42.setActivo(true);
			producto43.setActivo(true);
			producto44.setActivo(true);
			producto45.setActivo(true);


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