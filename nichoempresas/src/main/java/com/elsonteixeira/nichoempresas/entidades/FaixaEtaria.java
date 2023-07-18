package com.elsonteixeira.nichoempresas.entidades;

public enum FaixaEtaria {

	DE_13_A_20_ANOS(1),
	DE_21_A_30_ANOS(2),
	DE_31_A_40_ANOS(3),
	DE_41_A_50_ANOS(4),
	DE_51_A_60_ANOS(5),
	DE_61_A_70_ANOS(6),
	DE_71_A_80_ANOS(8),
	MAIORES_80_ANOS(9);
	
	int idFaixaEtaria;
	
	FaixaEtaria(int idFaixaEtaria) {
		this.idFaixaEtaria = idFaixaEtaria;
	}
	
	private int getIdFaixaEtaria() {
		return idFaixaEtaria;
	}
	
	public static FaixaEtaria getById(int id) {
		
		for(FaixaEtaria faixaEtaria : values())
		{
			if(faixaEtaria.getIdFaixaEtaria() == id)
				return faixaEtaria;
		}
		return null;
	}
	
}