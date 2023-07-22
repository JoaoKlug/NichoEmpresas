package com.elsonteixeira.nichoempresas.controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elsonteixeira.nichoempresas.controlador.csv.CnaeDescricoesCsv;
import com.elsonteixeira.nichoempresas.controlador.csv.EmpresasCsv;
import com.elsonteixeira.nichoempresas.controlador.csv.MatrizesCsv;
import com.elsonteixeira.nichoempresas.controlador.csv.MunicipiosCsv;
import com.elsonteixeira.nichoempresas.controlador.csv.SociosCsv;
import com.elsonteixeira.nichoempresas.controlador.diretorios.Diretorios;
import com.elsonteixeira.nichoempresas.entidades.Empresa;
import com.elsonteixeira.nichoempresas.entidades.FaixaEtaria;
import com.elsonteixeira.nichoempresas.entidades.Matriz;
import com.elsonteixeira.nichoempresas.entidades.NaturezaJuridica;
import com.elsonteixeira.nichoempresas.entidades.QualificacaoResponsavel;
import com.elsonteixeira.nichoempresas.entidades.Socio;
import com.elsonteixeira.nichoempresas.repositorios.NichoRepositorio;

public class NichoControlador extends Diretorios{

	private List<Integer> cnpjs;
	
	@Autowired
	private NichoRepositorio nichoRepositorio;
	
	public NichoControlador(String endereco){

		super(endereco);
		cnpjs = new ArrayList<Integer>();
		
	}
	
	public void cadastrarNicho() {
		
		cadastrarEmpresa();
		if(!matrizesCsvDirs.isEmpty() && !cnaeDescricoesDir.isEmpty() && !municipiosCsvDir.isEmpty())
			cadastrarMatriz();
		if(!sociosCsvDirs.isEmpty())
			cadastrarSocio();
			
		nichoRepositorio.exportarTbNicho(tbNichoDir);
	}
	
	private void cadastrarEmpresa() {
		
		for(int i = 0; i< empresaCsvDirs.size(); i++)
		{
			EmpresasCsv empresasCsv = new EmpresasCsv(empresaCsvDirs.get(i));
			
			System.out.println("Lendo " + empresaCsvDirs.get(i) + " ... Linhas: " + empresasCsv.getTotalLinhas());
			
			for(long j = 0; j < empresasCsv.getTotalLinhas(); j++ )
			{
				HashMap<String,String> dadosEmpresa = empresasCsv.getDadosEmpresa(j);
				if(j%100000 == 0)
				System.out.println("Linha atual: " + j);
				if(!dadosEmpresa.isEmpty())
				{
					if(dadosEmpresa.get("cnpj")!= "")
					{
						Empresa empresa = new Empresa();
						
						empresa.setCnpj(Integer.valueOf(dadosEmpresa.get("cnpj")));
						empresa.setRazaoSocial(dadosEmpresa.get("razaoSocial"));
						empresa.setNaturezaJuridica(
							NaturezaJuridica.getById(Integer.valueOf(dadosEmpresa.get("idNaturezaJuridica")))
								);
						empresa.setQualificacaoResponsavel(
							QualificacaoResponsavel.getById(Integer.valueOf(dadosEmpresa.get("idQualificacaoResponsavel")))
								);
						
						nichoRepositorio.cadastrarEmpresa(empresa);
						System.out.println("Empresa " + empresa.getCnpj() + " cadastrada");
						cnpjs.add(empresa.getCnpj());
					}
				}
			}
		}
	}
	
