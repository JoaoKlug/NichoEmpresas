package com.elsonteixeira.nichoempresas.controlador.csv;

import java.util.HashMap;

public class SociosCsv extends Csv {

	private final int idCnpj = 0;
	private final int idPessoaFisica = 1;
	private final int idNome = 2;
	private final int idFaixaEtaria = 10;

	public SociosCsv(String diretorio) {
		super(diretorio);
	}
	
	public HashMap<String,String> getDadosSocio(long linha) {
		
		HashMap<Integer,String> tbSocios = this.getDadosLinhaCsv(linha);
		
		HashMap<String,String> dadosSocio = new HashMap<String,String>();
		if(VerificacaoDados(tbSocios))
		{
			for(int i = 0; i<tbSocios.size(); i++ )
			{
				if(i == idCnpj)
					dadosSocio.put("cnpj", tbSocios.get(idCnpj)) ;
				else if(i == idNome)
					dadosSocio.put("nome", tbSocios.get(idNome));
				else if(i == 2)
					dadosSocio.put("idFaixaEtaria", tbSocios.get(idFaixaEtaria));
			}
		}
		return dadosSocio;
	}
	
	private boolean VerificacaoDados(HashMap<Integer, String> tbSocios) {
		
		boolean verificacao = false;
		if(tbSocios.get(idPessoaFisica) == "1" )
			verificacao = true;
		
		return verificacao;
	}
}
