package it.beije.oort.controller;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    // Il get stampa la pagina base, il post elabora la richiesta di login e rimanda alle pagine successive
    @GetMapping(value = "/login")
    public String showLogin(HttpServletRequest request){
        // per debug
        if (true){
            System.out.println("creo utente admin");
            request.getSession().setAttribute("utente", DatabaseController.getUtente(1L));
            System.out.println("utente admin settato");
        }
        if (request.getSession().getAttribute("utente") != null){
            System.out.println("utente già loggato");
            return "biblio_list";
        }
        return "auth";
    }

    @PostMapping(value = "/login")
    public String logUser(HttpSession session,
                          Model model,
                          @RequestParam(name = "cf-mail") String cfMail,
                          @RequestParam String password){
        if (session.getAttribute("utente") != null) return "index";
        Utente utente = null;

        // prendi utente dalla mail o dal cf
        if (DatabaseController.getUtente(cfMail) != null){
            utente = DatabaseController.getUtente(cfMail);
        } else if (DatabaseController.getUtenteFromMail(cfMail) != null){
            utente = DatabaseController.getUtenteFromMail(cfMail);
        } else {
            model.addAttribute("error", "Utente non corretto");
            return "auth";
        }

        // verifica la password
        if (!utente.getPassword().equals(password)){
            model.addAttribute("error", "Password non corretta");
            return "auth";
        }
        session.setAttribute("logged", true);
        session.setAttribute("utente", utente);

        return "biblio_list";
    }
}
