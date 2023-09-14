package com.pesos.TP1JPA;


import com.pesos.TP1JPA.Entidades.*;
import com.pesos.TP1JPA.Enumeraciones.EstadoPedido;
import com.pesos.TP1JPA.Enumeraciones.FormadePago;
import com.pesos.TP1JPA.Enumeraciones.TipoEnvio;
import com.pesos.TP1JPA.Enumeraciones.TipoProducto;
import com.pesos.TP1JPA.Repositorios.ClienteRepositorio;
import com.pesos.TP1JPA.Repositorios.FacturaRepositorio;
import com.pesos.TP1JPA.Repositorios.PedidoRepositorio;
import com.pesos.TP1JPA.Repositorios.RubroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Tp1JpaApplication {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	PedidoRepositorio pedidoRepositorio;
	FacturaRepositorio facturaRepositorio;
	RubroRepositorio rubroRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(Tp1JpaApplication.class, args);


	}

	@Bean
	CommandLineRunner init (ClienteRepositorio clienteRepositorio, PedidoRepositorio pedidoRepositorio, FacturaRepositorio facturaRepositorio, RubroRepositorio rubroRepositorio) {

				return args -> {
					System.out.println("FUNCIONANDO");

					Cliente cliente = Cliente.builder()
							.nombre("Roberto")
							.apellido("Vaieretti")
							.telefono("2615339357")
							.email("titocabj@gmail.com")
							.build();

					Domicilio domicilio1 = Domicilio.builder()
							.calle("Lat sur acc")
							.localidad("Gllen")
							.numero("356")
							.build();

					Pedido pedido1 = Pedido.builder()
							.estado(EstadoPedido.INICIADO)
							.tipoEnvio(TipoEnvio.DELIVERY)
							.build();

					Pedido pedido2 = Pedido.builder()
							.estado(EstadoPedido.PREPARACION)
							.tipoEnvio(TipoEnvio.RETIRAR)
							.build();

					double descuento1 = 200.00; // Obtén el valor del descuento de donde corresponda
					double precioSinDescuento1 = 3500; // Obtén el precio sin descuento de donde corresponda

					double totalConDescuento1 = precioSinDescuento1 - descuento1;

					double descuento2 = 3000.0; // Obtén el valor del descuento de donde corresponda
					double precioSinDescuento2 = 18000; // Obtén el precio sin descuento de donde corresponda

					double totalConDescuento2 = precioSinDescuento2 - descuento2;

					cliente.addDomicilio(domicilio1);
					cliente.addPedido(pedido1);
					cliente.addPedido(pedido2);

					clienteRepositorio.save(cliente);


					DetallePedido detalle1Pedido1 = DetallePedido.builder()
							.cantidad(1)
							.subtotal(3000.00)
							.build();
					pedido1.agregarDetallePedido(detalle1Pedido1);

					DetallePedido detalle2Pedido1 = DetallePedido.builder()
							.cantidad(2)
							.subtotal(7000.00)
							.build();
					pedido1.agregarDetallePedido(detalle2Pedido1);

					pedidoRepositorio.save(pedido1);

					DetallePedido detalle1Pedido2 = DetallePedido.builder()
							.cantidad(1)
							.subtotal(3500.00)
							.build();
					pedido2.agregarDetallePedido(detalle1Pedido2);

					DetallePedido detalle2Pedido2 = DetallePedido.builder()
							.cantidad(2)
							.subtotal(6000.00)
							.build();
					pedido2.agregarDetallePedido(detalle2Pedido2);

					pedidoRepositorio.save(pedido2);

					Factura factura1 = Factura.builder()
							.numero(001)
							.formadePago(FormadePago.EFECTIVO)
							.descuento(200.00)
							.total(3500)
							.pedido(pedido1)   // Asociar la factura con el pedido
							.build();

					Factura factura2 = Factura.builder()
							.numero(002)
							.formadePago(FormadePago.TARJETA)
							.descuento(3000.00)
							.total(18000)
							.pedido(pedido2)   // Asociar la factura con el pedido
							.build();

					pedido1.setDescAplicado(200.00);
					pedido1.setTotal(totalConDescuento1);
					pedido1.setFactura(factura1);
					facturaRepositorio.save(factura1);
					pedidoRepositorio.save(pedido1);


					pedido2.setDescAplicado(3000.0);
					pedido2.setTotal(totalConDescuento2);
					pedido2.setFactura(factura2);
					facturaRepositorio.save(factura2);
					pedidoRepositorio.save(pedido2);

					Rubro rubro = Rubro.builder()
							.denominacion("Local")
							.build();

					Producto producto1= Producto.builder()
							.tipo(TipoProducto.INSUMO)
							.tiempoEstimadoCocina(21)
							.denominacion("Local")
							.precioVenta(2.00)
							.precioCompra(1.00)
							.stockActual(5)
							.stockMinimo(2)
							.unidadMedida("kilos")
							.receta("....")
							.build();

					Producto producto2= Producto.builder()
							.tipo(TipoProducto.INSUMO)
							.tiempoEstimadoCocina(21)
							.denominacion("Local")
							.precioVenta(2.00)
							.precioCompra(1.00)
							.stockActual(5)
							.stockMinimo(2)
							.unidadMedida("kilos")
							.receta("....")
							.build();

					rubro.addProducto(producto1);
					rubro.addProducto(producto2);
					rubroRepositorio.save(rubro);

		};
	}
}

