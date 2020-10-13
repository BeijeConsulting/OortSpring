package it.beije.oort.bm.library.database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManager {

	private static EntityManagerFactory factory;
	
	private JpaEntityManager() {} // makes constructor unaccessible
	
	public static EntityManagerFactory getInstance() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("OortSpring");
		}
		return factory;
	}

}
