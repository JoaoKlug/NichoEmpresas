package com.elsonteixeira.nichoempresas.entidades;


public class Empresa extends Nicho{

	private String razaoSocial;
	private NaturezaJuridica naturezaJuridica;
	private QualificacaoResponsavel qualificacaoResponsavel;
	
	public Integer getCnpj() {
		return this.cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public NaturezaJuridica getNaturezaJuridica() {
		return naturezaJuridica;
	}
	public void setNaturezaJuridica(NaturezaJuridica naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}
	public QualificacaoResponsavel getQualificacaoResponsavel() {
		return qualificacaoResponsavel;
	}
	public void setQualificacaoResponsavel(QualificacaoResponsavel qualificacaoResponsavel) {
		this.qualificacaoResponsavel = qualificacaoResponsavel;
	}
	
}