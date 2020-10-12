package it.beije.oort.sala.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.sala.controller.beans.Utente;
import it.beije.oort.sala.controller.db.BibliotecaQuery;
import it.beije.oort.sala.controller.services.LoginService;

@Controller
public class BibliotecaController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String auth() {
		return "biblioteca/auth";
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String auth(HttpServletRequest request) {
		if(request.getParameter("logout")!=null && request.getParameter("logout").equals("true")) {
    		HttpSession session = request.getSession();
    		session.invalidate();
    	}
		return "biblioteca/auth";
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String auth(HttpServletRequest request, Model model) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String ret;
		Utente u = loginService.checkLogin(email, password);
		if(u!=null) {
			session.setAttribute("nome", u.getNome());
			session.setAttribute("admin", u.isAdmin());
			session.setAttribute("userid", u.getId_utente());
			session.setAttribute("auth", true);
			model.addAttribute("prestiti", BibliotecaQuery.getPrestiti(u.getId_utente()));
			ret = "biblioteca/user";
		} else {
			model.addAttribute("error", "ERRORE: Email o password errati");
			ret = "biblioteca/auth";
		}
		
		return ret;
	}
}