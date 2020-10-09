package it.beije.oort.sala.controller.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	private static EntityManagerFactory factory;
	public static EntityManager createEntityManager() {
		if(factory==null) {
			factory = Persistence.createEntityManagerFactory("Biblioteca");
		}
		return factory.createEntityManager();
	}
}
