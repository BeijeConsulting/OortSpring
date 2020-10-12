package it.beije.oort.service;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import it.beije.oort.entity.ContattoSpring;
import it.beije.oort.entity.SingletonJPASpring;

@Service
public class InserimentoCont {
	public void inserimento(ContattoSpring contatto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
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
	}
}
