package br.com.imobiliaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.imobiliaria.domain.AvaliacaoImovel;
import br.com.imobiliaria.domain.Imovel;
import br.com.imobiliaria.domain.Pessoa;
import br.com.imobiliaria.domain.Usuario;

public class AvaliacaoImovelDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {
		Long codigoImovel = 1L;
		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigoImovel);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		AvaliacaoImovel avaliacaoImovel = new AvaliacaoImovel();

		avaliacaoImovel.setComentario("ótimo");
		avaliacaoImovel.setData(new SimpleDateFormat("dd/MM/yyyy").parse("18/04/2022"));
		avaliacaoImovel.setImovel(imovel);
		avaliacaoImovel.setNota(10);
		avaliacaoImovel.setUsuarioAvaliador(pessoa);

		AvaliacaoImovelDAO avaliacaoImovelDAO = new AvaliacaoImovelDAO();
		avaliacaoImovelDAO.salvar(avaliacaoImovel);
	}

	@Test
	@Ignore
	public void listar() {
		AvaliacaoImovelDAO avaliacaoImovelDAO = new AvaliacaoImovelDAO();
		List<AvaliacaoImovel> resultado = avaliacaoImovelDAO.listar();

		for (AvaliacaoImovel avaliacaoImovel : resultado) {
			System.out.println("Código: " + avaliacaoImovel.getCodigo());
			System.out.println("Data: " + avaliacaoImovel.getData());
			System.out.println("Cógido Imóvel: " + avaliacaoImovel.getImovel().getCodigo());
			System.out.println("Nota: " + avaliacaoImovel.getNota());
			System.out.println("Usuário: " + avaliacaoImovel.getUsuarioAvaliador().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		AvaliacaoImovelDAO avaliacaoImovelDAO = new AvaliacaoImovelDAO();
		AvaliacaoImovel avaliacaoImovel = avaliacaoImovelDAO.buscar(codigo);

		System.out.println("Código: " + avaliacaoImovel.getCodigo());
		System.out.println("Data: " + avaliacaoImovel.getData());
		System.out.println("Cógido Imóvel: " + avaliacaoImovel.getImovel().getCodigo());
		System.out.println("Nota: " + avaliacaoImovel.getNota());
		System.out.println("Usuário: " + avaliacaoImovel.getUsuarioAvaliador().getNome());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		AvaliacaoImovelDAO avaliacaoImovelDAO = new AvaliacaoImovelDAO();
		AvaliacaoImovel avaliacaoImovel = avaliacaoImovelDAO.buscar(codigo);
		
		avaliacaoImovelDAO.excluir(avaliacaoImovel);
		
		System.out.println("Avaliação removida: ");
		System.out.println("Código: " + avaliacaoImovel.getCodigo());
		System.out.println("Data: " + avaliacaoImovel.getData());
		System.out.println("Cógido Imóvel: " + avaliacaoImovel.getImovel().getCodigo());
		System.out.println("Nota: " + avaliacaoImovel.getNota());
		System.out.println("Usuário: " + avaliacaoImovel.getUsuarioAvaliador().getNome());
	}
	
	@Test
	public void editar(){
		Long codigo = 1L;

		AvaliacaoImovelDAO avaliacaoImovelDAO = new AvaliacaoImovelDAO();
		AvaliacaoImovel avaliacaoImovel = avaliacaoImovelDAO.buscar(codigo);
		
		Long codigoImovel = 3L;
		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigoImovel);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		System.out.println("Avaliação a ser editada: ");
		System.out.println("Código: " + avaliacaoImovel.getCodigo());
		System.out.println("Data: " + avaliacaoImovel.getData());
		System.out.println("Cógido Imóvel: " + avaliacaoImovel.getImovel().getCodigo());
		System.out.println("Nota: " + avaliacaoImovel.getNota());
		System.out.println("Usuário: " + avaliacaoImovel.getUsuarioAvaliador().getNome());
		
		avaliacaoImovel.setComentario("fgvnkoperjng");
		avaliacaoImovel.setImovel(imovel);
		avaliacaoImovel.setUsuarioAvaliador(pessoa);
		
		avaliacaoImovelDAO.editar(avaliacaoImovel);
		
		System.out.println("Avaliação editada: ");
		System.out.println("Código: " + avaliacaoImovel.getCodigo());
		System.out.println("Data: " + avaliacaoImovel.getData());
		System.out.println("Cógido Imóvel: " + avaliacaoImovel.getImovel().getCodigo());
		System.out.println("Nota: " + avaliacaoImovel.getNota());
		System.out.println("Usuário: " + avaliacaoImovel.getUsuarioAvaliador().getNome());
	}
}
