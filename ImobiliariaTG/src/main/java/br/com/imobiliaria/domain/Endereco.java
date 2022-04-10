package br.com.imobiliaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity // serve para dizer que endereço é uma entidade do hibernate, ou seja,
		// vai ser uma tabela
public class Endereco extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String logradrouro;
	
	@Column(length = 6, nullable = false)
	private String numero;
	
	@Column(length = 50, nullable = false)
	private String bairro;
	
	@Column(length = 50)
	private String complemento;
	
	@Column(length = 10, nullable = false)
	private String cep;
	
	@Column(length = 50, nullable = false)
	private String cidade;
	
	@Column(length = 20, nullable = false)
	private String estado;

	public String getLogradrouro() {
		return logradrouro;
	}

	public void setLogradrouro(String logradrouro) {
		this.logradrouro = logradrouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
