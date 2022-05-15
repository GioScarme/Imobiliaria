package br.com.imobiliaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 22, nullable = false)
	private String cpf;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE) //criar o campo do tipo data
	private Date dataNascimento;

	@Column(length = 50, nullable = false, unique = true)
	private String login;

	@Column(length = 32, nullable = false)
	private String senha;
	
	@Transient //não vai ser salvo no banco
	private String senhaSemCriptografia;

	@Column(length = 15, nullable = false)
	private String telefone;
	
	@Column(length = 50, nullable = false)
	private String enderecoCompleto;
	
//	@OneToOne //chave estrangeira 1 para 1, usuário possui apenas um endereço, e o mesmo endereço possui apenas um usuário
//	@JoinColumn(nullable = false) // personalizar chaves estrangeiras
//	private Endereco endereco;
	
	@Column(nullable = false)
	private Boolean ativo;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	
	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}
	
	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

}
