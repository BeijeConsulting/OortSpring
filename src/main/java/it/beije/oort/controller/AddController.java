package it.beije.oort.controller;

import it.beije.oort.model.*;
import it.beije.oort.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AddController {
    @Autowired
    private AddService addService;

    //////////////////////////////////////////////////////////////
    // CONTROLLER PER PREPARARE E OTTENERE LA PAGINA DI AGGIUNTA
    //////////////////////////////////////////////////////////////
    @GetMapping(value = "/add")
    public String servePage(HttpSession session, HttpServletRequest request){
        addService.preparePage(session, request);
        return "add";
    }

    //////////////////////////////////////////////////////////////
    // CONTROLLER SPECIFICI PER TIPO DI OGGETTO DA AGGIUNGERE
    // DEVONO ESSERE SPECIFICI PER POTER CREARE L'OGGETTO CORRETTO
    //////////////////////////////////////////////////////////////
    @PostMapping(value = "/add", params = "type=Libro")
    public String addLibro(Libro libro,
                           HttpSession session,
                           Model model){
        addService.add(libro, session, model);
        return "add";
    }

    @PostMapping(value = "/add", params = "type=Autore")
    public String addAutore(Autore autore,
                           HttpSession session,
                           Model model){
        addService.add(autore, session, model);
        return "add";
    }

    @PostMapping(value = "/add", params = "type=Prestito")
    public String addPrestito(Prestito prestito,
                           HttpSession session,
                           Model model){
        addService.add(prestito, session, model);
        return "add";
    }

    @PostMapping(value = "/add", params = "type=Utente")
    public String addUtente(Utente utente,
                           HttpSession session,
                           Model model){
        addService.add(utente, session, model);
        return "add";
    }

    @PostMapping(value = "/add", params = "type=Editore")
    public String addEditore(Editore editore,
                           HttpSession session,
                           Model model){
        addService.add(editore, session, model);
        return "add";
    }
}