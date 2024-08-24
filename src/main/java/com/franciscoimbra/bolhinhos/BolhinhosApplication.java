package com.franciscoimbra.bolhinhos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = {"com.franciscoimbra.bolhinhos.model"})
public class BolhinhosApplication {



	public static void main(String[] args) {

		SpringApplication.run(BolhinhosApplication.class, args);
	}
	/*
	@Autowired
	PasswordEncoder passwordEncoder;

	public BolhinhosApplication(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	public void teste(){
		String tetse=this.passwordEncoder.encode("kikuka96");
		System.out.println(tetse);
	}*/


}
