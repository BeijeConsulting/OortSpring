package it.beije.oort.lauria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.lauria.biblioteca.Autore;
import it.beije.oort.lauria.biblioteca.Editore;
import it.beije.oort.lauria.biblioteca.Libro;
import it.beije.oort.lauria.repository.AutoreRepository;
import it.beije.oort.lauria.repository.EditoreRepository;
import it.beije.oort.lauria.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private AutoreRepository autoreRepository;
	
	@Autowired
	private EditoreRepository editoreRepository;
	
	
	
	public List<Libro> findAll(){
		List<Libro> libri = libroRepository.findAll();
		
//		List<Libro> libri = libroRepository.findByIdGreaterThan(0);
		
		return libri;
		
	}
	
	
	public Libro load(Integer id) {
		
		Optional<Libro> libro = libroRepository.findById(id);
		
		return libro.isPresent() ? libro.get() : null;
		
	}

	
	public Libro update(Integer id, Libro datiLibro) {
		
		Libro libro = load(id);
		
		if (datiLibro == null) {
			throw new IllegalArgumentException("it's not possible update a null-book");
		}
		
		if(datiLibro.getTitolo() == null || "".equals(datiLibro.getTitolo())) {
			datiLibro.setTitolo(libro.getTitolo());
		}
		if(datiLibro.getId_autore() == null || "".equals(datiLibro.getId_autore())) {
			datiLibro.setId_autore(libro.getId_autore());
		}
		if(datiLibro.getId_editore() == null || "".equals(datiLibro.getId_editore())) {
			datiLibro.setId_editore(libro.getId_editore());
		}else {
			Optional<Autore> autore = autoreRepository.findById(datiLibro.getId_autore());
			Optional<Editore> editore = editoreRepository.findById(datiLibro.getId_editore());
		
			if(!autore.isPresent() || !editore.isPresent()) {
				throw new IllegalArgumentException("the id author or the id editor, is not defined");
			}
		}
		if(datiLibro.getDescrizione() == null || "".equals(datiLibro.getDescrizione())) {
			datiLibro.setDescrizione(libro.getDescrizione());
		}
		if(datiLibro.getAnno() == null || "".equals(datiLibro.getAnno())) {
			datiLibro.setAnno(libro.getAnno());
		}
		
			BeanUtils.copyProperties(datiLibro, libro, "id");
			libroRepository.saveAndFlush(libro);
			return libro;

		
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
	
	public void insert(Libro libro) {
	
		if (libro == null) {
			throw new IllegalArgumentException("it's not possible insert a null-book");
		}
		
		Optional<Autore> autore = autoreRepository.findById(libro.getId_autore());
		Optional<Editore> editore = editoreRepository.findById(libro.getId_editore());
		
		if(libro.getTitolo() == null || "".equals(libro.getTitolo())) {
			throw new IllegalArgumentException("there is no title: can't insert a book without a title");
		}else {
			if(!autore.isPresent() || !editore.isPresent()) {
				throw new IllegalArgumentException("the id author or the id editor, is not defined");
			}else {
				libroRepository.saveAndFlush(libro);
			}
		}
	}
	
	public void delete(Integer id) {
		
		Libro libro = load(id);
		
		if (libro == null) {
			throw new IllegalArgumentException("there's no book with id = " + id);
		}
		
		libroRepository.delete(libro);
				
	}

	
}
