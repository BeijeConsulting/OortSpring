package it.beije.oort.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.entity.ContattoSpring;
import it.beije.oort.entity.SingletonJPASpring;



@Controller
public class RubricaController {

	@RequestMapping(value = "/conf", method = RequestMethod.GET)
	public String conferma() {
		System.out.println("ESEGUITO..");
		
		return "conferma";
	}
	
	@RequestMapping(value = "/h", method = RequestMethod.GET)
	public String home() {
		System.out.println("home...");
		
		return "home";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showTo() {
		System.out.println("form visualizza...");
		
		return "showcontatto";
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delTo() {
		System.out.println("form cancellazione...");
		
		return "delcontatto";
	}
	
	@RequestMapping(value = "/ins", method = RequestMethod.GET)
	public String insTo() {
		System.out.println("form inserimento...");
		
		return "inscontatto";
	}
	
//	@RequestMapping(value = "/ins", method = RequestMethod.POST)
//	public String inserimento(@RequestParam  HttpServletRequest request, HttpServletResponse response) throws IOException {
//	StringBuilder builder = new StringBuilder("<h3>Contatto cancellato correttamente!</h3> <br>");
//	String id_value = request.getParameter("id");
//		
//	EntityManager entityManager = SingletonJPASpring.openEntity();
//	EntityTransaction entityTransaction = entityManager.getTransaction();
//	entityTransaction.begin();
//	String jpql = ("SELECT c FROM Contatto as c WHERE id = " + id_value) ;
//	Query query = entityManager.createQuery(jpql);
//	
//
//	entityManager.remove(query.getResultList().get(0));
//	entityManager.getTransaction().commit();
//	entityManager.close();	
//	System.out.println("Cancellato!");
//	
//	response.getWriter().append(builder);
//	
//	StringBuilder b = new StringBuilder("<br><!doctype html>\r\n" + 
//			"<html>\r\n" + 
//			"	<head>\r\n" + 
//			"	<title></title>\r\n" + 
//			"	</head>\r\n" + 
//			"	<body>\r\n" + 
//			"		<form action=\"menu.html\" method=\"POST\">\r\n" + 
//			"			<button type=\"submit\"> MENU' PRINCIPALE</button>\r\n" + 
//			"		</form>		\r\n" + 
//			"	</body>\r\n" + 
//			"</html>");
//	response.getWriter().append(b);
//	
//	}

	
	@RequestMapping(value = "/ins", method = RequestMethod.POST)
	public String inserimento(ContattoSpring contatto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		EntityManager entityManager = SingletonJPASpring.openEntity();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(contatto);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Contatto inserito correttamente!");
		
		StringBuilder b = new StringBuilder("<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"	<title></title>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<form action=\"h\" method=\"POST\">\r\n" + 
				"		<button type=\"submit\"> MENU' PRINCIPALE</button>\r\n" + 
				"		</form>		\r\n" + 
				"	</body>\r\n" + 
				"</html>");
		response.getWriter().append(b);
		 return "conferma";
		}
		
	
	
}
