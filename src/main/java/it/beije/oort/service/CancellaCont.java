package it.beije.oort.service;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.entity.SingletonJPASpring;

@Service
public class CancellaCont {
	public void cancella(@RequestParam Integer id,  HttpServletRequest request, HttpServletResponse response) throws IOException {

	EntityManager entityManager = SingletonJPASpring.openEntity();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
	String jpql = ("SELECT c FROM ContattoSpring as c WHERE id = " + id) ;
	Query query = entityManager.createQuery(jpql);
	entityManager.remove(query.getResultList().get(0));
	entityManager.getTransaction().commit();
	entityManager.close();	
	System.out.println("Cancellato!");
		
	StringBuilder b = new StringBuilder("<br><!doctype html>\r\n" + 
			"<html>\r\n" + 
			"	<head>\r\n" + 
			"	<title></title>\r\n" + 
			"	</head>\r\n" + 
			"	<body>\r\n" + 
			"		<form action=\"h\" method=\"POST\">\r\n" + 
			"			<button type=\"submit\"> MENU' PRINCIPALE</button>\r\n" + 
			"		</form>		\r\n" + 
			"	</body>\r\n" + 
			"</html>");
	response.getWriter().append(b);
	}
}
