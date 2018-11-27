package br.com.sistema.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	private static final EntityManagerFactory entityManagerFactory;
	private static final String PERSISTENCE_UNIT_NAME = "projeto_banco";

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	public static void main(String[]args){
		
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		String data = s.format(c.getTime());
		
		System.out.println(data);
		
		
	}
}
