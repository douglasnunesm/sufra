package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_USUARIO", unique=true, nullable=false)
	private Integer idUsuario;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASCIMENTO")
	private Date dataNascimento;

	@Column(length=255)
	private String matricula;

	@Column(name="NOME_USUARIO", length=100)
	private String nomeUsuario;

	@Column(length=1)
	private String sexo;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="usuario")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to Professor
	@OneToMany(mappedBy="usuario")
	private List<Professor> professors;

	//bi-directional many-to-one association to Login
	@ManyToOne
	@JoinColumn(name="ID_LOGIN")
	private Login login;

	//bi-directional many-to-one association to Telefone
	@ManyToOne
	@JoinColumn(name="ID_TELEFONE")
	private Telefone telefone;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setUsuario(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setUsuario(null);

		return aluno;
	}

	public List<Professor> getProfessors() {
		return this.professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Professor addProfessor(Professor professor) {
		getProfessors().add(professor);
		professor.setUsuario(this);

		return professor;
	}

	public Professor removeProfessor(Professor professor) {
		getProfessors().remove(professor);
		professor.setUsuario(null);

		return professor;
	}

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Telefone getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
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
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

}