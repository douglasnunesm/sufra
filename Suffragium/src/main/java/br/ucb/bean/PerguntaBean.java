package br.ucb.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ucb.dao.PerguntaDAO;
import br.ucb.entity.Pergunta;

@ManagedBean
public class PerguntaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8207725047614333575L;
	PerguntaDAO perguntaDao = new PerguntaDAO();
	Pergunta pergunta = new Pergunta();
	String descricao;
	
	public PerguntaBean(){

	}
	
	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void inserirPergunta() {
		perguntaDao.salvar(pergunta);
		concluir();
	}

	public void concluir() {
		addMessage("Sucesso!", "Pergunta Inserida com sucesso!");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
