package it.beije.oort.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import it.beije.oort.entity.ContattoSpring;
import it.beije.oort.entity.SingletonJPASpring;

@Service
public class VisualizzaCont {
	public List<ContattoSpring> showall(){
	EntityManager entityManager = SingletonJPASpring.openEntity();
	String jpql = "SELECT c FROM ContattoSpring as c";
	Query query = entityManager.createQuery(jpql);
	List<ContattoSpring> contatti = query.getResultList();
	System.out.println(contatti);
	for (ContattoSpring contatto : contatti) { 
		contatto.getCognome();
		contatto.getNome();
		contatto.getTelefono();
		contatto.getEmail();
	}
	entityManager.close();
	return contatti;	
	}
}
