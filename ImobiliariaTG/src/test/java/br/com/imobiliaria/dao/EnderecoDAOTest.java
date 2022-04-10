package br.com.imobiliaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.imobiliaria.domain.Endereco;

public class EnderecoDAOTest {
	@Test // indica que é um teste
	@Ignore // vai ignorar esse teste ao rodar
	public void salvar() {
		Endereco endereco = new Endereco();
		endereco.setLogradrouro("Conselheiro Antônio Prado");
		endereco.setBairro("centro");
		endereco.setCidade("Santa Cruz do Rio Pardo");
		endereco.setCep("18900-000");
		endereco.setComplemento("teste");
		endereco.setNumero("78");
		endereco.setEstado("São Paulo");

		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.salvar(endereco);
	}

	@Test
	@Ignore
	public void listar() {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		List<Endereco> resultado = enderecoDAO.listar();
		
		System.out.println("Total de registros encontrados: " + resultado.size()); //exibe o total de registros
		
		//Esse for vai percorrer a lista e vai mostrar tudo o que achou
		for (Endereco endereco : resultado) {
			System.out.println(endereco.getLogradrouro() + " - " + endereco.getNumero() + " - " 
								+ endereco.getBairro());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscar(codigo);
		
		if(endereco == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println(endereco.getLogradrouro() + " - " + endereco.getNumero() + " - " 
				+ endereco.getBairro());
		}
	}
	
	@Test
//	@Ignore
	public void excluir(){
		Long codigo = 3L;
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscar(codigo);
		
		if(endereco == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			enderecoDAO.excluir(endereco);
			System.out.println("Registro removido: ");
			System.out.println(endereco.getLogradrouro() + " - " + endereco.getNumero() + " - " 
				+ endereco.getBairro());
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 3L;
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscar(codigo);
		
		if(endereco == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro editado - antes: ");
			System.out.println(endereco.getLogradrouro() + " - " + endereco.getNumero() + " - " 
				+ endereco.getBairro());
			
			endereco.setLogradrouro("Conselheiro dantas");
			enderecoDAO.editar(endereco);
			
			System.out.println("Registro editado -  depois: ");
			System.out.println(endereco.getLogradrouro() + " - " + endereco.getNumero() + " - " 
				+ endereco.getBairro());
		}
		
	}
}
