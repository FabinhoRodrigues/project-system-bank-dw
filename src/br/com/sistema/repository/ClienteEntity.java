package br.com.sistema.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sistema.model.Cliente;

public class ClienteEntity {

	private static final EntityManagerFactory entityManagerFactory;
	private static final String PERSISTENCE_UNIT_NAME = "projeto_banco";

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public Cliente busca(String numero) {

		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		Cliente cliente = entityManager.find(Cliente.class, numero);

		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();

		return cliente;
	}

	public void salva(Cliente cliente) {

		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();

	}

	public void deleta(Cliente cliente) {

		EntityManager entityManager = getEntityManager();
		

		if (cliente != null) {
			entityManager.getTransaction().begin();
			Cliente entity = entityManager.merge(cliente);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			
		}

		entityManager.clear();
		entityManager.close();

	}

}
