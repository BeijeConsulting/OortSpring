package it.beije.oort.sala.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String req = request.getParameter("req");
		String resp="";
		if(session.getAttribute("admin")==null) {
			resp = "biblioteca/badrequest400";
		} else if(!((boolean)session.getAttribute("admin"))) {
			resp = "biblioteca/forbidden403";
		} else {
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
				}
			} else resp="biblioteca/badrequest400";
		}
		return resp;
	}
}