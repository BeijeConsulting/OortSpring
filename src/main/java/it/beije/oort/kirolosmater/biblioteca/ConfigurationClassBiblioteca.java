//package it.beije.oort.kirolosmater.biblioteca;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(value = { "it.beije.oort.kirolosmater.biblioteca.repository" })
//public class ConfigurationClassBiblioteca {
//
//	@Primary
//	@Bean(name = "transactionManagerBiblioteca")
//	public PlatformTransactionManager dbTransactionManagerBiblioteca() {
//		JpaTransactionManager transactionManagerBiblioteca = new JpaTransactionManager();
//		transactionManagerBiblioteca.setEntityManagerFactory(JpaEntityManagerBiblioteca.getInstanceBiblioteca());
//		return transactionManagerBiblioteca;
//	}
//}
