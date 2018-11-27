package br.com.sistema.repository;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sistema.model.Cliente;

public class AutenticaEntity {
	private static final EntityManagerFactory entityManagerFactory;
	private static final String PERSISTENCE_UNIT_NAME = "projeto_banco"; 
	
	 static { 
		 entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		     }

	 public static EntityManager getEntityManager() {
		         return entityManagerFactory.createEntityManager();
		     }
	
	
	public Cliente autentica(Cliente cliente) throws SQLException{
		
		   EntityManager entityManager = getEntityManager();
	        
	         entityManager.getTransaction().begin();
		
	         Query query = entityManager.createNativeQuery("select cpf from cliente where email = ? and senha = ? ;");		         
	         query.setParameter(1, cliente.getEmail());
	         query.setParameter(2, cliente.getSenha());
	         String resultado;
	         
	        	 resultado = (String)query.getSingleResult();
	        	 System.out.println(resultado);
	        	 Cliente clienteRetornado = entityManager.find(Cliente.class, resultado);
	         
	         
	         
			return clienteRetornado;
	        	
	}
	
	
}
