package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the criterio_avaliacao database table.
 * 
 */
@Entity
@Table(name = "CRITERIO_AVALIACAO")
@NamedQuery(name = "CriterioAvaliacao.findAll", query = "SELECT c FROM CriterioAvaliacao c")
public class CriterioAvaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_CRITERIO_AVALIACAO", unique = true, nullable = false)
	private Integer idCriterioAvaliacao;

	private Integer nota;

	// bi-directional many-to-one association to Avaliacao
	@OneToMany(mappedBy = "criterioAvaliacao")
	private List<Avaliacao> avaliacaos;

	// bi-directional many-to-one association to Pergunta
	@ManyToOne
	@JoinColumn(name = "ID_PERGUNTA")
	private Pergunta pergunta;

	public CriterioAvaliacao() {
	}

	public Integer getIdCriterioAvaliacao() {
		return this.idCriterioAvaliacao;
	}

	public void setIdCriterioAvaliacao(Integer idCriterioAvaliacao) {
		this.idCriterioAvaliacao = idCriterioAvaliacao;
	}

	public Integer getNota() {
		return this.nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public List<Avaliacao> getAvaliacaos() {
		return this.avaliacaos;
	}

	public void setAvaliacaos(List<Avaliacao> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}

	public Avaliacao addAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().add(avaliacao);
		avaliacao.setCriterioAvaliacao(this);

		return avaliacao;
	}

	public Avaliacao removeAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().remove(avaliacao);
		avaliacao.setCriterioAvaliacao(null);

		return avaliacao;
	}

	public Pergunta getPergunta() {
		return this.pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCriterioAvaliacao;
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
		CriterioAvaliacao other = (CriterioAvaliacao) obj;
		if (idCriterioAvaliacao != other.idCriterioAvaliacao)
			return false;
		return true;
	}

}