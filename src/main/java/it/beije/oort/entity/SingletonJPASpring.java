package it.beije.oort.entity;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonJPASpring {

		private SingletonJPASpring() {}
		
		private static EntityManagerFactory factory;

		
		public static EntityManager openEntity() {
			if(factory == null) {
				factory = Persistence.createEntityManagerFactory("OortRubrica");
					System.out.println("EntityFactory is create? " + factory.isOpen());
			}
		return	 factory.createEntityManager();
		}
		
	}


