package com.datumredsoft.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.datumredsoft.shop.entidades")
public class DatumShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatumShopApplication.class, args);
	}

}
