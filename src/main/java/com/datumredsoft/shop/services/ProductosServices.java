package com.datumredsoft.shop.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import com.datumredsoft.shop.interfaces.ProductosInterface;
import com.datumredsoft.shop.modelo.ProductosModelo;
import com.datumredsoft.shop.modelo.RespuestaModelo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("ProductosServices")
public class ProductosServices implements ProductosInterface {
	

	@Override
	public RespuestaModelo getAllProductos() {
		RespuestaModelo response = new RespuestaModelo();
		List<ProductosModelo> listaProductos = new ArrayList<>();
		List<ProductosModelo> listaProductosResponse = new ArrayList<>();
		
		try {
			File carpeta = new File("src/main/resources/img");
			//Ciclo para Saturacion RAM y CPU
			for (int i = 0; i < 2; i++) {
				for(String nombreIma : carpeta.list())
				{
				
				byte[] fileContent;
				ProductosModelo product = new ProductosModelo();
				fileContent = FileUtils.readFileToByteArray(new File("src/main/resources/img/"+nombreIma));
				String encodedString = Base64.getEncoder().encodeToString(fileContent);
				
				product.setNombreProducto(nombreIma);
				product.setImagen(encodedString);
				if(i==0)
					listaProductos.add(product);
				}
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		response.setProductoRespuesta(listaProductosResponse);
		
		return response;
	}

	@Override
	public RespuestaModelo getAllProductoByCantidad(int limite) {
		RespuestaModelo response = new RespuestaModelo();
		List<ProductosModelo> listaProductos = new ArrayList<>();
		List<ProductosModelo> listaProductosResponse = new ArrayList<>();
		
		try {
			if(limite>30)
				limite = 30;
			
			File carpeta = new File("src/main/resources/img");
			//Ciclo para Saturacion RAM y CPU
			for (int i = 0; i < 5; i++) {
				for(String nombreIma : carpeta.list())
				{
				byte[] fileContent;
				ProductosModelo product = new ProductosModelo();
				fileContent = FileUtils.readFileToByteArray(new File("src/main/resources/img/"+nombreIma));
				String encodedString = Base64.getEncoder().encodeToString(fileContent);
				
				product.setNombreProducto(nombreIma);
				product.setImagen(encodedString);
				if(i==0)
					listaProductos.add(product);				
				}
			}
			
			Random rand = new Random();
		    for (int i = 0; i < limite; i++) {
		        int randomIndex = rand.nextInt(listaProductos.size());
		        ProductosModelo randomElement = listaProductos.get(randomIndex);
		        listaProductosResponse.add(randomElement);
		    }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		response.setProductoRespuesta(listaProductosResponse);
		
		return response;
		
	}

}
