package br.com.imobiliaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.imobiliaria.domain.Cidade;
import br.com.imobiliaria.domain.Imovel;
import br.com.imobiliaria.domain.Pessoa;
import br.com.imobiliaria.domain.Usuario;

public class ImovelDAOTest {
	@Test
//	@Ignore
	public void salvar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(2L);

		Imovel imovel = new Imovel();
		imovel.setAtivo(true);
		imovel.setCaminhoDocumento("testeEEEEEEEEEEE");
		imovel.setEnderecoCompleto("testeEEEE");
		imovel.setObservacoes("testeEEEEEEEEE");
		imovel.setQtdBanheiros("2");
		imovel.setQtdCamas("3");
		imovel.setQtdComodos("6");
		imovel.setRegrasProprietario("testeEEEEEE");
		imovel.setPessoa(pessoa);
		imovel.setValorDiaria(new BigDecimal(140.00));
		imovel.setCidade(cidade);

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
					"Endereço: " + imovel.getEnderecoCompleto());
			System.out.println("Usuário: " + imovel.getPessoa().getNome());
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
		System.out.println("Endereço: " + imovel.getEnderecoCompleto());
		System.out.println("Usuário: " + imovel.getPessoa().getNome());
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
		System.out.println("Endereço: " + imovel.getEnderecoCompleto());
		System.out.println("Usuário: " + imovel.getPessoa().getNome());
		System.out.println("Valor Diária: " + imovel.getValorDiaria());
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoImovel = 1L;
		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigoImovel);
		
		Long codigoPessoa = 1L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		System.out.println("Imóvel a ser editado: ");
		System.out.println("Código: " + imovel.getCodigo());
		System.out.println("Observação: " + imovel.getObservacoes());
		System.out.println("Endereço: " + imovel.getEnderecoCompleto());
		System.out.println("Usuário: " + imovel.getPessoa().getNome());
		System.out.println("Valor Diária: " + imovel.getValorDiaria());
		System.out.println();
		
		imovel.setObservacoes("dfcnodhnco");
		imovel.setPessoa(pessoa);
		imovel.setEnderecoCompleto("");
		
		imovelDAO.editar(imovel);
		
		System.out.println("Imóvel editado: ");
		System.out.println("Código: " + imovel.getCodigo());
		System.out.println("Observação: " + imovel.getObservacoes());
		System.out.println("Endereço: " + imovel.getEnderecoCompleto());
		System.out.println("Usuário: " + imovel.getPessoa().getNome());
		System.out.println("Valor Diária: " + imovel.getValorDiaria());
	}
}
