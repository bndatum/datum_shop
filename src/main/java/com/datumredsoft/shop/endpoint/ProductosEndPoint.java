package com.datumredsoft.shop.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.datumredsoft.shop.interfaces.ProductosInterface;
import com.datumredsoft.shop.modelo.RespuestaModelo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/shop/adm/productos")
public class ProductosEndPoint {

	@Autowired
	@Qualifier("ProductosServices")
	ProductosInterface productoServices;

	@GetMapping(path = "/getAllProductos", produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaModelo getAllProductos() {
		return productoServices.getAllProductos();
	}

	@GetMapping(path = "/getAllProductoByCantidad/{limite}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaModelo getAllProducto1ByCantidad(@PathVariable("limite")  int limite) {
		return productoServices.getAllProductoByCantidad(limite);
	}
	
}
