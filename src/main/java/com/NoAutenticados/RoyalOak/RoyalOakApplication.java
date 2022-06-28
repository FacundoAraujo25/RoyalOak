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

			Producto producto1 = new Producto("Hamburguesa", "Gorda, grande y jugosa", "urlDeImagen", 25, 550, Tipo.COMIDA, SubTipo.HAMBURGUESAS);
			Producto producto2 = new Producto("Lomito Veggie","pan ciabatta, bife de seitan","urlImagen",20,650, Tipo.COMIDA, SubTipo.LOMITOS);
			Producto producto3 = new Producto("Bastoncitos de papa","rellenos con queso mozzarella","urlImagen",15,500, Tipo.COMIDA, SubTipo.PICADAS);
			Producto producto4 = new Producto("Papas con cheddar","acompañadas del mejor cheddar de la zona","urlImagen",35,600, Tipo.COMIDA, SubTipo.PICADAS);
			Producto producto5 = new Producto("Picada para 2 personas","aros de cebolla, aceitunas y fiambres y quesos varios","urlImagen",15,900, Tipo.COMIDA, SubTipo.PICADAS);


			Producto producto20 = new Producto("Almejas sagradas","Harina italiana, salsa de crema, mozzarella, camarones, mejillones, palta, rúcula, salsa secreta","https://drive.google.com/file/d/1Hf0doNmXRcfzX8cwUeAabe63XgQDezB2/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto21 = new Producto("Capricciosa clasica","Harina italiana, salsa de tomate integral, mozzarella, tocino, tomates, champiñones, aceitunas","https://drive.google.com/file/d/1Vglr7GLwAnqQ13h90uemztDj9wtvnn-n/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto22 = new Producto("Jamon","Harina italiana, salsa de tomate integral, mozzarella, PROSCUITTO, rúcula, tomates cherry, tomate seco, alcaparras, orégano, parmesano","https://drive.google.com/file/d/1fCUhIDoQ9aK_kxuJItrjwqxaUrYBimzV/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto23 = new Producto("Margarita","Harina italiana, salsa de tomate integral, mozzarella, tomates, pesto, orégano","https://drive.google.com/file/d/12WRNnfh8B7PC5mv3ZJSPk_ACP27bNOW9/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto24 = new Producto("Multi carne","Harina italiana, salsa de tomate entera, mozzarella, ternera, cerdo hervido, pepperoni, salchichas de caza, pimiento morrón, cebolla de Crimea, salsa barbacoa, orégano","https://drive.google.com/file/d/1SbqQpbloWOi8YzUKOMhB_pDQumwfo8aR/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto25 = new Producto("Pepperoni","Harina italiana, mozzarella, salsa de tomate entera, pepperoni italiano real, pimientos picantes, alcaparras, orégano","https://drive.google.com/file/d/15RokA0HP5yuZUTEV4E43HhoHDTXPJoM_/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto26 = new Producto("Pollo con champiñones","Harina italiana, parmesano y salsa de crema, mozzarella, Dorblu, pollo al horno, champiñones, pimiento morrón, orégano","https://drive.google.com/file/d/1KLqpLr0Ys_mQIXk5CBqr4CKHRukM28RX/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto27 = new Producto("Pollo con piña","Harina italiana, salsa de tomate integral, mozzarella, pollo al horno, piña, pimiento morrón, mostaza de naranja, arándano, orégano","https://drive.google.com/file/d/1_Pv6cx5tQJXVjPNipcz32uaqRsRbQ9N1/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto28 = new Producto("Queso de cabra","Harina italiana, salsa de crema secreta de la abuela de alguien, mozzarella, queso de cabra, tubérculos, piñones","https://drive.google.com/file/d/19cGtcLVX436LGoX_R9ACJS14PV5tCWjV/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto29 = new Producto("Queso de primera calidad","Harina italiana, salsa de nata y parmesano, mozzarella, DorBlue, parmesano, nuez, arándano","https://drive.google.com/file/d/1HZXE3tuXqFusYWDflku3hpWlCVz84jBI/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto30 = new Producto("Salami","Harina italiana, mozzarella, salsa de tomate integral, salami premium, orégano","https://drive.google.com/file/d/1XEpo7ptO3gMfdQ126C-cMQvCuAantHE9/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto31 = new Producto("Salmon y espinaca","Harina italiana, salsa de tomate integral, mozzarella, salmón, tomate, espinaca, Dorblu, ajo, limón, piñones, aceitunas, orégano.","https://drive.google.com/file/d/1NLVXJ2IHiFUncc9Q21qfLLeJxKHubICo/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
			Producto producto32 = new Producto("Tocino","Harina italiana, salsa de tomate integral, mozzarella, dorblu, tocino seco, pimiento picante, orégano","https://drive.google.com/file/d/1TIJozePG3LoLFf_05q3i5RnoZVLtQZ4F/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.PIZZAS);
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
			productoRepositorio.save(producto32);
			Producto producto33 = new Producto("Baru","mix verdes, tomate, queso en cubos, calabaza asada y huevo","https://drive.google.com/file/d/1fbmeJUH9BQ90cUMQWUmWDxSlQ5I6weUv/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto34 = new Producto("Hawaii","mix verdes, pollo grill , queso en cubos, queso crema y nueces","https://drive.google.com/file/d/1z0g6TfF4fD1mwfeKG3TuG-3MZnYwTNwg/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto35 = new Producto("Ibiza","mix verdes, arroz yamani queso tybo, zanahoria, choclo y huevo","https://drive.google.com/file/d/1kcTsuks3AmagC6apeMP9PpamsIHtzbC7/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto36 = new Producto("Indonesia","mix verdes, salmon rosado, palta, queso crema, arroz yamani","https://drive.google.com/file/d/1mW-mv2pM-BRikLgZyNmBhKb1X-kDf4Vu/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto37 = new Producto("Jamaica","mix de verdes, tomate, queso en cubos, fideos tirabuzon y huevo","https://drive.google.com/file/d/1-EjThKHW15xnW8s1lmcu6mEYGP-jc2xP/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto38 = new Producto("Praga","lechuga romana, pollo grill, queso en hebras, croutons, huevo, salsa cesar","https://drive.google.com/file/d/1STrrRJSuvlq6arlLkQsre7Stt4jwoNk6/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto39 = new Producto("Rio","mix verdes, tomate, pollo grill, queso en cubos y palta","https://drive.google.com/file/d/1iec5Q1DFssWId-qTWVjhjJ8Akkwi0OFG/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			Producto producto40 = new Producto("Tulum","mix verdes, arroz yamani, tomate, choclo y huevo","https://drive.google.com/file/d/1SbZmJihP2zzJZIui8GqzmgKQxSHowd9q/view?usp=sharing",15,900, Tipo.COMIDA, SubTipo.ENSALADAS);
			productoRepositorio.save(producto33);
			productoRepositorio.save(producto34);
			productoRepositorio.save(producto35);
			productoRepositorio.save(producto36);
			productoRepositorio.save(producto37);
			productoRepositorio.save(producto38);
			productoRepositorio.save(producto39);
			productoRepositorio.save(producto40);











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