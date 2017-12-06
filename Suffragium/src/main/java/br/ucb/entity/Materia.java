package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the materia database table.
 * 
 */
@Entity
@Table(name = "MATERIA")
@NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_MATERIA", unique = true, nullable = false)
	private Integer idMateria;

	@Column(name = "NOME_MATERIA", length = 50)
	private String nomeMateria;

	// bi-directional many-to-one association to CursoMateria
	@OneToMany(mappedBy = "materia")
	private List<CursoMateria> cursoMaterias;

	// bi-directional many-to-one association to ProfessorMateria
	@OneToMany(mappedBy = "materia")
	private List<ProfessorMateria> professorMaterias;

	public Materia() {
	}

	public Integer getIdMateria() {
		return this.idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public String getNomeMateria() {
		return this.nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	public List<CursoMateria> getCursoMaterias() {
		return this.cursoMaterias;
	}

	public void setCursoMaterias(List<CursoMateria> cursoMaterias) {
		this.cursoMaterias = cursoMaterias;
	}

	public CursoMateria addCursoMateria(CursoMateria cursoMateria) {
		getCursoMaterias().add(cursoMateria);
		cursoMateria.setMateria(this);

		return cursoMateria;
	}

	public CursoMateria removeCursoMateria(CursoMateria cursoMateria) {
		getCursoMaterias().remove(cursoMateria);
		cursoMateria.setMateria(null);

		return cursoMateria;
	}

	public List<ProfessorMateria> getProfessorMaterias() {
		return this.professorMaterias;
	}

	public void setProfessorMaterias(List<ProfessorMateria> professorMaterias) {
		this.professorMaterias = professorMaterias;
	}

	public ProfessorMateria addProfessorMateria(ProfessorMateria professorMateria) {
		getProfessorMaterias().add(professorMateria);
		professorMateria.setMateria(this);

		return professorMateria;
	}

	public ProfessorMateria removeProfessorMateria(ProfessorMateria professorMateria) {
		getProfessorMaterias().remove(professorMateria);
		professorMateria.setMateria(null);

		return professorMateria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMateria;
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
		Materia other = (Materia) obj;
		if (idMateria != other.idMateria)
			return false;
		return true;
	}

}