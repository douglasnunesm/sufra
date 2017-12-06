package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@Table(name="ENDERECO")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_ENDERECO", unique=true, nullable=false)
	private Integer idEndereco;

	@Column(length=50)
	private String bairro;

	@Column(length=8)
	private String cep;

	@Column(length=30)
	private String cidade;

	@Column(length=255)
	private String complemento;

	@Column(length=255)
	private String logradouro;

	private Integer numero;

	@Column(length=2)
	private String uf;

	//bi-directional many-to-one association to Instituicao
	@OneToMany(mappedBy="endereco")
	private List<Instituicao> instituicaos;

	public Endereco() {
	}

	public Integer getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Instituicao> getInstituicaos() {
		return this.instituicaos;
	}

	public void setInstituicaos(List<Instituicao> instituicaos) {
		this.instituicaos = instituicaos;
	}

	public Instituicao addInstituicao(Instituicao instituicao) {
		getInstituicaos().add(instituicao);
		instituicao.setEndereco(this);

		return instituicao;
	}

	public Instituicao removeInstituicao(Instituicao instituicao) {
		getInstituicaos().remove(instituicao);
		instituicao.setEndereco(null);

		return instituicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEndereco;
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
		Endereco other = (Endereco) obj;
		if (idEndereco != other.idEndereco)
			return false;
		return true;
	}
	
	

}