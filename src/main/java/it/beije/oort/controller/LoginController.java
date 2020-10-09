package it.beije.oort.controller;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    // Il get stampa la pagina base, il post elabora la richiesta di login e rimanda alle pagine successive
    @GetMapping(value = "/login")
    public String showLogin(HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null) return "index";
        return "auth";
    }

    @PostMapping(value = "/login")
    public String logUser(HttpServletRequest request, HttpServletResponse response){
        if (request.getSession().getAttribute("user") != null) return "index";
        User user = null;

        // prendi utente dalla mail o dal cf
        if (DatabaseController.getUtente("cf-mail") != null){
            user = DatabaseController.getUtente("cf-mail");
        } else if (DatabaseController.getUtenteFromMail("cf-mail") != null){
            user = DatabaseController.getUtenteFromMail("cf-mail");
        } else {
            return "auth";
        }

        // verifica la password
        if (!user.getPassword().equals(request.getParameter("password"))) return "auth";

        request.getSession().setAttribute("logged", true);
        request.getSession().setAttribute("user", user);

        return "biblio";
    }
}
