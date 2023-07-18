package com.elsonteixeira.nichoempresas.entidades;

public enum QualificacaoResponsavel {

	ADMINISTRADOR(5), 
	DIRETOR(10), 
	PRESIDENTE(16), 
	SOCIO_GERENTE(28), 
	SOCIO_ADMINSTRADOR(49);

	int idQualificacaoResponsavel;
	
	QualificacaoResponsavel(int idQualificacaoResponsavel) {
		this.idQualificacaoResponsavel = idQualificacaoResponsavel;
	}
	
	private int getIdQualificacaoResponsavel() {
		return idQualificacaoResponsavel;
	}
	
	public static QualificacaoResponsavel getById(int id){
		
		for(QualificacaoResponsavel qualificacaoResponsavel : values()) {
			if(qualificacaoResponsavel.getIdQualificacaoResponsavel() == id)
				return qualificacaoResponsavel;
		}
		return null;
	}
}