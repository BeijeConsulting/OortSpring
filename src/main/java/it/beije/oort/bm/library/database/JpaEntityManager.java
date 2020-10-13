package it.beije.oort.bm.library.database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class JpaEntityManager {

	private static EntityManagerFactory factory;
	private static  Logger log = Logger.getLogger(JpaEntityManager.class);
	
	private JpaEntityManager() {} // makes constructor unaccessible
	
	@Bean(name = "entityManagerFactory")
	public static EntityManagerFactory getInstance() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("OortSpring");
			log.debug("Entity manager factory created.");
		}
		return factory;
	}

}
