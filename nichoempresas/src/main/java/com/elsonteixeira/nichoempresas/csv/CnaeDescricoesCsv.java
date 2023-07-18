package com.elsonteixeira.nichoempresas.csv;

import java.util.HashMap;

public class CnaeDescricoesCsv extends Csv {
 
	private final int idCnae = 0;
	private final int idDescricaoCnae = 1;
	
	public CnaeDescricoesCsv (String diretorio) {
		super(diretorio);
	}
	
	public String getDescricaoCnae(String cnae) {
		
		String descricaoCnae = "";
		for(long i = 0; i<this.totalLinhas; i++)
		{
			HashMap<Integer,String> tbCnae = this.getDadosLinhaCsv(i);
			if(tbCnae.get(idCnae) == cnae)
			{
				descricaoCnae = tbCnae.get(idDescricaoCnae);
				break;
			}
		}
		return descricaoCnae;
	}
}
