package br.com.imobiliaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Imovel extends GenericDomain {

	@Column(nullable = false)
	private String caminhoDocumento;
	
	@Column(nullable = false)
	private String enderecoCompleto;

//	@OneToOne // chave estrangeira 1 para 1
//	@JoinColumn(nullable = false) // personalizar chaves estrangeiras
//	private Endereco endereco;

	@Column(length = 2, nullable = false)
	private String qtdComodos;

	@Column(length = 2, nullable = false)
	private String qtdCamas;

	@Column(length = 2, nullable = false)
	private String qtdBanheiros;

	@Column(nullable = false)
	private String regrasProprietario;

	private String observacoes;

	@ManyToOne // imóvel possui mais de um usuário (usuário proprietário e
				// usuário locador)
	@JoinColumn(nullable = false) // personalizar chaves estrangeiras
	private Usuario usuario;

	@Column(nullable = false, precision = 6, scale = 2) //precision é a quantidade de casas decimais, scale é qtd de casas depois da vírgula
	private BigDecimal valorDiaria;
	
	@Column(nullable = false)
	private Boolean ativo;

	public String getCaminhoDocumento() {
		return caminhoDocumento;
	}

	public void setCaminhoDocumento(String caminhoDocumento) {
		this.caminhoDocumento = caminhoDocumento;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	
	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

	public String getQtdComodos() {
		return qtdComodos;
	}

	public void setQtdComodos(String qtdComodos) {
		this.qtdComodos = qtdComodos;
	}

	public String getQtdCamas() {
		return qtdCamas;
	}

	public void setQtdCamas(String qtdCamas) {
		this.qtdCamas = qtdCamas;
	}

	public String getQtdBanheiros() {
		return qtdBanheiros;
	}

	public void setQtdBanheiros(String qtdBanheiros) {
		this.qtdBanheiros = qtdBanheiros;
	}

	public String getRegrasProprietario() {
		return regrasProprietario;
	}

	public void setRegrasProprietario(String regrasProprietario) {
		this.regrasProprietario = regrasProprietario;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