	private void cadastrarSocio() {
		
		for(int i = 0; i<sociosCsvDirs.size(); i++)
		{
			SociosCsv sociosCsv = new SociosCsv(sociosCsvDirs.get(i));
			System.out.println("Lendo " + sociosCsvDirs.get(i) + " ... Linhas: " + sociosCsv.getTotalLinhas());
			for(long j = 0; j<sociosCsv.getTotalLinhas(); j++) 
			{
				HashMap<String,String> dadosSocio = sociosCsv.getDadosSocio(j);
				
				if(!dadosSocio.isEmpty())
				{
					if(cnpjs.contains(Integer.valueOf(dadosSocio.get("cnpj"))))
					{		
						Socio socio = new Socio();
						
						socio.setCnpj(Integer.valueOf(dadosSocio.get("cnpj")));
						socio.setNomeSocio(dadosSocio.get("nomeSocio"));
						socio.setFaixaEtariaSocio(
							FaixaEtaria.getById(Integer.valueOf(dadosSocio.get("idFaixaEtaria")))
								);
						nichoRepositorio.cadastrarSocio(socio);
						System.out.println("Socio " + socio.getCnpj() + " cadastrado");
					}
				}
			}
		}
	}
	
	private void cadastrarMatriz(){
		
		for(int i = 0; i<matrizesCsvDirs.size(); i++) 
		{
			MatrizesCsv matrizesCsv = new MatrizesCsv(matrizesCsvDirs.get(i));
			System.out.println("Lendo " + matrizesCsvDirs.get(i) + " ... Linhas: " + matrizesCsv.getTotalLinhas());
			
			for(long j = 0; j<matrizesCsv.getTotalLinhas(); j++)
			{
				HashMap<String,String> dadosMatriz = matrizesCsv.getDadosMatriz(j);
				if(j%10 == 0)
					System.out.println("Linha Atual: " + j );
				if(!dadosMatriz.isEmpty())
				{
					if(cnpjs.contains(Integer.valueOf(dadosMatriz.get("cnpj"))))
					{
						Matriz matriz = new Matriz();
						
						matriz.setCnpj(Integer.valueOf(dadosMatriz.get("cnpj")));
						matriz.setDataInicio(getDataInicio(dadosMatriz.get("dataInicio")));
						matriz.setCnae(Integer.valueOf(dadosMatriz.get("cnae")));
						matriz.setCnaeDescricao(getCnaeDescricao("cnae"));
						matriz.setUf(dadosMatriz.get("uf"));
						matriz.setMunicipio(getNomeMunicipio(dadosMatriz.get("codigoMunicipio")));
						matriz.setTelefonePrincipal("(" + dadosMatriz.get("dddTelefonePrincipal")+ ")" 
								+ dadosMatriz.get("telefonePrincipal"));
						matriz.setTelefoneSecundario("(" + dadosMatriz.get("dddTelefoneSecundario")+ ")" 
								+ dadosMatriz.get("telefoneSecundario"));
						matriz.setEmail(dadosMatriz.get("email"));
						
						
						nichoRepositorio.cadastrarMatriz(matriz);
						System.out.println("Matriz " + matriz.getCnpj() + " cadastrada");
					}
				}
			}
		}
	}
	
	private LocalDate getDataInicio(String dataString) {
		
		LocalDate dataInicio = LocalDate.parse("0000-00-00");
		
		if(dataString != "")
		{
			String dataFormatada = "";
			for(int i = 0; i<dataString.length(); i++) {
				
				dataFormatada = String.valueOf(dataString.charAt(i));
				if(i== 3 || i == 5) {
					dataFormatada = dataFormatada.concat("-");
				}
			dataInicio = LocalDate.parse(dataFormatada,DateTimeFormatter.ofPattern("yyyy-MM-dd") );
			}
		}
		return dataInicio;
		
	}
	
	private String getNomeMunicipio(String codigoMunicipio) {
		
		MunicipiosCsv municipioCsv = new MunicipiosCsv(municipiosCsvDir);
		System.out.println("Lendo " + municipiosCsvDir + " ... Linhas: " + municipioCsv.getTotalLinhas());
		
		return municipioCsv.getNomeMunicipio(codigoMunicipio);
	}
	
	private String getCnaeDescricao(String cnae) {
		
		CnaeDescricoesCsv cnaeDescricoesCsv = new CnaeDescricoesCsv(cnaeDescricoesDir);
		System.out.println("Lendo " + cnaeDescricoesDir + " ... Linhas: " + cnaeDescricoesCsv.getTotalLinhas());
		
		return cnaeDescricoesCsv.getDescricaoCnae(cnae);
	}
}
