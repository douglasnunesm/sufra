package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the avaliacao database table.
 * 
 */
@Entity
@Table(name="AVALIACAO")
@NamedQuery(name="Avaliacao.findAll", query="SELECT a FROM Avaliacao a")
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_AVALIACAO", unique=true, nullable=false)
	private Integer idAvaliacao;

	@Lob
	private String observacao;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="ID_ALUNO")
	private Aluno aluno;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name="ID_PROFESSOR")
	private Professor professor;

	//bi-directional many-to-one association to Instituicao
	@ManyToOne
	@JoinColumn(name="ID_INSTITUICAO")
	private Instituicao instituicao;

	//bi-directional many-to-one association to CriterioAvaliacao
	@ManyToOne
	@JoinColumn(name="ID_CRITERIO_AVALIACAO")
	private CriterioAvaliacao criterioAvaliacao;

	//bi-directional many-to-one association to TipoAvaliacao
	@ManyToOne
	@JoinColumn(name="ID_TIPO_AVALIACAO")
	private TipoAvaliacao tipoAvaliacao;

	public Avaliacao() {
	}

	public Integer getIdAvaliacao() {
		return this.idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Instituicao getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public CriterioAvaliacao getCriterioAvaliacao() {
		return this.criterioAvaliacao;
	}

	public void setCriterioAvaliacao(CriterioAvaliacao criterioAvaliacao) {
		this.criterioAvaliacao = criterioAvaliacao;
	}

	public TipoAvaliacao getTipoAvaliacao() {
		return this.tipoAvaliacao;
	}

	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAvaliacao;
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
		Avaliacao other = (Avaliacao) obj;
		if (idAvaliacao != other.idAvaliacao)
			return false;
		return true;
	}
	

}