package br.com.imobiliaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ImagemImovel extends GenericDomain {
	
	@Column(nullable = false)
	private String caminhoImagem;
	
	@ManyToOne //um imóvel pode ter várias imagens 
	@JoinColumn(nullable = false)
	private Imovel imovel;

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

}
