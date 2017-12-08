package br.ucb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ucb.dao.AlunoDAO;
import br.ucb.dao.AvaliacaoDAO;
import br.ucb.dao.CriterioAvaliacaoDAO;
import br.ucb.dao.PerguntaDAO;
import br.ucb.entity.Avaliacao;
import br.ucb.entity.CriterioAvaliacao;
import br.ucb.entity.Pergunta;

@RequestScoped
@ManagedBean(name = "avaliacaoBean", eager = true)
public class AvaliacaoBean {

	private AlunoDAO alunoDAO = new AlunoDAO();
	private AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
	private CriterioAvaliacaoDAO criterioAvaliacaoDAO = new CriterioAvaliacaoDAO();
	private PerguntaDAO perguntaDAO = new PerguntaDAO();

	private Avaliacao avaliacao = new Avaliacao();
	private List<CriterioAvaliacao> criterios = new ArrayList<>();

	private List<Pergunta> perguntas = new ArrayList<>();

	@PostConstruct
	public void load() {
		perguntas = perguntaDAO.getList();
	}

	public AlunoDAO getAlunoDAO() {
		return alunoDAO;
	}

	public void setAlunoDAO(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public AvaliacaoDAO getAvaliacaoDAO() {
		return avaliacaoDAO;
	}

	public void setAvaliacaoDAO(AvaliacaoDAO avaliacaoDAO) {
		this.avaliacaoDAO = avaliacaoDAO;
	}

	public CriterioAvaliacaoDAO getCriterioAvaliacaoDAO() {
		return criterioAvaliacaoDAO;
	}

	public void setCriterioAvaliacaoDAO(CriterioAvaliacaoDAO criterioAvaliacaoDAO) {
		this.criterioAvaliacaoDAO = criterioAvaliacaoDAO;
	}

	public PerguntaDAO getPerguntaDAO() {
		return perguntaDAO;
	}

	public void setPerguntaDAO(PerguntaDAO perguntaDAO) {
		this.perguntaDAO = perguntaDAO;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<CriterioAvaliacao> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<CriterioAvaliacao> criterios) {
		this.criterios = criterios;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

}
