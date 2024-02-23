package com.datumredsoft.shop.modelo;


public class ProductosModelo{


	public ProductosModelo() {
		//COnstructor
	}
	
	private String nombreProducto;

	private Long precio;

	private String imagen;

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	
	
}
