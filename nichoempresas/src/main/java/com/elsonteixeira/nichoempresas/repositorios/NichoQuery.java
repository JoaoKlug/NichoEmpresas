package com.elsonteixeira.nichoempresas.repositorios;

public class NichoQuery {

	public static final String CADASTRAR_EMPRESA = 
			"INSERT INTO tb_nicho("
			+ "cnpj_empresa,"
			+ "razao_social_empresa,"
			+ "natureza_juridica_empresa,"
			+ "qualificacao_responsavel_empresa)"
				+ "VALUES(?,?,?,?)";
	
	public static final String CADASTRAR_MATRIZ =
			"UPDATE tb_nicho SET "
			+ "data_inicio_matriz = ?,"
			+ "cnae_matriz = ?,"
			+ "cnae_matriz_descricao = ?,"
			+ "municipio_matriz = ?,"
			+ "uf_matriz = ?, "
			+ "telefone_principal_matriz = ?,"
			+ "telefone_secundario_matriz = ?,"
			+ "email_matriz = ?"
				+ " WHERE cnpj_empresa = ?";
	
	public static final String CADASTRAR_SOCIO =
			"UPDATE tb_nicho SET "
			+ "nome_socio = ?,"
			+ "faixa_etaria_socio = ?"
				+ " WHERE cnpj_empresa = ?";
	
	public static final String EXPORTAR_TBNICHO = 
			"COPY tb_nicho TO ? WITH DELIMITER ';' CSV";
}
