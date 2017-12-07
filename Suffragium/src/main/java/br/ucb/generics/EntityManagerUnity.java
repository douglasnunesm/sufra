package br.ucb.generics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUnity {

	private static final String PERSISTENT_UNIT = "sufra";

	private static EntityManager entityManager;

	private EntityManagerUnity() {
	}

	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENT_UNIT);
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
}
