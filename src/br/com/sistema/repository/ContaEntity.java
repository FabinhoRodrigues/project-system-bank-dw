package br.com.sistema.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sistema.model.Conta;
import br.com.sistema.model.Extrato;

public class ContaEntity {private static final EntityManagerFactory entityManagerFactory;
private static final String PERSISTENCE_UNIT_NAME = "projeto_banco"; 

static { 
	 entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	     }

public static EntityManager getEntityManager() {
	         return entityManagerFactory.createEntityManager();
	     }

public Conta busca(String numero) {

	EntityManager entityManager = getEntityManager();
	entityManager.getTransaction().begin();
	Conta conta = entityManager.find(Conta.class, numero);
	
	entityManager.getTransaction().commit();
	entityManager.clear();
	entityManager.close();

	return conta;
}
public Conta buscaCpf(String numero) {

	EntityManager entityManager = getEntityManager();
	entityManager.getTransaction().begin();
	Query query = entityManager.createNativeQuery("select * from conta where cpf_cliente = ? ;",Conta.class);
	query.setParameter(1, numero);
	return (Conta)query.getSingleResult();
}

public void salva(Conta conta) {

	EntityManager entityManager = getEntityManager();
	entityManager.getTransaction().begin();
	entityManager.persist(conta);
	entityManager.getTransaction().commit();
	entityManager.clear();
	entityManager.close();

}
public void deleta(Conta conta) {

	EntityManager entityManager = getEntityManager();
	
	if(conta != null){
		entityManager.getTransaction().begin();
		Conta entity = entityManager.merge(conta);
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		
	}
	
	entityManager.clear();
	entityManager.close();

}
public void atualiza(Conta conta) {

	EntityManager entityManager = getEntityManager();
	
	
		entityManager.getTransaction().begin();
		
		entityManager.merge(conta);
		entityManager.getTransaction().commit();
		
	
	
	entityManager.clear();
	entityManager.close();

}
	

}
