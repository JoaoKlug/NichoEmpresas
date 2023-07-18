package com.elsonteixeira.nichoempresas.csv;

import java.util.HashMap;

public class EmpresasCsv extends Csv{

	private final int idCnpj = 0;
	private final int idRazaoSocial = 1;
	private final int idCodigoNaturezaJuridica = 2;
	private final int idCodigoQualificacao = 3;
	private final int idPorteEmpresa = 5;
	
	
	public EmpresasCsv(String diretorio) {
		super(diretorio);
	}

	public HashMap<String, String> getDadosEmpresa(long linha) {
		
		HashMap<Integer,String> tbEmpresas = this.getDadosLinhaCsv(linha);
		
		HashMap<String, String> dadosEmpresa = new HashMap<String,String>();
		if(VerificacaoDados(tbEmpresas))
		{
			for(int i = 0; i<tbEmpresas.size(); i++ )
			{
				if(i == idCnpj)
					dadosEmpresa.put("cnpj", tbEmpresas.get(idCnpj));
				else if(i == idRazaoSocial)
					dadosEmpresa.put("razaoSocial",tbEmpresas.get(idRazaoSocial));
				else if(i == idCodigoNaturezaJuridica)
					dadosEmpresa.put("codigoNaturezaJuridica", tbEmpresas.get(idCodigoNaturezaJuridica));
				else if(i == idCodigoQualificacao)
					dadosEmpresa.put("codigoQualificacao", tbEmpresas.get(idCodigoQualificacao));
				else
					break;
			}
		}
		return dadosEmpresa;
	}
	
	private boolean VerificacaoDados(HashMap<Integer,String> tbEmpresas){
		
		boolean verificacao = false;	
		if(tbEmpresas.get(idPorteEmpresa)== "5")
		{
			if(tbEmpresas.get(idCodigoNaturezaJuridica)== "3999" ||
			tbEmpresas.get(idCodigoNaturezaJuridica)== "2305")
			{
				if(tbEmpresas.get(idCodigoQualificacao) == "05" ||
				tbEmpresas.get(idCodigoQualificacao) == "10" ||
				tbEmpresas.get(idCodigoQualificacao) == "16" ||
				tbEmpresas.get(idCodigoQualificacao) == "28" ||
				tbEmpresas.get(idCodigoQualificacao) == "49")
					
					verificacao = true;
			}
		}
		return verificacao;
	}
}
