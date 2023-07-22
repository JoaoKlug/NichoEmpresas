package com.elsonteixeira.nichoempresas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elsonteixeira.nichoempresas.tela.TelaPrincipal;

@SpringBootApplication
public class NichoempresasApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NichoempresasApplication.class, args);
		new TelaPrincipal().executar();
	}

}
