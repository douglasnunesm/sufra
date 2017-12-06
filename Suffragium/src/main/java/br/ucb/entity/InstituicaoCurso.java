package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the instituicao_curso database table.
 * 
 */
@Entity
@Table(name="instituicao_curso")
@NamedQuery(name="InstituicaoCurso.findAll", query="SELECT i FROM InstituicaoCurso i")
public class InstituicaoCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InstituicaoCursoPK id;

	@Column(name="ID_CURSO")
	private Integer idCurso;

	@Column(name="ID_INSTITUICAO")
	private Integer idInstituicao;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="CUR_ID_CURSO", nullable=false, insertable=false, updatable=false)
	private Curso curso;

	//bi-directional many-to-one association to Instituicao
	@ManyToOne
	@JoinColumn(name="INS_ID_INSTITUICAO", nullable=false, insertable=false, updatable=false)
	private Instituicao instituicao;

	public InstituicaoCurso() {
	}

	public InstituicaoCursoPK getId() {
		return this.id;
	}

	public void setId(InstituicaoCursoPK id) {
		this.id = id;
	}

	public Integer getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getIdInstituicao() {
		return this.idInstituicao;
	}

	public void setIdInstituicao(Integer idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Instituicao getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
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
		InstituicaoCurso other = (InstituicaoCurso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}