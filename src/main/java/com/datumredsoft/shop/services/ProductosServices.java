package com.datumredsoft.shop.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;
import com.datumredsoft.shop.interfaces.ProductosInterface;
import com.datumredsoft.shop.modelo.ProductosModelo;
import com.datumredsoft.shop.modelo.RespuestaModelo;

@Service("ProductosServices")
public class ProductosServices implements ProductosInterface {
	String[] nombreImagenes = {"arrocera.png", "aspiradora_robot.png", "batidora_jugos.png", "batidora_masa.png", "cable_vga.png", "cafetera.png", "cafetera_artesanal.png", "combo_teclado_mouse.png", "combo_teclado_raton.png", "estufa.png", "freidora_aire.png", "gamecube.png", "headset.png", "horno.png", "horno_electrico.png", "juego_hoyas.png", "juego_te.png", "laptop_msi.png", "mac.png", "microondas.png", "nintendo_switch.png", "nintendo_switch_completo.png", "parlante.png", "pc_all_in_one.png", "pc_gamer.png", "ps2.png", "ps4.png", "router.png", "silla.png", "tetera.png"};
	
	@Override
	public RespuestaModelo getAllProductos() {

        RespuestaModelo response = new RespuestaModelo();
        List<ProductosModelo> listaProductos = new ArrayList<>();
        List<ProductosModelo> listaProductosResponse = new ArrayList<>();

        try {
                for (String nombreIma : nombreImagenes) {
                	 // Obtén el ClassLoader para acceder a los recursos
                    BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/img/"+nombreIma));	
                    System.out.println("La lista es "+nombreIma);

                    
                    // Convertir BufferedImage a cadena Base64
                    String base64Image = bufferedImageToBase64(image);

                    ProductosModelo product = new ProductosModelo();
                    product.setNombreProducto(nombreIma);
                    product.setImagen(base64Image);
                        listaProductos.add(product);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setProductoRespuesta(listaProductosResponse);

        return response;
    }
	
	/*@Override
	public RespuestaModelo getAllProductos() {
		RespuestaModelo response = new RespuestaModelo();
		List<ProductosModelo> listaProductos = new ArrayList<>();
		
		try {
			
			File carpeta = new File("src/main/resources/img");
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("La lista es");
			System.out.println(mapper.writeValueAsString(carpeta.list()));
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
		response.setProductoRespuesta(listaProductos);
		
		return response;
	}*/

	@Override
	public RespuestaModelo getAllProductoByCantidad(int limite) {
        RespuestaModelo response = new RespuestaModelo();
        List<ProductosModelo> listaProductos = new ArrayList<>();
        List<ProductosModelo> listaProductosResponse = new ArrayList<>();

        try {
            if (limite > 30)
                limite = 30;

                for (String nombreIma : nombreImagenes) {
                	 // Obtén el ClassLoader para acceder a los recursos
                    BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/img/"+nombreIma));	
                    System.out.println("La lista es "+nombreIma);

                    
                    // Convertir BufferedImage a cadena Base64
                    String base64Image = bufferedImageToBase64(image);

                    ProductosModelo product = new ProductosModelo();
                    product.setNombreProducto(nombreIma);
                    product.setImagen(base64Image);
                        listaProductos.add(product);
                }

            Random rand = new Random();
            for (int i = 0; i < limite; i++) {
                int randomIndex = rand.nextInt(listaProductos.size());
                ProductosModelo randomElement = listaProductos.get(randomIndex);
                listaProductosResponse.add(randomElement);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setProductoRespuesta(listaProductosResponse);

        return response;
    }
	
	private static String bufferedImageToBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos); // Puedes cambiar el formato según tus necesidades
        byte[] imageBytes = baos.toByteArray();

        return Base64.getEncoder().encodeToString(imageBytes);
    }
	
	/*@Override
	public RespuestaModelo getAllProductoByCantidad(int limite) {
		RespuestaModelo response = new RespuestaModelo();
		List<ProductosModelo> listaProductos = new ArrayList<>();
		List<ProductosModelo> listaProductosResponse = new ArrayList<>();
		
		try {
			if(limite>30)
				limite = 30;
			
			File carpeta = new File("src/main/resources/img");
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("La lista es");
			System.out.println(mapper.writeValueAsString(carpeta.list()));
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
		
	}*/

}
