package br.ucb.bean;

import java.awt.event.ItemEvent;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.ucb.dao.CriterioAvaliacaoDAO;
import br.ucb.entity.CriterioAvaliacao;

@ManagedBean
public class CriterioAvaliacaoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4018598183110526554L;

	CriterioAvaliacaoDAO dao = new CriterioAvaliacaoDAO();
	CriterioAvaliacao criterioAval = new CriterioAvaliacao();
	


	public CriterioAvaliacao getCriterioAval() {
		return criterioAval;
	}

	public void setCriterioAval(CriterioAvaliacao criterioAval) {
		this.criterioAval = criterioAval;
	}

	private void RadioItem(ItemEvent event){
		//System.out.println(this.radio.getNa);
		
	
	}

	public void avaliar() {
		criterioAval.getPergunta().setIdPergunta(1);
		// criterioAval.setNota(radio.get);
		dao.salvar(criterioAval);
	}

}
