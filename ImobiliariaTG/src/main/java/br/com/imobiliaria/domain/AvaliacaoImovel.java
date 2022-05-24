package br.com.imobiliaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class AvaliacaoImovel extends GenericDomain {
	
	@ManyToOne //um ímóvel pode ter várias avaliações
	@JoinColumn(nullable = false)
	private Imovel imovel;
	
	@ManyToOne //um usuário pode avaliar vários
	@JoinColumn(nullable = false)
	private Pessoa usuarioAvaliador;
	
	@Column(length = 2, nullable = false)
	private Integer nota;
	
	@Column(length = 50)
	private String comentario;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE) //criar o campo do tipo data
	private Date data;

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Pessoa getUsuarioAvaliador() {
		return usuarioAvaliador;
	}

	public void setUsuarioAvaliador(Pessoa usuarioAvaliador) {
		this.usuarioAvaliador = usuarioAvaliador;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
