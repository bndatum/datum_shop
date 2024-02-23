package com.datumredsoft.shop.interfaces;

import com.datumredsoft.shop.modelo.RespuestaModelo;

public interface ProductosInterface {
	
	public RespuestaModelo getAllProductos();	
	
	public RespuestaModelo getAllProductoByCantidad(int limite);	
	
}
