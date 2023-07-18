package com.elsonteixeira.nichoempresas.entidades;

import java.time.LocalDate;

public class Matriz extends Nicho {

	private LocalDate dataInicio;
	private Integer cnae;
	private String cnaeDescricao;
	private String municipio;
	private String uf;
	private String telefonePrincipal;
	private String telefoneSecundario;
	private String email;
	
	public Integer getCnpj() {
		return this.cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public int getCnae() {
		return cnae;
	}
	public void setCnae(Integer cnae) {
		this.cnae = cnae;
	}
	public String getCnaeDescricao() {
		return cnaeDescricao;
	}
	public void setCnaeDescricao(String cnaeDescricao) {
		this.cnaeDescricao = cnaeDescricao;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}
	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}
	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}
	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}