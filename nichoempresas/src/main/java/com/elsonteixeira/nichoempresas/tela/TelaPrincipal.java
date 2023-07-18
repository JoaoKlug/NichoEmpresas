package com.elsonteixeira.nichoempresas.tela;

import java.util.Scanner;

import com.elsonteixeira.nichoempresas.controlador.NichoControlador;
import com.elsonteixeira.nichoempresas.repositorios.NichoRepositorio;

public class TelaPrincipal {
	
	private Scanner lerTeclado;
	
	public TelaPrincipal(){
		lerTeclado = new Scanner(System.in);
	}
	
	public void executar(NichoRepositorio nichoRepositorio){
		
		NichoControlador nichoControlador = null;
		String enderecoDiretorio = "";
		boolean diretorioValido = false;
		
		while(diretorioValido != true)
		{
			System.out.println("Insira o endereço do diretorio que contém os arquivos CSV soltos");
				enderecoDiretorio = lerTeclado.nextLine();
			 nichoControlador = new NichoControlador(enderecoDiretorio, nichoRepositorio);
			 diretorioValido = nichoControlador.getDiretorioValido();
		}
		
		nichoControlador.executar();
	}
	
}
