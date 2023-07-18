package com.elsonteixeira.nichoempresas.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elsonteixeira.nichoempresas.entidades.Empresa;
import com.elsonteixeira.nichoempresas.entidades.Matriz;
import com.elsonteixeira.nichoempresas.entidades.Socio;

@Repository
public class NichoRepositorioJDBC implements NichoRepositorio{

	@Autowired
	private JdbcTemplate jdbcRepositorio;
	
	
	@Override
	public void cadastrarEmpresa(Empresa empresa) {
		
		String sqlQuery = NichoQuery.CADASTRAR_EMPRESA;
		
		jdbcRepositorio.update(sqlQuery,
				empresa.getCnpj(),
				empresa.getRazaoSocial(),
				empresa.getNaturezaJuridica().name(),
				empresa.getQualificacaoResponsavel().name()
				);
	}

	@Override
	public void cadastrarMatriz(Matriz matriz) {
		
		String sqlQuery = NichoQuery.CADASTRAR_MATRIZ;
		
		jdbcRepositorio.update(sqlQuery,
				matriz.getDataInicio(),
				matriz.getCnae(),
				matriz.getCnaeDescricao(),
				matriz.getMunicipio(),
				matriz.getUf(),
				matriz.getTelefonePrincipal(),
				matriz.getTelefoneSecundario(),
				matriz.getEmail(),
				matriz.getCnpj());
	}

	@Override
	public void cadastrarSocio(Socio socio) {
		
		String sqlQuery = NichoQuery.CADASTRAR_SOCIO;
		
		jdbcRepositorio.update(sqlQuery,
				socio.getNomeSocio(),
				socio.getFaixaEtariaSocio().name(),
				socio.getCnpj());
	}

	@Override
	public void exportarTbNicho(String endereco) {
		
		String sqlQuery = NichoQuery.EXPORTAR_TBNICHO;
		System.out.println(endereco);
		jdbcRepositorio.update(sqlQuery, endereco);
		
	}

}
