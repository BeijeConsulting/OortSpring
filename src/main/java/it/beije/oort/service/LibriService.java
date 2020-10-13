package it.beije.oort.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.beije.oort.repository.LibriRepository;
import it.beije.oort.repository.PrestitiRepository;
import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.sb.biblioteca.Prestiti;



@Service
public class LibriService {
		
	@Autowired
	private LibriRepository libriRepository;
	
	@Autowired
	private PrestitiRepository prestitiRepository;
	
	public List<Libri> catalogo(String autore, String editore){
		if("".equals(autore)&&"".equals(editore)) return libriRepository.findAll();
		else if("".equals(autore)) return libriRepository.findByEditore(Integer.parseInt(editore));
		else if("".equals(editore)) return libriRepository.findByAutore(Integer.parseInt(autore));
		else return libriRepository.findByAutoreAndEditore(Integer.parseInt(autore), Integer.parseInt(editore));
	}
	
	public Libri loadById(Integer id){
		Optional<Libri> libro = libriRepository.findById(id);
		return libro.isPresent() ? libro.get() : null;
	}
	
	public List<String> availability(List<Libri> libri){
		List<String> listAvailability = new ArrayList<String>();
		String availability = "Non Disponibile";
		for(Libri l : libri) {
			for(Prestiti p : prestitiRepository.findByLibro(l.getId())) {
				if(p.getDataFine()!=null && p.getDataFine().isBefore(java.time.LocalDate.now()))
					availability = "Disponibile";
				else availability = "Non disponibile";
				}
			listAvailability.add(availability);
		}
		return listAvailability;
	}

}
