package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the pergunta database table.
 * 
 */
@Entity
@Table(name = "PERGUNTA")
@NamedQuery(name = "Pergunta.findAll", query = "SELECT p FROM Pergunta p")
public class Pergunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_PERGUNTA", unique = true, nullable = false)
	private Integer idPergunta;

	@Lob
	private String descricao;

	// bi-directional many-to-one association to CriterioAvaliacao
	@OneToMany(mappedBy = "pergunta")
	private List<CriterioAvaliacao> criterioAvaliacaos;

	public Pergunta() {
	}

	public Integer getIdPergunta() {
		return this.idPergunta;
	}

	public void setIdPergunta(Integer idPergunta) {
		this.idPergunta = idPergunta;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<CriterioAvaliacao> getCriterioAvaliacaos() {
		return this.criterioAvaliacaos;
	}

	public void setCriterioAvaliacaos(List<CriterioAvaliacao> criterioAvaliacaos) {
		this.criterioAvaliacaos = criterioAvaliacaos;
	}

	public CriterioAvaliacao addCriterioAvaliacao(CriterioAvaliacao criterioAvaliacao) {
		getCriterioAvaliacaos().add(criterioAvaliacao);
		criterioAvaliacao.setPergunta(this);

		return criterioAvaliacao;
	}

	public CriterioAvaliacao removeCriterioAvaliacao(CriterioAvaliacao criterioAvaliacao) {
		getCriterioAvaliacaos().remove(criterioAvaliacao);
		criterioAvaliacao.setPergunta(null);

		return criterioAvaliacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPergunta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (idPergunta != other.idPergunta)
			return false;
		return true;
	}

}