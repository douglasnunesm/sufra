package br.ucb.dao;

import br.ucb.entity.Pergunta;
import br.ucb.generics.GenericCRUD;

public class PerguntaDAO extends GenericCRUD<Pergunta, Integer> {
	public PerguntaDAO() {
		super(Pergunta.class);
	}

}
