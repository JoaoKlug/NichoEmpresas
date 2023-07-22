package com.elsonteixeira.nichoempresas.tela;

import java.util.Scanner;

import com.elsonteixeira.nichoempresas.controlador.NichoControlador;

public class TelaPrincipal {
	
	private Scanner lerTeclado;
	
	public TelaPrincipal(){
		lerTeclado = new Scanner(System.in);
	}
	
	public void executar(){
		
		for(;;)
		{
			System.out.println("Insira o endereço do diretorio que contém os arquivos CSV soltos");
				String enderecoDiretorio = lerTeclado.nextLine();
				
			 NichoControlador nichoControlador = new NichoControlador(enderecoDiretorio);
			 if(nichoControlador.isDiretorioValido()) {
				 nichoControlador.cadastrarNicho();
				 break;
			 }
		}
		
	}
	
}
