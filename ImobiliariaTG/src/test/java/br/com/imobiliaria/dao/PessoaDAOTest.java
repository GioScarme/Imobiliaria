package br.com.imobiliaria.dao;

import java.text.ParseException;

import org.junit.Test;

import br.com.imobiliaria.domain.Pessoa;

public class PessoaDAOTest {
	@Test
//	@Ignore
	public void salvar() throws ParseException {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Giovanna Scarme de Mira");
		pessoa.setCpf("43265325806");
		pessoa.setRg("572280026");
		pessoa.setRua("Nicola Picinni");
		pessoa.setNumero(112);
		pessoa.setBairro("Luiz Brondi");
		pessoa.setCep("18915-374");
		pessoa.setCidade("Santa Cruz do Rio Pardo");
		pessoa.setComplemento("teste");
		pessoa.setCelular("14 996184885");
		pessoa.setEmail("scarmegiovanna@gmail.com");
		
		PessoaDAO pessoaDAO =  new PessoaDAO();
		pessoaDAO.salvar(pessoa);
	}

//	@Test
//	@Ignore
//	public void listar() {
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		List<Usuario> resultado = usuarioDAO.listar();
//
//		for (Usuario usuario : resultado) {
//			System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
//					+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
//			System.out.println();
//		}
//	}
//
//	@Test
//	@Ignore
//	public void buscar() {
//		Long codigo = 1L;
//
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		Usuario usuario = usuarioDAO.buscar(codigo);
//
//		System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
//				+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
//	}
//
//	@Test
//	@Ignore
//	public void excluir() {
//		Long codigo = 3L;
//
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		Usuario usuario = usuarioDAO.buscar(codigo);
//
//		usuarioDAO.excluir(usuario);
//
//		System.out.println("Usuário removido: ");
//		System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
//				+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
//	}
//
//	@Test
//	@Ignore
//	public void editar() {
//		Long codigoUsuario = 2L;
//		Long codigoEndereco = 1L;
//		
//		EnderecoDAO enderecoDAO = new EnderecoDAO();
//		Endereco endereco = enderecoDAO.buscar(codigoEndereco);
//		
//		System.out.println("Endereco: " + endereco.getLogradrouro() + " " + endereco.getNumero());
//
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
//
//		System.out.println("Usuário a ser editado: ");
//		System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
//				+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
//		
//		usuario.setNome("Luiza French");
//		usuario.setEnderecoCompleto("dcnoiwndccd");
//		usuarioDAO.editar(usuario);
//		
//		System.out.println("Usuário editado: ");
//		System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
//				+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
//	}
}
