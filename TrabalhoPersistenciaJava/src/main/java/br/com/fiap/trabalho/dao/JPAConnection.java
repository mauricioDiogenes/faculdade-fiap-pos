package br.com.fiap.trabalho.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnection {
	private static EntityManager manager;

	public EntityManager getEntityManager() {
		if (manager == null) {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("persistenceUnit");
			manager = factory.createEntityManager();
		}
		return manager;
	}
}
