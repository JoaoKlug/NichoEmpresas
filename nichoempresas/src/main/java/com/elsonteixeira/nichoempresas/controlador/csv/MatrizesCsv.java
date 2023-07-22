package com.elsonteixeira.nichoempresas.controlador.csv;

import java.util.Calendar;
import java.util.HashMap;

public class MatrizesCsv extends Csv {

	private final int idCnpj = 0;
	private final int idCodigoMatriz = 3;
	private final int idSituacaoCadastral = 5;
	private final int idDataInicio = 6;
	private final int idCnae = 7;
	private final int idUf = 19;
	private final int idCodigoMunicipio = 20;
	private final int idDddTelefonePrincipal = 21;
	private final int idTelefonePrincipal = 22;
	private final int idDddTelefoneSecundario = 23;
	private final int idTelefoneSecundario = 24;
	private final int idEmail = 27;
	
	
	public MatrizesCsv(String diretorio) {
		super(diretorio);
	}
	
	public HashMap<String,String> getDadosMatriz(long linha) {
		
		HashMap<Integer,String> tbMatrizes = this.getDadosLinhaCsv(linha);
		
		HashMap<String,String> dadosMatriz = new HashMap<String,String>();
		if(VerificacaoDados(tbMatrizes))
		{
			for(int i = 0; i<tbMatrizes.size(); i++ )
			{
				if(i == idCnpj)
					dadosMatriz.put("cnpj",tbMatrizes.get(idCnpj));
				else if(i == idDataInicio)
					dadosMatriz.put("dataInicio", tbMatrizes.get(idDataInicio));
				else if(i == idCnae)
					dadosMatriz.put("cnae", tbMatrizes.get(idCnae)) ;
				else if(i == idUf)
					dadosMatriz.put("uf", tbMatrizes.get(idUf)) ;
				else if(i == idCodigoMunicipio)
					dadosMatriz.put("codigoMunicipio", tbMatrizes.get(idCodigoMunicipio));
				else if(i == idDddTelefonePrincipal)
					dadosMatriz.put("dddTelefonePrincipal", tbMatrizes.get(idDddTelefonePrincipal)) ;
				else if(i == idTelefonePrincipal)
					dadosMatriz.put("telefonePrincipal", tbMatrizes.get(idTelefonePrincipal));
				else if(i == idDddTelefoneSecundario)
					dadosMatriz.put("dddTelefoneSecundario", tbMatrizes.get(idDddTelefoneSecundario)) ;
				else if(i == idTelefoneSecundario)
					dadosMatriz.put("telefoneSecundario", tbMatrizes.get(idTelefoneSecundario)) ;
				else if(i == idEmail)
					dadosMatriz.put("email",tbMatrizes.get(idEmail)) ;
			}
		}
		return dadosMatriz;
	}

	private boolean VerificacaoDados(HashMap<Integer,String> tbMatrizes)
	{
		boolean verificacao = false;
		
		if(tbMatrizes.get(idCodigoMatriz)== "1"){
			if(tbMatrizes.get(idSituacaoCadastral)== "2")
			{
				Calendar.getInstance();
				int dataAtual = Calendar.YEAR*10000 + Calendar.MONTH*100 + Calendar.DAY_OF_MONTH;
				int idade = dataAtual - Integer.parseInt(tbMatrizes.get(idDataInicio));
				if(idade> 20000)	
					verificacao = true;
			}
		}
		return verificacao;
	}
}
