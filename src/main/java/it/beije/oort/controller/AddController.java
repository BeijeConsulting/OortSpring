package it.beije.oort.controller;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AddController {

    @PostMapping(value = "/add", params = "type=Libro")
    public String addLibro(Libro libro,
                           HttpSession session,
                           Model model){
        try{
            DatabaseController.insertLibro(libro);
            model.addAttribute("added", true);
        } catch (Exception e){
            model.addAttribute("added", false);
        }

        session.removeAttribute("addType");

        return "add";
    }

    @PostMapping(value = "/add", params = "type=Autore")
    public String addAutore(Autore autore,
                           HttpSession session,
                           Model model){
        System.out.println("Chiamato metodo addAutore");
        System.out.println(autore.toString());
        try{
            DatabaseController.insertAutore(autore);
            model.addAttribute("added", true);
        } catch (Exception e){
            model.addAttribute("added", false);
        }

        session.removeAttribute("addType");

        return "add";
    }

    @PostMapping(value = "/add", params = "type=Prestito")
    public String addPrestito(Prestito prestito,
                           HttpSession session,
                           Model model){

        if (session.getAttribute("utente") == null) return "auth";

        try{
            DatabaseController.insertPrestito(prestito);
            model.addAttribute("added", true);
        } catch (Exception e){
            model.addAttribute("added", false);
        }

        session.removeAttribute("addType");

        return "add";
    }

    @PostMapping(value = "/add", params = "type=Utente")
    public String addUtente(Utente utente,
                           HttpSession session,
                           Model model){

        if (session.getAttribute("utente") == null) return "auth";

        try{
            DatabaseController.insertUtente(utente);
            model.addAttribute("added", true);
        } catch (Exception e){
            model.addAttribute("added", false);
        }

        session.removeAttribute("addType");

        return "add";
    }

    @PostMapping(value = "/add", params = "type=Editore")
    public String addEditore(Editore editore,
                           HttpSession session,
                           Model model){
        System.out.println("Chiamato metodo addEditore");
        try{
            DatabaseController.insertEditore(editore);
            model.addAttribute("added", true);
        } catch (Exception e){
            model.addAttribute("added", false);
        }

        session.removeAttribute("addType");

        return "add";
    }

    @GetMapping(value = "/add")
    public String servePage(HttpServletRequest request, Model model){
        if (request.getSession().getAttribute("utente") == null) return "auth";

        request.getSession().removeAttribute("add");
        String type = request.getParameter("add");

        if (type != null && !type.equalsIgnoreCase("")) {
            request.getSession().setAttribute("add", type);

            // Ottengo tutte le liste.
            model.addAttribute("autori", DatabaseController.getAllAutori());
            model.addAttribute("editori", DatabaseController.getAllEditori());
            model.addAttribute("utenti", DatabaseController.getAllUtenti());
            model.addAttribute("libri", DatabaseController.getAllLibri());
        }
        return "add";
    }
}