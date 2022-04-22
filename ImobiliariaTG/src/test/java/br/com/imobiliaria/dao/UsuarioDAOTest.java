package br.com.imobiliaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.imobiliaria.domain.Endereco;
import br.com.imobiliaria.domain.Usuario;

public class UsuarioDAOTest {
	@Test
//	@Ignore
	public void salvar() throws ParseException {
//		Long codigoEndereco = 1L;
		
//		EnderecoDAO enderecoDAO = new EnderecoDAO();
//
//		Endereco endereco = enderecoDAO.buscar(codigoEndereco);

		Usuario usuario = new Usuario();
		usuario.setCpf("488.653.258-08");
		usuario.setAtivo(true);
		usuario.setEnderecoCompleto("Rua Antonio Eldorado kckckc 1221");
//		usuario.setEndereco(endereco);
		usuario.setLogin("scarmegio@gmail.com");
		usuario.setNome("Marianna Scarme de Mira");
		usuario.setSenha("1234");
		usuario.setTelefone("14 996524878");
		usuario.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("19/06/2000"));

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();

		for (Usuario usuario : resultado) {
			System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
					+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
				+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		usuarioDAO.excluir(usuario);

		System.out.println("Usuário removido: ");
		System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
				+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoUsuario = 2L;
		Long codigoEndereco = 1L;
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscar(codigoEndereco);
		
		System.out.println("Endereco: " + endereco.getLogradrouro() + " " + endereco.getNumero());

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);

		System.out.println("Usuário a ser editado: ");
		System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
				+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
		
		usuario.setNome("Luiza French");
		usuario.setEnderecoCompleto("dcnoiwndccd");
		usuarioDAO.editar(usuario);
		
		System.out.println("Usuário editado: ");
		System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data Nasc: "
				+ usuario.getDataNascimento() + " Endereco: " + usuario.getEnderecoCompleto());
	}
}
