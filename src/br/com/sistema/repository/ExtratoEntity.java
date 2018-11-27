package br.com.sistema.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sistema.model.Extrato;

public class ExtratoEntity {
	
	private static final EntityManagerFactory entityManagerFactory;
	private static final String PERSISTENCE_UNIT_NAME = "projeto_banco";

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public List<Extrato> busca(String conta) {

		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createNativeQuery("select * from extrato where contaOrigem = ? or contaDestino= ?",Extrato.class);
		query.setParameter(1, conta);
        query.setParameter(2, conta);
		
        @SuppressWarnings("unchecked")
		List<Extrato> lista = (List<Extrato>)query.getResultList();

		return lista;
	}

	public void salva(Extrato extrato) {

		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(extrato);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();

	}

}
