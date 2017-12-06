package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formacao database table.
 * 
 */
@Entity
@Table(name="FORMACAO")
@NamedQuery(name="Formacao.findAll", query="SELECT f FROM Formacao f")
public class Formacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_FORMACAO", unique=true, nullable=false)
	private Integer idFormacao;

	@Column(name="ANO_FORMATURA")
	private Integer anoFormatura;

	@Column(name="CURSO_FORMATURA", length=50)
	private String cursoFormatura;

	@Column(name="INSTITUICAO_FORMATURA", length=50)
	private String instituicaoFormatura;

	//bi-directional many-to-one association to Professor
	@OneToMany(mappedBy="formacao")
	private List<Professor> professors;

	public Formacao() {
	}

	public Integer getIdFormacao() {
		return this.idFormacao;
	}

	public void setIdFormacao(Integer idFormacao) {
		this.idFormacao = idFormacao;
	}

	public Integer getAnoFormatura() {
		return this.anoFormatura;
	}

	public void setAnoFormatura(Integer anoFormatura) {
		this.anoFormatura = anoFormatura;
	}

	public String getCursoFormatura() {
		return this.cursoFormatura;
	}

	public void setCursoFormatura(String cursoFormatura) {
		this.cursoFormatura = cursoFormatura;
	}

	public String getInstituicaoFormatura() {
		return this.instituicaoFormatura;
	}

	public void setInstituicaoFormatura(String instituicaoFormatura) {
		this.instituicaoFormatura = instituicaoFormatura;
	}

	public List<Professor> getProfessors() {
		return this.professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Professor addProfessor(Professor professor) {
		getProfessors().add(professor);
		professor.setFormacao(this);

		return professor;
	}

	public Professor removeProfessor(Professor professor) {
		getProfessors().remove(professor);
		professor.setFormacao(null);

		return professor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFormacao;
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
		Formacao other = (Formacao) obj;
		if (idFormacao != other.idFormacao)
			return false;
		return true;
	}
	
	

}