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
	String[] nombreImagenes = {"arrocera.jpg", "aspiradora_robot.jpg", "batidora_jugos.jpg", "batidora_masa.jpg", "cable_vga.jpg", "cafetera.jpg", "cafetera_artesanal.jpg", "combo_teclado_mouse.jpg", "combo_teclado_raton.jpg", "estufa.jpg", "freidora_aire.jpg", "gamecube.jpg", "headset.jpg", "horno.jpg", "horno_electrico.jpg", "juego_hoyas.jpg", "juego_te.jpg", "laptop_msi.jpg", "mac.jpg", "microondas.jpg", "nintendo_switch.jpg", "nintendo_switch_completo.jpg", "parlante.jpg", "pc_all_in_one.jpg", "pc_gamer.jpg", "ps2.jpg", "ps4.jpg", "router.jpg", "silla.jpg", "tetera.jpg"};
	
	@Override
	public RespuestaModelo getAllProductos() {

        RespuestaModelo response = new RespuestaModelo();
        List<ProductosModelo> listaProductos = new ArrayList<>();

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
        response.setProductoRespuesta(listaProductos);

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
