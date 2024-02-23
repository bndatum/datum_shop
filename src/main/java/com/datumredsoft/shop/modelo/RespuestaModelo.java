package com.datumredsoft.shop.modelo;

import java.util.List;

public class RespuestaModelo {

	private String estado;
	private List<ProductosModelo> productoRespuesta;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<ProductosModelo> getProductoRespuesta() {
		return productoRespuesta;
	}
	public void setProductoRespuesta(List<ProductosModelo> productoRespuesta) {
		this.productoRespuesta = productoRespuesta;
	}
	
	
	
}
