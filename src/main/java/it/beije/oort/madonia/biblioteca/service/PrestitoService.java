package it.beije.oort.madonia.biblioteca.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.repository.PrestitoRepository;
import it.beije.oort.madonia.biblioteca.utilities.EbeanUtils;
import it.beije.oort.madonia.biblioteca.utilities.GeneralUtils;

@Service
public class PrestitoService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PrestitoRepository prestitoRepository;
	
	public Prestito crea(String idLibro, String idUtente, String dataInizio, String dataFine, String note) {
		if (GeneralUtils.stringIsNullOrEmpty(idLibro) || GeneralUtils.stringIsNullOrEmpty(idUtente)) {
			log.debug("idLibro o idUtente sono vuoti");
			throw new IllegalArgumentException("Libro ID e Utente ID non possono essere vuoti");
		}

		try {
			return new Prestito(
					Integer.valueOf(idLibro),
					Integer.valueOf(idUtente),
					GeneralUtils.stringToSqlDate(dataInizio),
					GeneralUtils.stringToSqlDate(dataFine),
					note);
		} catch (NumberFormatException e) {
			log.debug("idLibro o idUtente non sono numeri validi");
			StringBuilder s = new StringBuilder()
					.append("Libro ID o Utente ID non sono validi, devono essere numeri interi. Libro ID: \"")
					.append(idLibro)
					.append("\" - Utente ID: \"")
					.append(idUtente)
					.append("\"");
			throw new IllegalArgumentException(s.toString());
		}
	}

	// Database
	public Prestito trova(Integer id) {
		log.debug("Ricerca prestito nel database con id " + id);
		if (id == null) {
			throw new IllegalArgumentException("La id è un valore null");
		}

		Optional<Prestito> prestito = prestitoRepository.findById(id);
		return prestito.isPresent() ? prestito.get() : null;
	}
	
	public Prestito trova(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		return this.trova(Integer.valueOf(id));
	}
	
	@Transactional
	public Prestito inserisci(Prestito prestito) {
		log.debug("Inserimento prestito in corso");
		if (prestito == null) {
			log.error("Prestito non inserito nel database: null");
			throw new IllegalArgumentException("Il prestito è un valore null");
		}
		
		if (EbeanUtils.prestitoIsEmpty(prestito)) {
			log.debug("Prestito non inserito nel database: vuoto");
			throw new IllegalArgumentException("Il prestito deve avere almeno un campo con un valore non vuoto");
		}
		
		return prestitoRepository.saveAndFlush(prestito);
	}
	
	@Transactional
	public Prestito modifica(Integer id, Prestito datiPrestito) {
		log.debug("Modifica prestito in corso");
		if (datiPrestito == null) {
			log.error("Prestito non inserito nel database: null");
			throw new IllegalArgumentException("Il prestito è un valore null");
		}
		
		if (EbeanUtils.prestitoIsEmpty(datiPrestito)) {
			throw new IllegalArgumentException("Il prestito deve avere almeno un campo con un valore non vuoto");
		}
		
		Prestito prestito = this.trova(id);
		
		if (prestito == null) {
			log.debug("Non è presente alcun prestito con la id " + id);
			throw new IllegalArgumentException("Non è presente alcun prestito con la id " + id);
		}

		BeanUtils.copyProperties(datiPrestito, prestito, "id");
		return prestitoRepository.saveAndFlush(prestito);
	}
	
	public Prestito modifica(String id, Prestito datiPrestito) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		return this.modifica(Integer.valueOf(id), datiPrestito);
	}
	
	@Transactional
	public void cancella(Integer id) {
		log.debug("Avvio operazione, cancellazione prestito con id " + id);
		if (id == null) {
			throw new IllegalArgumentException("La id è un valore null");
		}
		
		prestitoRepository.deleteById(id);
		log.info("Cancellato prestito con id " + id);
	}
	
	public void cancella(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		this.cancella(Integer.parseInt(id));
	}
	
	public List<Prestito> trovaPerIdUtente(Integer idUtente) {
		List<Prestito> lista = prestitoRepository.findByIdUtente(idUtente);
		log.debug("Lista prestiti trovati per ricerca su ID Utente: " + lista);
		return lista;
	}
	
}
