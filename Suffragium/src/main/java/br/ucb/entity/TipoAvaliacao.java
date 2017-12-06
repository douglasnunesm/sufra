package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tipo_avaliacao database table.
 * 
 */
@Entity
@Table(name = "TIPO_AVALIACAO")
@NamedQuery(name = "TipoAvaliacao.findAll", query = "SELECT t FROM TipoAvaliacao t")
public class TipoAvaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_TIPO_AVALIACAO", unique = true, nullable = false)
	private Integer idTipoAvaliacao;

	@Lob
	private String descricao;

	// bi-directional many-to-one association to Avaliacao
	@OneToMany(mappedBy = "tipoAvaliacao")
	private List<Avaliacao> avaliacaos;

	public TipoAvaliacao() {
	}

	public Integer getIdTipoAvaliacao() {
		return this.idTipoAvaliacao;
	}

	public void setIdTipoAvaliacao(Integer idTipoAvaliacao) {
		this.idTipoAvaliacao = idTipoAvaliacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Avaliacao> getAvaliacaos() {
		return this.avaliacaos;
	}

	public void setAvaliacaos(List<Avaliacao> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}

	public Avaliacao addAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().add(avaliacao);
		avaliacao.setTipoAvaliacao(this);

		return avaliacao;
	}

	public Avaliacao removeAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().remove(avaliacao);
		avaliacao.setTipoAvaliacao(null);

		return avaliacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoAvaliacao;
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
		TipoAvaliacao other = (TipoAvaliacao) obj;
		if (idTipoAvaliacao != other.idTipoAvaliacao)
			return false;
		return true;
	}

}