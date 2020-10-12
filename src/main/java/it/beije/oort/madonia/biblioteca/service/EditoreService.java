package it.beije.oort.madonia.biblioteca.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import it.beije.oort.madonia.biblioteca.ebeans.Editore;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;
import it.beije.oort.madonia.db.JpaEntityManagerFactory;

@Service
public class EditoreService {
	
	public Editore trova(Integer id) {
		if (id == null)
			throw new IllegalArgumentException();
		
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(DatabaseManagerBiblioteca.UNIT_NAME);
		Editore editore = null;
		try {
			editore = eManager.find(Editore.class, id);
		} finally {
			eManager.close();
		}
		
		return editore;
	}
	
	public Editore trova(String id) {
		if (id == null)
			throw new IllegalArgumentException();
		
		return this.trova(Integer.valueOf(id));
	}
	
	public void inserisci(Editore editore) {
		if (editore == null)
			throw new IllegalArgumentException();
		
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(DatabaseManagerBiblioteca.UNIT_NAME);
		try {
			eManager.getTransaction().begin();
			eManager.persist(editore);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public void modifica(Editore editore) {
		if (editore == null)
			throw new IllegalArgumentException();
		
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(DatabaseManagerBiblioteca.UNIT_NAME);
		try {
			Editore editoreModifica = eManager.find(Editore.class, editore.getId());
			editoreModifica.setDenominazione(editore.getDenominazione());
			editoreModifica.setDescrizione(editore.getDescrizione());
			
			eManager.getTransaction().begin();
			eManager.persist(editoreModifica);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public void cancella(Integer id) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(DatabaseManagerBiblioteca.UNIT_NAME);
		try {
			Editore editore = eManager.find(Editore.class, id);
			eManager.getTransaction().begin();
			eManager.remove(editore);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public void cancella(String id) {
		if (id == null)
			throw new IllegalArgumentException();
		
		this.trova(Integer.parseInt(id));
	}
	
}
