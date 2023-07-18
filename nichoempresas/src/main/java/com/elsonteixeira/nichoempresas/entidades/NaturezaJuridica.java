package com.elsonteixeira.nichoempresas.entidades;

public enum NaturezaJuridica {

	ASSOCIACAO_PRIVADA(3999), EIRELI(2305);

	int idNaturezaJuridica;
	
	NaturezaJuridica(int idNaturezaJuridica) {
		this.idNaturezaJuridica = idNaturezaJuridica;
	}
	
	private int getIdNaturezaJuridica() {
		return idNaturezaJuridica;
	}
	
	public static NaturezaJuridica getById (int id) {
		
		for(NaturezaJuridica naturezaJuridica : values())
		{
			if(naturezaJuridica.getIdNaturezaJuridica() == id)
				return naturezaJuridica;
		}
		return null;
	}
	
}