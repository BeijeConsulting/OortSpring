package it.beije.oort.madonia.db;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JpaEntityManagerFactory {
	
	private JpaEntityManagerFactory() {}
	
	private static Map<String, EntityManagerFactory> factoryMap;
	
	public static EntityManager createEntityManager(String persistenceUnitName) {
		return JpaEntityManagerFactory.getInstance().createEntityManager();
	}
	
	
	@Bean(name = "entityManagerFactory")
	public static synchronized EntityManagerFactory getInstance() {
		if (factoryMap == null) {
			factoryMap = new HashMap<String, EntityManagerFactory>();
		}
		
		if (!factoryMap.containsKey(DatabaseManagerBiblioteca.OORT_BIBLIOTECA)) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(DatabaseManagerBiblioteca.OORT_BIBLIOTECA);
			factoryMap.put(DatabaseManagerBiblioteca.OORT_BIBLIOTECA, factory);
		}
		
		return factoryMap.get(DatabaseManagerBiblioteca.OORT_BIBLIOTECA);
	}
}
