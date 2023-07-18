package com.elsonteixeira.nichoempresas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elsonteixeira.nichoempresas.repositorios.NichoRepositorio;
import com.elsonteixeira.nichoempresas.tela.TelaPrincipal;


@SpringBootApplication
public class NichoempresasApplication implements CommandLineRunner {
	
	@Autowired
	NichoRepositorio nichoRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(NichoempresasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new TelaPrincipal().executar(nichoRepositorio);
	}

}
