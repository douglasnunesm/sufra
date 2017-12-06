package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the professor_materia database table.
 * 
 */
@Entity
@Table(name = "professor_materia")
@NamedQuery(name = "ProfessorMateria.findAll", query = "SELECT p FROM ProfessorMateria p")
public class ProfessorMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProfessorMateriaPK id;

	@Column(name = "ID_MATERIA")
	private Integer idMateria;

	@Column(name = "ID_PROFESSOR")
	private Integer idProfessor;

	// bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name = "MAT_ID_MATERIA", nullable = false, insertable = false, updatable = false)
	private Materia materia;

	// bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name = "PRO_ID_PROFESSOR", nullable = false, insertable = false, updatable = false)
	private Professor professor;

	public ProfessorMateria() {
	}

	public ProfessorMateriaPK getId() {
		return this.id;
	}

	public void setId(ProfessorMateriaPK id) {
		this.id = id;
	}

	public Integer getIdMateria() {
		return this.idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public Integer getIdProfessor() {
		return this.idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProfessorMateria other = (ProfessorMateria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}