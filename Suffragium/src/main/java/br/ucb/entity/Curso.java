package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@Table(name="CURSO")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_CURSO", unique=true, nullable=false)
	private Integer idCurso;

	@Lob
	private String descricao;

	@Column(name="NOME_CURSO", length=50)
	private String nomeCurso;

	//bi-directional many-to-one association to CursoMateria
	@OneToMany(mappedBy="curso")
	private List<CursoMateria> cursoMaterias;

	//bi-directional many-to-one association to InstituicaoCurso
	@OneToMany(mappedBy="curso")
	private List<InstituicaoCurso> instituicaoCursos;

	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="curso")
	private List<Turma> turmas;

	public Curso() {
	}

	public Integer getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeCurso() {
		return this.nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public List<CursoMateria> getCursoMaterias() {
		return this.cursoMaterias;
	}

	public void setCursoMaterias(List<CursoMateria> cursoMaterias) {
		this.cursoMaterias = cursoMaterias;
	}

	public CursoMateria addCursoMateria(CursoMateria cursoMateria) {
		getCursoMaterias().add(cursoMateria);
		cursoMateria.setCurso(this);

		return cursoMateria;
	}

	public CursoMateria removeCursoMateria(CursoMateria cursoMateria) {
		getCursoMaterias().remove(cursoMateria);
		cursoMateria.setCurso(null);

		return cursoMateria;
	}

	public List<InstituicaoCurso> getInstituicaoCursos() {
		return this.instituicaoCursos;
	}

	public void setInstituicaoCursos(List<InstituicaoCurso> instituicaoCursos) {
		this.instituicaoCursos = instituicaoCursos;
	}

	public InstituicaoCurso addInstituicaoCurso(InstituicaoCurso instituicaoCurso) {
		getInstituicaoCursos().add(instituicaoCurso);
		instituicaoCurso.setCurso(this);

		return instituicaoCurso;
	}

	public InstituicaoCurso removeInstituicaoCurso(InstituicaoCurso instituicaoCurso) {
		getInstituicaoCursos().remove(instituicaoCurso);
		instituicaoCurso.setCurso(null);

		return instituicaoCurso;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setCurso(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setCurso(null);

		return turma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCurso;
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
		Curso other = (Curso) obj;
		if (idCurso != other.idCurso)
			return false;
		return true;
	}
	
	

}