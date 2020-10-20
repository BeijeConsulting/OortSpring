package it.beije.oort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserDetailsController {
    @GetMapping(value = "/account")
    public String getUserDetails(Model model,
                                 HttpSession session){
        model.addAttribute("user", session.getAttribute("utente"));
        return "login/accountDetails";
    }
}
