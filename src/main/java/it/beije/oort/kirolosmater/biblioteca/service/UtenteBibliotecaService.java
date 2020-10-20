package it.beije.oort.kirolosmater.biblioteca.service;

import static it.beije.oort.kirolosmater.biblioteca.MetodiPrestito.visualizzaPrestitiByIdUtente;
import static it.beije.oort.kirolosmater.biblioteca.MetodiUtente.checkEmail;
import static it.beije.oort.kirolosmater.biblioteca.MetodiUtente.checkPassword;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import it.beije.oort.kirolosmater.biblioteca.model.Prestito;
import it.beije.oort.kirolosmater.biblioteca.model.UtenteBiblioteca;
import it.beije.oort.kirolosmater.biblioteca.repository.UtenteBibliotecaRepository;

@Service
public class UtenteBibliotecaService {

//	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UtenteBibliotecaRepository utenteBibliotecaRepository;

	public String getNominativo(UtenteBiblioteca utente) {

		if (utente == null)
			throw new IllegalArgumentException();

		return utente.getCognome() + " " + utente.getNome();
	}

	public UtenteBiblioteca load(Integer id) {

		Optional<UtenteBiblioteca> utente = utenteBibliotecaRepository.findById(id);

		return utente.isPresent() ? utente.get() : null;

	}

	public List<UtenteBiblioteca> findByNome(String nome) {

		List<UtenteBiblioteca> utenti = utenteBibliotecaRepository.findByNome(nome);

		return utenti;

	}

	public UtenteBiblioteca findByEmail(String email) {
		Optional<UtenteBiblioteca> utente = utenteBibliotecaRepository.findByEmail(email);
		return utente.isPresent() ? utente.get() : null;
	}

	// @Transactional
	public void insert(UtenteBiblioteca utente) {

		if (utente == null) {
			throw new IllegalArgumentException("bean utente null");
		}

		if (!"".equals(utente.getCognome()) || !"".equals(utente.getNome()) || !"".equals(utente.getEmail())
				|| !"".equals(utente.getTelefono())) {

			utenteBibliotecaRepository.save(utente);

		} else
			throw new IllegalArgumentException("dati utente non presenti");

	}

	@Transactional
	public void update(Integer id, UtenteBiblioteca datiUtente) {

		if (datiUtente == null) {
			throw new IllegalArgumentException("bean utente null");
		}

		if (!"".equals(datiUtente.getCognome()) || !"".equals(datiUtente.getNome()) || !"".equals(datiUtente.getEmail())
				|| !"".equals(datiUtente.getTelefono())) {

			UtenteBiblioteca utente = load(id);

			if (utente == null) {
				throw new IllegalArgumentException("non è presente un utente con id " + id);
			}

			BeanUtils.copyProperties(datiUtente, utente, "id");

			utenteBibliotecaRepository.save(utente);

		} else
			throw new IllegalArgumentException("dati utente non presenti");

	}
	
	public UtenteBiblioteca checkLogin(String email, String password) {
		System.out.println("entra nel metodo");
		Optional<UtenteBiblioteca> o = utenteBibliotecaRepository.findByEmailAndPassword(email, password);
		System.out.println("utente" + o.get());
		return o.isPresent() ? o.get() : null;
	}
	
	
	public String checkUserWithQueryMethods(String email, String password, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati utente...");
		String stringaOutput = "biblioteca/areaPersonale";
//		System.out.println(email);
		UtenteBiblioteca utente = utenteBibliotecaRepository.findByEmail(email).get();
		
		boolean passwordCorretta = checkPassword(utente, password);
		if (passwordCorretta) {
			model.addAttribute("utente", utente);
			List<Prestito> prestitiUtente = visualizzaPrestitiByIdUtente(utente);
			model.addAttribute("prestitiUtente", prestitiUtente);
			boolean admin = utente.isAdmin();
			model.addAttribute("admin", admin);
			stringaOutput = "biblioteca/areaPersonale";
		} else {
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			stringaOutput = "biblioteca/bibliotecaLogin";
		}
		
		
		return stringaOutput;
	}
	
	public String checkUserWithSession (String email, String password, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati utente...");
		String stringaOutput = "biblioteca/areaPersonale";
		HttpSession session = request.getSession();
		System.out.println(email);
		UtenteBiblioteca utente = checkEmail(email);
		
		boolean passwordCorretta = checkPassword(utente, password);
		if (passwordCorretta) {
			session.setAttribute("userBean", utente);
			model.addAttribute("utente", utente);
			List<Prestito> prestitiUtente = visualizzaPrestitiByIdUtente(utente);
			session.setAttribute("prestitiUserBean", prestitiUtente);
			model.addAttribute("prestitiUtente", prestitiUtente);
			boolean admin = utente.isAdmin();
			session.setAttribute("userIsAdmin", admin);
			model.addAttribute("admin", admin);
			stringaOutput = "biblioteca/areaPersonale";
		} else {
			session.setAttribute("errore", "CREDENZIALI ERRATE");
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			stringaOutput = "biblioteca/bibliotecaLogin";
		}
		
		
		return stringaOutput;
	}
}
