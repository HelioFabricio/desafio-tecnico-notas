package com.panvel.desafiotecnico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DesafiotecnicoApplication {
	public static void main( String[] args ) {
		SpringApplication.run( DesafiotecnicoApplication.class, args );
	}
}
