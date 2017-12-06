package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the curso_materia database table.
 * 
 */
@Embeddable
public class CursoMateriaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MAT_ID_MATERIA", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer matIdMateria;

	@Column(name="CUR_ID_CURSO", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer curIdCurso;

	public CursoMateriaPK() {
	}
	public Integer getMatIdMateria() {
		return this.matIdMateria;
	}
	public void setMatIdMateria(Integer matIdMateria) {
		this.matIdMateria = matIdMateria;
	}
	public Integer getCurIdCurso() {
		return this.curIdCurso;
	}
	public void setCurIdCurso(Integer curIdCurso) {
		this.curIdCurso = curIdCurso;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CursoMateriaPK)) {
			return false;
		}
		CursoMateriaPK castOther = (CursoMateriaPK)other;
		return 
			(this.matIdMateria == castOther.matIdMateria)
			&& (this.curIdCurso == castOther.curIdCurso);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matIdMateria;
		hash = hash * prime + this.curIdCurso;
		
		return hash;
	}
}