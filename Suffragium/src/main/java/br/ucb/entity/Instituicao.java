package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instituicao database table.
 * 
 */
@Entity
@Table(name="INSTITUICAO")
@NamedQuery(name="Instituicao.findAll", query="SELECT i FROM Instituicao i")
public class Instituicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_INSTITUICAO", unique=true, nullable=false)
	private Integer idInstituicao;

	@Column(length=14)
	private String cnpj;

	@Column(length=255)
	private String nome;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="instituicao")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to Avaliacao
	@OneToMany(mappedBy="instituicao")
	private List<Avaliacao> avaliacaos;

	//bi-directional many-to-one association to Login
	@ManyToOne
	@JoinColumn(name="ID_LOGIN")
	private Login login;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name="ID_ENDERECO")
	private Endereco endereco;

	//bi-directional many-to-one association to Telefone
	@ManyToOne
	@JoinColumn(name="ID_TELEFONE")
	private Telefone telefone;

	//bi-directional many-to-one association to InstituicaoCurso
	@OneToMany(mappedBy="instituicao")
	private List<InstituicaoCurso> instituicaoCursos;

	public Instituicao() {
	}

	public Integer getIdInstituicao() {
		return this.idInstituicao;
	}

	public void setIdInstituicao(Integer idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setInstituicao(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setInstituicao(null);

		return aluno;
	}

	public List<Avaliacao> getAvaliacaos() {
		return this.avaliacaos;
	}

	public void setAvaliacaos(List<Avaliacao> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}

	public Avaliacao addAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().add(avaliacao);
		avaliacao.setInstituicao(this);

		return avaliacao;
	}

	public Avaliacao removeAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().remove(avaliacao);
		avaliacao.setInstituicao(null);

		return avaliacao;
	}

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<InstituicaoCurso> getInstituicaoCursos() {
		return this.instituicaoCursos;
	}

	public void setInstituicaoCursos(List<InstituicaoCurso> instituicaoCursos) {
		this.instituicaoCursos = instituicaoCursos;
	}

	public InstituicaoCurso addInstituicaoCurso(InstituicaoCurso instituicaoCurso) {
		getInstituicaoCursos().add(instituicaoCurso);
		instituicaoCurso.setInstituicao(this);

		return instituicaoCurso;
	}

	public InstituicaoCurso removeInstituicaoCurso(InstituicaoCurso instituicaoCurso) {
		getInstituicaoCursos().remove(instituicaoCurso);
		instituicaoCurso.setInstituicao(null);

		return instituicaoCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idInstituicao;
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
		Instituicao other = (Instituicao) obj;
		if (idInstituicao != other.idInstituicao)
			return false;
		return true;
	}
	
	

}