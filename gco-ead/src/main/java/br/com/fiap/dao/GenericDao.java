package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public interface GenericDao<T, K> {
	
	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K id) throws IdNotFoundException;
	
	T obterPorId(K id) throws IdNotFoundException;
	
	List<T> listar();
	
	void commit() throws CommitException;
}
