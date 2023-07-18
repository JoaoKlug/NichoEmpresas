package com.elsonteixeira.nichoempresas.entidades;

public class Socio extends Nicho{

	private String nomeSocio;
	private FaixaEtaria faixaEtariaSocio;
	
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeSocio() {
		return nomeSocio;
	}
	public void setNomeSocio(String nomeSocio) {
		this.nomeSocio = nomeSocio;
	}
	public FaixaEtaria getFaixaEtariaSocio() {
		return faixaEtariaSocio;
	}
	public void setFaixaEtariaSocio(FaixaEtaria faixaEtariaSocio) {
		this.faixaEtariaSocio = faixaEtariaSocio;
	}
	
}