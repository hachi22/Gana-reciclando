package com.gana_reciclando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gana_reciclando.models.UserModel;
import com.gana_reciclando.repositories.UserRepository;
@ComponentScan(basePackages = {"com.gana_reciclando"})
@SpringBootApplication
public class ProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
		
	}	

}
