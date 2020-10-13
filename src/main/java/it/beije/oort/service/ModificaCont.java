package it.beije.oort.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.entity.ContattoSpring;
import it.beije.oort.repository.ContattoRepository;

@Service
public class ModificaCont {
	

	@Autowired
	private ContattoRepository contRepository;
	
	public ContattoSpring load(Integer id) {
		
		Optional<ContattoSpring> contatto = contRepository.findById(id);
		
		return contatto.isPresent() ? contatto.get() : null;
		
	}
	
	@Transactional
	public void update(Integer id, ContattoSpring datiContatto) {
		
		if (datiContatto == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		
		if (!"".equals(datiContatto.getCognome()) || !"".equals(datiContatto.getNome()) ||
			!"".equals(datiContatto.getEmail()) || !"".equals(datiContatto.getTelefono())) {
			
			ContattoSpring contatto = load(id);
			
			if (contatto == null) {
				throw new IllegalArgumentException("non è presente un utente con id " + id);
			}
			
			BeanUtils.copyProperties(datiContatto, contatto, "id");
			
			contRepository.save(contatto);
			
		} else throw new IllegalArgumentException("dati utente non presenti");
		
	}

}
