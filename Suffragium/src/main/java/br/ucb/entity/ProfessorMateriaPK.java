package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the professor_materia database table.
 * 
 */
@Embeddable
public class ProfessorMateriaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MAT_ID_MATERIA", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer matIdMateria;

	@Column(name="PRO_ID_PROFESSOR", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer proIdProfessor;

	public ProfessorMateriaPK() {
	}
	public Integer getMatIdMateria() {
		return this.matIdMateria;
	}
	public void setMatIdMateria(Integer matIdMateria) {
		this.matIdMateria = matIdMateria;
	}
	public Integer getProIdProfessor() {
		return this.proIdProfessor;
	}
	public void setProIdProfessor(Integer proIdProfessor) {
		this.proIdProfessor = proIdProfessor;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProfessorMateriaPK)) {
			return false;
		}
		ProfessorMateriaPK castOther = (ProfessorMateriaPK)other;
		return 
			(this.matIdMateria == castOther.matIdMateria)
			&& (this.proIdProfessor == castOther.proIdProfessor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matIdMateria;
		hash = hash * prime + this.proIdProfessor;
		
		return hash;
	}
}