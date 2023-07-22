package com.elsonteixeira.nichoempresas.controlador.csv;

import java.util.HashMap;

public class MunicipiosCsv extends Csv {

	private final int idCodigoMunicipio = 0;
	private final int idNomeMunicipio = 1;
	
	public MunicipiosCsv(String diretorio) {
		super(diretorio);
	}
	
	public String getNomeMunicipio(String codigoMunicipio) {
		
		String nomeMunicipio = "";
		for(long i = 0; i<this.totalLinhas; i++)
		{
			HashMap<Integer,String> tbMunicipio = this.getDadosLinhaCsv(i);
			if(tbMunicipio.get(idCodigoMunicipio) == codigoMunicipio)
			{
				nomeMunicipio = tbMunicipio.get(idNomeMunicipio);
				break;
			}
		}
		return nomeMunicipio;
	}
}
