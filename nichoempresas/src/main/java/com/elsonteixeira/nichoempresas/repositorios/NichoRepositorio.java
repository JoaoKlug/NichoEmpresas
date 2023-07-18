package com.elsonteixeira.nichoempresas.repositorios;

import com.elsonteixeira.nichoempresas.entidades.Empresa;
import com.elsonteixeira.nichoempresas.entidades.Matriz;
import com.elsonteixeira.nichoempresas.entidades.Socio;

public interface NichoRepositorio{

	public void cadastrarEmpresa(Empresa empresa);
	
	public void cadastrarMatriz(Matriz matriz);
	
	public void cadastrarSocio(Socio socio);
	
	public void exportarTbNicho(String endereco);
}
