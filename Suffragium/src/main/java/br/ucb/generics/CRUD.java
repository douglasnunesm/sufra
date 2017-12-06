package br.ucb.generics;


import java.io.Serializable;
import java.util.List;

public interface CRUD<T, I extends Serializable> {
	T salvar(T entity);

	T atualizar(T entity);

	void remover(I id);

	List<T> getList();

	T encontrar(I id);
}
