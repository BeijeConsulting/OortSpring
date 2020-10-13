package it.beije.oort.kirolosmater.biblioteca;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class JpaEntityManagerBiblioteca {
	private static EntityManagerFactory emfactoryBiblioteca = null;

	private JpaEntityManagerBiblioteca() {}
	
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
