package br.com.imobiliaria.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import br.com.imobiliaria.dao.PessoaDAO;
import br.com.imobiliaria.domain.Pessoa;

@ManagedBean
@SessionScoped
public class PrimeiroAcesso {
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@PostConstruct
	public void iniciar() {
		pessoa = new Pessoa();
	}

	public void salvar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);

			Messages.addGlobalInfo("Pessoa salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
			erro.printStackTrace();
		}
	}

}
