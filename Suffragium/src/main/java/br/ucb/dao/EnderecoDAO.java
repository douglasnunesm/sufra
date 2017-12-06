package br.ucb.dao;

import br.ucb.entity.Endereco;
import br.ucb.generics.GenericCRUD;

public class EnderecoDAO extends GenericCRUD<Endereco, Integer> {
	public EnderecoDAO() {
		super(Endereco.class);
	}

}
