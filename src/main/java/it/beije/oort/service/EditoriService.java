package it.beije.oort.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.repository.EditoriRepository;
import it.beije.oort.sb.biblioteca.Editori;

@Service
public class EditoriService {

	@Autowired
	private EditoriRepository editoriRepository;
	
	public List<Editori> loadEditori(){
		return editoriRepository.findAll();
	}
	
	public Editori loadById(Integer id) {
		Optional<Editori> editore = editoriRepository.findById(id);
		return editore.isPresent() ? editore.get() : null;
	}
	
	
	public boolean insert(Editori editore) {
		try{
			editoriRepository.saveAndFlush(editore);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
//	@Transactional
	public Editori update(Integer id, Editori datiEditore) {
		
		if (datiEditore == null) {
			throw new IllegalArgumentException("bean editore null");
		}
		
		if (!"".equals(datiEditore.getDenominazione())) {
			
			Editori editore = loadById(id);
			
			if (editore == null) {
				throw new IllegalArgumentException("non è presente un editore con id " + id);
			}
			
			BeanUtils.copyProperties(datiEditore, editore, "id");
			
			editoriRepository.save(editore);
			
			return editore;
			
		} else throw new IllegalArgumentException("dati editore non presenti");
		
	}
	public String deleteById(Integer id) {
		Editori editore = loadById(id);
		if(editore!= null) {
			editoriRepository.delete(editore);
			return "editore cancellato correttamente";
		} else throw new IllegalArgumentException("NESSUN EDITORE CON ID " + id);
				
	}
}
