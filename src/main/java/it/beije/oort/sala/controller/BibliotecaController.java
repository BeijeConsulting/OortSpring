package it.beije.oort.sala.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.sala.controller.beans.Utente;
import it.beije.oort.sala.controller.db.BibliotecaQuery;
import it.beije.oort.sala.controller.db.JPAToolset;

@Controller
public class BibliotecaController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
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
		Utente u = checkLogin(email, password);
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
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(HttpServletRequest request) {
		String req = request.getParameter("req");
		String resp="";
		System.out.println(req);
		if(req!=null) {
			switch(req) {
			case "homeadmin":
				resp = "biblioteca/admin";
				break;
			case "prestiti":
				resp = "biblioteca/sub-admin/prestiti";
				break;
			case "libri":
				resp = "biblioteca/sub-admin/libri";
				break;
			case "editori":
				resp = "biblioteca/sub-admin/editori";
				break;
			case "autori":
				resp = "biblioteca/sub-admin/autori";
				break;
			case "utenti":
				resp = "biblioteca/sub-admin/utenti";
				break;		
			}}
			return resp;
	}
	
	private Utente checkLogin(String email, String password) {
		List<Object> temp = JPAToolset.selectJPA(email, password);
		if(temp.size()==1) {
			return (Utente)temp.get(0);
		}
		return null;
	}
}
