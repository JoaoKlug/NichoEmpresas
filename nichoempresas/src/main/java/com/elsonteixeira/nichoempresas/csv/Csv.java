package com.elsonteixeira.nichoempresas.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public abstract class Csv {

	protected String diretorio;
	protected long totalLinhas;
	
	protected Csv(String diretorio)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(diretorio))) {
			this.diretorio = diretorio;
			long contadorLinhas = 0;
			while(br.readLine()!= null)
				contadorLinhas++;
			this.totalLinhas = contadorLinhas;
		}catch (IOException e) {
			System.out.println("Arquivo nao encontrado");
		}
	}
	
	protected HashMap<Integer,String> getDadosLinhaCsv (long linha) {
			
		int idDado = 0;
		
		HashMap<Integer, String> dadosLinha = new HashMap<Integer,String>();
		try (BufferedReader br = new BufferedReader(new FileReader(this.diretorio))) {
			
			for( long i = 0; i<linha; i++)
				br.readLine();
			
			String dado = "";
			String line = br.readLine();
			for(int i = 0; i<line.length(); i++ )
			{
				if(line.charAt(i)!= '"' && line.charAt(i) != ';')
					dado = dado.concat(String.valueOf(line.charAt(i)));
				if(line.charAt(i)==';')
				{
					dadosLinha.put(idDado,dado);
					dado="";
					idDado++;
				}
			}
		}
		catch (IOException e) {
			System.out.println("Error: Arquivo nao encontrado ");
		}
		return dadosLinha;
	}
	
	public long getTotalLinhas() {
		return totalLinhas;
	}
}
