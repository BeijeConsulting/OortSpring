package it.beije.oort.lauria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.lauria.biblioteca.Autore;
import it.beije.oort.lauria.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository;
	
	public List<Autore> findAll(){
		
		List<Autore> autori = autoreRepository.findAll();
		//List<Autore> autori = autoreRepository.findByIdGreaterThan(0);
		
		return autori;	
	}
	
	public Autore load(Integer id) {
		
		Optional<Autore> autore = autoreRepository.findById(id);
		
		return autore.isPresent() ? autore.get() : null;	
	}
	
	public void insert(Autore autore) {
		
		if (autore == null) {
			throw new IllegalArgumentException("it's not possible insert a null-author");
		}
				
		if(autore.getNome() == null || "".equals(autore.getNome())) {
			throw new IllegalArgumentException("there is no name: can't insert an author without his name");
		}else {
			if(autore.getCognome() == null || "".equals(autore.getCognome())) { // deve avere per forza un cognome??
				throw new IllegalArgumentException("there is no surname: can't insert an author without his surname");
			}else {
				Optional<Autore> omonimo = autoreRepository.findByNomeAndCognome();
				if(omonimo.isPresent()) {
					throw new IllegalArgumentException("there is already an author with name"+ autore.getNome()+" and surname"+ autore.getCognome());
				}else {
					autoreRepository.saveAndFlush(autore);
				}
				
			}
		}
	}
	
	public Autore update(Integer id, Autore datiAutore) {
		
		Autore autore = load(id);
		
		if (datiAutore == null) {
			throw new IllegalArgumentException("it's not possible update a null-author");
		}
		
		if(datiAutore.getNome() == null || "".equals(datiAutore.getNome())) {
			datiAutore.setNome(autore.getNome());
		}
		if(datiAutore.getCognome() == null || "".equals(datiAutore.getCognome())) {
			datiAutore.setCognome(autore.getCognome());
		}
		if(datiAutore.getData_nascita() == null || "".equals(datiAutore.getData_nascita())) {
			datiAutore.setData_nascita(autore.getData_nascita());
		}
		if(datiAutore.getData_morte() == null || "".equals(datiAutore.getData_morte())) {
			datiAutore.setData_morte(autore.getData_morte());
		}
		if(datiAutore.getBiografia() == null || "".equals(datiAutore.getBiografia())) {
			datiAutore.setBiografia(autore.getBiografia());
		}
		
			BeanUtils.copyProperties(datiAutore, autore, "id");
			autoreRepository.saveAndFlush(autore);
			return autore;

		
//		Optional<Autore> autore = autoreRepository.findById(datiLibro.getId_autore());
//		Optional<Editore> editore = editoreRepository.findById(datiLibro.getId_editore());
//		
//		if(datiLibro.getTitolo() == null || "".equals(datiLibro.getTitolo())) {
//			throw new IllegalArgumentException("there is no title: can't update a book without a title");
//		}else {
//			if(!autore.isPresent() || !editore.isPresent()) {
//				throw new IllegalArgumentException("the id author or the id editor, is not defined");
//			}else {
//				Libro libro = load(id);
//				BeanUtils.copyProperties(datiLibro, libro, "id");
//				libroRepository.saveAndFlush(libro);
//				return libro;
//			}
//		}
				
	}

}
