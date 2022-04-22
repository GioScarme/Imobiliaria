package br.com.imobiliaria.bean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.imobiliaria.dao.CidadeDAO;
import br.com.imobiliaria.dao.ImovelDAO;
import br.com.imobiliaria.dao.UsuarioDAO;
import br.com.imobiliaria.domain.Cidade;
import br.com.imobiliaria.domain.Imovel;
import br.com.imobiliaria.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ImovelBean implements Serializable{
	private Imovel imovel;
	private List<Imovel> imoveis;
	private List<Usuario> usuarios;
	private List<Cidade> cidades;
	private UploadedFile file;

	@PostConstruct // chamar o método listar no momento em que a tela é criada
	public void listar() {
		try {
			ImovelDAO imovelDAO = new ImovelDAO();
			imoveis = imovelDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os imóveis");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			imovel = new Imovel();

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar incluir um novo imóvel");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {

			ImovelDAO imovelDAO = new ImovelDAO();
			imovelDAO.merge(imovel);

			imoveis = imovelDAO.listar();
			novo();

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

			Messages.addGlobalInfo("Imóvel Salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o Imóvel!");
			erro.printStackTrace(); // serve pra imprimir o erro
		}

	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	// public void handleFileUpload(FileUploadEvent event) {
	// try{
	// Imovel imoveldoc = new Imovel();
	// imoveldoc.setCaminhoDocumento(event.getFile().getInputstream());
	//
	// } catch (RuntimeException e) {
	// e.printStackTrace();
	// }
	// FacesMessage message = new FacesMessage("Sucesso!", "Arquivo anexado.");
	// FacesContext.getCurrentInstance().addMessage("msgFile", message);
	// }
	// public String create() {
	// try {
	// getFacade().create(current);
	// JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ArquivoCreated"));
	// return prepareCreate();
	// } catch (Exception e) {
	// JsfUtil.addErrorMessage(e,
	// ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
	// return null;
	// }
	// }

	public void handleFileUpload(FileUploadEvent event) throws IOException {
		try {
			// Cria um arquivo UploadFile, para receber o arquivo do evento
			UploadedFile arq = event.getFile();
			InputStream in = new BufferedInputStream(arq.getInputstream());
			// copiar para pasta do projeto
			File file = new File("/home/ifrs/img/" + arq.getFileName());
			// O método file.getAbsolutePath() fornece o caminho do arquivo
			// criado
			// Pode ser usado para ligar algum objeto do banco ao arquivo
			// enviado
			imovel.setCaminhoDocumento(file.getAbsolutePath());
			FileOutputStream fout = new FileOutputStream(file);
			while (in.available() != 0) {
				fout.write(in.read());
			}

			fout.close();
			FacesMessage msg = new FacesMessage("O Arquivo ", file.getName() + " salvo.");
			FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			imovel = (Imovel) evento.getComponent().getAttributes().get("imovelSelecionado");

			ImovelDAO imovelDAO = new ImovelDAO();
			imovelDAO.excluir(imovel);
			
			imoveis = imovelDAO.listar();

			Messages.addGlobalInfo("Imóvel removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o imóvel");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			imovel = (Imovel) evento.getComponent().getAttributes().get("imovelSelecionado");

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar editar o imóvel");
			erro.printStackTrace();
		}	
	}

	// -----------Getter and Setters
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
}
