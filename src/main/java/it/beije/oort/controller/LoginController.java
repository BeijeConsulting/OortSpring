package it.beije.oort.controller;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.Utente;
import it.beije.oort.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginRegisterService loginRegisterService;

    @GetMapping(value = "/login")
    public String showLogin(HttpServletRequest request){
        if (request.getSession().getAttribute("logged") != null){
            return "redirect:/biblio";
        }
        return "login/auth";
    }

    @GetMapping(value = "/loginSkip")
    public String skipLogin(HttpServletRequest request){
        request.getSession().setAttribute("utente", DatabaseController.getUtente(1L));
        return "redirect:/biblio";
    }

    @PostMapping(value = "/login")
    public String logUser(HttpSession session,
                          Model model,
                          @RequestParam(name = "cf-mail") String cfMail,
                          @RequestParam String password){
        if (session.getAttribute("logged") != null) return "redirect:/biblio";

        Utente utente = loginRegisterService.getUser(cfMail, password);
        if (utente != null){
            session.setAttribute("logged", true);
            session.setAttribute("utente", utente);
            return "redirect:/biblio";
        } else {
            model.addAttribute("error", "Login invalido.");
            return "login/auth";
        }
    }
}
