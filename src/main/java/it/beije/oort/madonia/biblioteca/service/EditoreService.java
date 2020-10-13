package it.beije.oort.madonia.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.madonia.biblioteca.ebeans.Editore;
import it.beije.oort.madonia.biblioteca.repository.EditoreRepository;
import it.beije.oort.madonia.biblioteca.utilities.EbeanUtils;
import it.beije.oort.madonia.biblioteca.utilities.GeneralUtils;

@Service
public class EditoreService {
	
	@Autowired
	private EditoreRepository editoreRepository;
	
	public Editore trova(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("La id è un valore null");
		}
		
		Optional<Editore> editore = editoreRepository.findById(id);
		return editore.isPresent() ? editore.get() : null;
	}
	
	public Editore trova(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		return this.trova(Integer.valueOf(id));
	}
	
	@Transactional
	public void inserisci(Editore editore) {
		if (editore == null)
			throw new IllegalArgumentException();
		
		if (EbeanUtils.editoreIsEmpty(editore)) {
			throw new IllegalArgumentException("L'editore deve avere almeno un campo con un valore non vuoto");
		}
		
		editoreRepository.saveAndFlush(editore);
	}
	
	@Transactional
	public void modifica(Integer id, Editore datiEditore) {
		if (datiEditore == null) {
			throw new IllegalArgumentException("L'editore è un valore null");
		}
		
		if (EbeanUtils.editoreIsEmpty(datiEditore)) {
			throw new IllegalArgumentException("L'editore deve avere almeno un campo con un valore non vuoto");
		}
		
		Editore editore = this.trova(id);
		
		if (editore == null) {
			throw new IllegalArgumentException("Non è presente alcun editore con la id " + id);
		}
		
		BeanUtils.copyProperties(datiEditore, editore, "id");
		editoreRepository.saveAndFlush(editore);
	}
	
	public void modifica(String id, Editore datiEditore) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		this.modifica(Integer.valueOf(id), datiEditore);
	}
	
	@Transactional
	public void cancella(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("La id è un valore null");
		}
		
		editoreRepository.deleteById(id);
	}
	
	public void cancella(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		this.cancella(Integer.parseInt(id));
	}
	
}
