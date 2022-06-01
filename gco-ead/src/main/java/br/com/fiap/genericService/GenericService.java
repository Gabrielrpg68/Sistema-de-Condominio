package br.com.fiap.genericService;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public abstract class GenericService<T,K> implements GenericDao<T, K> {

	private EntityManager em;
	
	private Class<T> clazz; //armazena o .class da entidade
	
	@SuppressWarnings("all")
	public GenericService(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	public void remover(K id) throws IdNotFoundException {
		T entidade = obterPorId(id);
		em.remove(entidade);
	}
	

	public T obterPorId(K id) throws IdNotFoundException {
		T entidade = em.find(clazz, id);
		if (entidade == null)
			throw new IdNotFoundException();
		return entidade;
	}
	
	public List<T> listar() {
		return em.createQuery("from " + clazz.getName(), clazz)
				.getResultList();
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}
