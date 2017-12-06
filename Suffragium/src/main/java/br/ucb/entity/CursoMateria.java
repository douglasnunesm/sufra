package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the curso_materia database table.
 * 
 */
@Entity
@Table(name = "curso_materia")
@NamedQuery(name = "CursoMateria.findAll", query = "SELECT c FROM CursoMateria c")
public class CursoMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoMateriaPK id;

	@Column(name = "ID_CURSO")
	private Integer idCurso;

	@Column(name = "ID_MATERIA")
	private Integer idMateria;

	// bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name = "MAT_ID_MATERIA", nullable = false, insertable = false, updatable = false)
	private Materia materia;

	// bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name = "CUR_ID_CURSO", nullable = false, insertable = false, updatable = false)
	private Curso curso;

	public CursoMateria() {
	}

	public CursoMateriaPK getId() {
		return this.id;
	}

	public void setId(CursoMateriaPK id) {
		this.id = id;
	}

	public Integer getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getIdMateria() {
		return this.idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
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
		CursoMateria other = (CursoMateria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}