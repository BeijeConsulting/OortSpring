package it.beije.oort.controller;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.Utente;
import it.beije.oort.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/login")
    public String showLogin(HttpServletRequest request){
        if (request.getSession().getAttribute("utente") != null){
            return "biblio_index";
        }
        return "auth";
    }

    @GetMapping(value = "/loginSkip")
    public String skipLogin(HttpServletRequest request){
        request.getSession().setAttribute("utente", DatabaseController.getUtente(1L));
        return "biblio_index";
    }

    @PostMapping(value = "/login")
    public String logUser(HttpSession session,
                          Model model,
                          @RequestParam(name = "cf-mail") String cfMail,
                          @RequestParam String password){
        if (session.getAttribute("utente") != null) return "index";

        Utente utente = loginService.getUser(cfMail, password, model);
        if (utente != null){
            session.setAttribute("logged", true);
            session.setAttribute("utente", utente);
            return "biblio_index";
        } else {
            return "auth";
        }
    }
}
