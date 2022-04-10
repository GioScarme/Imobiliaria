package br.com.imobiliaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.imobiliaria.domain.ImagemImovel;
import br.com.imobiliaria.domain.Imovel;

public class ImagemImovelDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Long codigo = 1L;
		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigo);

		ImagemImovel imagemImovel = new ImagemImovel();
		imagemImovel.setCaminhoImagem("teste");
		imagemImovel.setImovel(imovel);

		ImagemImovelDAO imagemImovelDAO = new ImagemImovelDAO();
		imagemImovelDAO.salvar(imagemImovel);

	}

	@Test
	@Ignore
	public void listar() {
		ImagemImovelDAO imagemImovelDAO = new ImagemImovelDAO();
		List<ImagemImovel> resultado = imagemImovelDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());

		for (ImagemImovel imagemImovel : resultado) {
			System.out.println("Caminho imagem: " + imagemImovel.getCaminhoImagem());
			System.out.println("Imóvel da imagem: " + imagemImovel.getImovel().getCodigo());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ImagemImovelDAO imagemImovelDAO = new ImagemImovelDAO();
		ImagemImovel imagemImovel = imagemImovelDAO.buscar(codigo);

		System.out.println("Caminho imagem: " + imagemImovel.getCaminhoImagem());
		System.out.println("Imóvel da imagem: " + imagemImovel.getImovel().getCodigo());

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;

		ImagemImovelDAO imagemImovelDAO = new ImagemImovelDAO();
		ImagemImovel imagemImovel = imagemImovelDAO.buscar(codigo);
		
		imagemImovelDAO.excluir(imagemImovel);
		
		System.out.println("Imagem removida: ");
		System.out.println("Caminho imagem: " + imagemImovel.getCaminhoImagem());
		System.out.println("Imóvel da imagem: " + imagemImovel.getImovel().getCodigo());
		
	}
	
	@Test
	public void editar(){
		Long codigoImagem = 3L;
		ImagemImovelDAO imagemImovelDAO = new ImagemImovelDAO();
		ImagemImovel imagemImovel = imagemImovelDAO.buscar(codigoImagem);
		
		Long codigoImovel = 3L;
		ImovelDAO imovelDAO = new ImovelDAO();
		Imovel imovel = imovelDAO.buscar(codigoImovel);
		
		System.out.println("Imagem a ser editada: ");
		System.out.println("Caminho imagem: " + imagemImovel.getCaminhoImagem());
		System.out.println("Imóvel da imagem: " + imagemImovel.getImovel().getCodigo());
		
		imagemImovel.setCaminhoImagem("frgvnknl");
		imagemImovel.setImovel(imovel);
		
		imagemImovelDAO.editar(imagemImovel);
		
		System.out.println("Imagem a ser editada: ");
		System.out.println("Caminho imagem: " + imagemImovel.getCaminhoImagem());
		System.out.println("Imóvel da imagem: " + imagemImovel.getImovel().getCodigo());
		
		
	}
	
	
}
