package br.ucb.generics;

import br.ucb.dao.TipoAvaliacaoDAO;
import br.ucb.entity.TipoAvaliacao;

public class Main {
	public static void main(String[] args) {
		TipoAvaliacao avaliacao = new TipoAvaliacao();

		avaliacao.setDescricao("aa11212aaafsfssfaaaaa");
		TipoAvaliacaoDAO avaliacaoDAO = new TipoAvaliacaoDAO();
		avaliacaoDAO.salvar(avaliacao);
	}

}
