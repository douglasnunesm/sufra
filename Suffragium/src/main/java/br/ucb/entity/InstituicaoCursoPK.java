package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the instituicao_curso database table.
 * 
 */
@Embeddable
public class InstituicaoCursoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CUR_ID_CURSO", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer curIdCurso;

	@Column(name="INS_ID_INSTITUICAO", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer insIdInstituicao;

	public InstituicaoCursoPK() {
	}
	public Integer getCurIdCurso() {
		return this.curIdCurso;
	}
	public void setCurIdCurso(Integer curIdCurso) {
		this.curIdCurso = curIdCurso;
	}
	public Integer getInsIdInstituicao() {
		return this.insIdInstituicao;
	}
	public void setInsIdInstituicao(Integer insIdInstituicao) {
		this.insIdInstituicao = insIdInstituicao;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InstituicaoCursoPK)) {
			return false;
		}
		InstituicaoCursoPK castOther = (InstituicaoCursoPK)other;
		return 
			(this.curIdCurso == castOther.curIdCurso)
			&& (this.insIdInstituicao == castOther.insIdInstituicao);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.curIdCurso;
		hash = hash * prime + this.insIdInstituicao;
		
		return hash;
	}
}