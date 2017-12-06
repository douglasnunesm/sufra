package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the turma database table.
 * 
 */
@Entity
@Table(name="TURMA")
@NamedQuery(name="Turma.findAll", query="SELECT t FROM Turma t")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_TURMA", unique=true, nullable=false)
	private Integer idTurma;

	private Integer ano;

	private Integer semestre;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="turma")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="ID_CURSO")
	private Curso curso;

	public Turma() {
	}

	public Integer getIdTurma() {
		return this.idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getSemestre() {
		return this.semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setTurma(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setTurma(null);

		return aluno;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTurma;
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
		Turma other = (Turma) obj;
		if (idTurma != other.idTurma)
			return false;
		return true;
	}
	

}