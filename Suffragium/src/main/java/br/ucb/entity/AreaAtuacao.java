package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area_atuacao database table.
 * 
 */
@Entity
@Table(name="area_atuacao")
@NamedQuery(name="AreaAtuacao.findAll", query="SELECT a FROM AreaAtuacao a")
public class AreaAtuacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_AREA_ATUACAO", unique=true, nullable=false)
	private Integer idAreaAtuacao;

	@Column(name="NOME_AREA_ATUACAO", length=255)
	private String nomeAreaAtuacao;

	//bi-directional many-to-one association to Professor
	@OneToMany(mappedBy="areaAtuacao")
	private List<Professor> professors;

	public AreaAtuacao() {
	}

	public Integer getIdAreaAtuacao() {
		return this.idAreaAtuacao;
	}

	public void setIdAreaAtuacao(Integer idAreaAtuacao) {
		this.idAreaAtuacao = idAreaAtuacao;
	}

	public String getNomeAreaAtuacao() {
		return this.nomeAreaAtuacao;
	}

	public void setNomeAreaAtuacao(String nomeAreaAtuacao) {
		this.nomeAreaAtuacao = nomeAreaAtuacao;
	}

	public List<Professor> getProfessors() {
		return this.professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Professor addProfessor(Professor professor) {
		getProfessors().add(professor);
		professor.setAreaAtuacao(this);

		return professor;
	}

	public Professor removeProfessor(Professor professor) {
		getProfessors().remove(professor);
		professor.setAreaAtuacao(null);

		return professor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAreaAtuacao;
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
		AreaAtuacao other = (AreaAtuacao) obj;
		if (idAreaAtuacao != other.idAreaAtuacao)
			return false;
		return true;
	}
	
	

}