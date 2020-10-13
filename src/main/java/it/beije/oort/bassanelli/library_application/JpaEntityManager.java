package it.beije.oort.bassanelli.library_application;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class JpaEntityManager {
	
	private static EntityManagerFactory emfactory = null;

	private JpaEntityManager() {}
	
	@Bean(name = "entityManagerFactory")	
	public static synchronized EntityManagerFactory getInstance() {
		try {
			if (emfactory == null) {
				// emfactory = Persistence.createEntityManagerFactory("OortRubrica");
				emfactory = Persistence.createEntityManagerFactory("OortLibrary");
			}
			return emfactory;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
