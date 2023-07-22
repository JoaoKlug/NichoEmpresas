package com.elsonteixeira.nichoempresas.controlador.diretorios;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;


public abstract class Diretorios {
	
	private final String EMPRESA_TIPO_ARQUIVO = "*.EMPRECSV";
	private final String MATRIZ_TIPO_ARQUIVO = "*.ESTABELE";
	private final String SOCIO_TIPO_ARQUIVO = "*.SOCIOCSV";
	
	private final String CNAE_NOME_ARQUIVO = "DESCRICAO_CNAE.CNAECSV";
	private final String MUNICIPIO_NOME_ARQUIVO = "MUNICIPIO.MUNICCSV";
	
	protected boolean diretorioValido;
	
	protected List<String> empresaCsvDirs;
	protected List<String> matrizesCsvDirs;
	protected List<String> sociosCsvDirs;
	protected String cnaeDescricoesDir;
	protected String municipiosCsvDir;
	
	protected String tbNichoDir;
		
	public Diretorios(String endereco) {
		
		try{
			diretorioValido = Files.exists(Path.of(endereco));
			
			tbNichoDir = setTbNichoDir(endereco);
			if(!tbNichoDir.isEmpty())
			{
				empresaCsvDirs = setDirsList(endereco,EMPRESA_TIPO_ARQUIVO);
				if(!empresaCsvDirs.isEmpty())
				{
					matrizesCsvDirs = setDirsList(endereco,MATRIZ_TIPO_ARQUIVO);
					sociosCsvDirs = setDirsList(endereco,SOCIO_TIPO_ARQUIVO);
					cnaeDescricoesDir = setDirs(CNAE_NOME_ARQUIVO);
					municipiosCsvDir = setDirs(MUNICIPIO_NOME_ARQUIVO);
				}
				else
					diretorioValido = false;
			}
			else
				diretorioValido = false;
			
		}catch(InvalidPathException ex) {
			System.out.println("Caracter invalido: " + endereco.charAt(ex.getIndex()));
			diretorioValido = false;
		}
	}
	
	private String setTbNichoDir(String endereco)
	{
		Path path = Path.of(endereco.concat("/tbNicho/tbNicho.csv"));
		try {
			Files.createDirectories(path.getParent());
			Files.createFile(path);
			return path.toString();
		} catch (IOException e) {
			System.out.println("Não foi possível criar um novo tbNicho.csv em " + endereco);
			return "";
		}
	}
	
	private List<String> setDirsList(String endereco, String tipoArquivo){
		
		List<String> dirsList = new ArrayList<String>();
		
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of(endereco) , tipoArquivo )){
			
			Iterator<Path> iterator = ds.iterator();
			
			while(iterator.hasNext()) {
				dirsList.add(iterator.next().toString());
			}
			
		} catch (IOException e) {
			System.out.println("Arquivo " + tipoArquivo + " não encontrado");
		}
		return dirsList;
	}
	
	private String setDirs(String nomeArquivo) {
		
		String endereco = "";
		Resource resource = new ClassPathResource(nomeArquivo);
		try {
			endereco = resource.getURL().toString();
		} catch (IOException e) {
			System.out.println(nomeArquivo + " não encontrado");
		}
		return endereco;
	}

	public boolean isDiretorioValido() {
		return diretorioValido;
	}
	
}
