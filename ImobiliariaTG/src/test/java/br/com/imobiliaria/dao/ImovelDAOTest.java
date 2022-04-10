package br.com.imobiliaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.imobiliaria.domain.Endereco;
import br.com.imobiliaria.domain.Imovel;
import br.com.imobiliaria.domain.Usuario;

public class ImovelDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Long codigoEndereco = 1L;
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscar(codigoEndereco);

		Long codigoUsuario = 2L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);

		Imovel imovel = new Imovel();
		imovel.setAtivo(true);
		imovel.setCaminhoDocumento("teste");
		imovel.setEndereco(endereco);
		imovel.setObservacoes("teste");
		imovel.setQtdBanheiros("2");
		imovel.setQtdCamas("3");
		imovel.setQtdComodos("6");
		imovel.setRegrasProprietario("teste");
		imovel.setUsuario(usuario);
		imovel.setValorDiaria(new BigDecimal(120.00));

		ImovelDAO imovelDAO = new ImovelDAO();
		imovelDAO.salvar(imovel);
	}

	@Test
	@Ignore
	public void listar() {
		ImovelDAO imovelDAO = new ImovelDAO();
		List<Imovel> resultado = imovelDAO.listar();

		for (Imovel imovel : resultado) {
			System.out.println("Código: " + imovel.getCodigo());
			System.out.println("Observação: " + imovel.getObservacoes());
			System.out.println(
					"Endereço: " + imovel.getEndereco().getLogradrouro() + " " + imovel.getEndereco().getNumero());
			System.out.println("Usuário: " + imovel.getUsuario().getNome());
			System.out.println("Valor Diária: " + imovel.getValorDiaria());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigo);

		System.out.println("Código: " + imovel.getCodigo());
		System.out.println("Observação: " + imovel.getObservacoes());
		System.out.println("Endereço: " + imovel.getEndereco().getLogradrouro() + " " + imovel.getEndereco().getNumero());
		System.out.println("Usuário: " + imovel.getUsuario().getNome());
		System.out.println("Valor Diária: " + imovel.getValorDiaria());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigo);
		
		imovelDAO.excluir(imovel);
		
		System.out.println("Imóvel removido: ");
		System.out.println("Código: " + imovel.getCodigo());
		System.out.println("Observação: " + imovel.getObservacoes());
		System.out.println("Endereço: " + imovel.getEndereco().getLogradrouro() + " " + imovel.getEndereco().getNumero());
		System.out.println("Usuário: " + imovel.getUsuario().getNome());
		System.out.println("Valor Diária: " + imovel.getValorDiaria());
	}
	
	@Test
//	@Ignore
	public void editar(){
		Long codigoImovel = 1L;
		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigoImovel);
		
		Long codigoUsuario = 4L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
		
		Long codigoEndereco = 5L;
		EnderecoDAO enderecoDAO =  new EnderecoDAO();
		Endereco endereco = enderecoDAO.buscar(codigoEndereco);
		
		System.out.println("Imóvel a ser editado: ");
		System.out.println("Código: " + imovel.getCodigo());
		System.out.println("Observação: " + imovel.getObservacoes());
		System.out.println("Endereço: " + imovel.getEndereco().getLogradrouro() + " " + imovel.getEndereco().getNumero());
		System.out.println("Usuário: " + imovel.getUsuario().getNome());
		System.out.println("Valor Diária: " + imovel.getValorDiaria());
		System.out.println();
		
		imovel.setObservacoes("dfcnodhnco");
		imovel.setUsuario(usuario);
		imovel.setEndereco(endereco);
		
		imovelDAO.editar(imovel);
		
		System.out.println("Imóvel editado: ");
		System.out.println("Código: " + imovel.getCodigo());
		System.out.println("Observação: " + imovel.getObservacoes());
		System.out.println("Endereço: " + imovel.getEndereco().getLogradrouro() + " " + imovel.getEndereco().getNumero());
		System.out.println("Usuário: " + imovel.getUsuario().getNome());
		System.out.println("Valor Diária: " + imovel.getValorDiaria());
	}
}
