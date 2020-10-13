package it.beije.oort.kirolosmater.biblioteca;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JpaEntityManagerBiblioteca {
	private static EntityManagerFactory emfactoryBiblioteca = null;

	private JpaEntityManagerBiblioteca() {}
	
	@Bean(name = "entityManagerFactoryBiblioteca")
	public static synchronized EntityManagerFactory getInstanceBiblioteca() {
		try {
			if(emfactoryBiblioteca == null) {
				emfactoryBiblioteca = Persistence.createEntityManagerFactory("OortBiblioteca");
			}
			return emfactoryBiblioteca;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
}
