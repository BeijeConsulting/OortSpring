package it.beije.oort.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.oort.entity.ContattoSpring;
import it.beije.oort.repository.ContattoRepository;


@Service
public class InserimentoCont {
	
	@Autowired
	private ContattoRepository contRepository;

	public String getNominativo(ContattoSpring contatto) {
	
		if (contatto == null)
			throw new IllegalArgumentException();
		
		return contatto.getCognome() + " " + contatto.getNome();
	}
	
	public ContattoSpring load(Integer id) {
		
		Optional<ContattoSpring> contatto = contRepository.findById(id);
		
		return contatto.isPresent() ? contatto.get() : null;
		
	}
	
	public List<ContattoSpring> findByNome(String nome) {
		
		List<ContattoSpring> contatto = contRepository.findByNome(nome);
		
		return contatto;
		
	}
	
	//@Transactional
		public void insert(ContattoSpring contatto) {
			
			if (contatto == null) {
				throw new IllegalArgumentException("bean utente null");
			}
			
			if (!"".equals(contatto.getCognome()) || !"".equals(contatto.getNome()) ||
				!"".equals(contatto.getEmail()) || !"".equals(contatto.getTelefono())) {
				
				contRepository.save(contatto);
								
			} else throw new IllegalArgumentException("dati utente non presenti");
			
			
		}
	
	
	
}
//	public void inserimento(ContattoSpring contatto, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		
//		EntityManager entityManager = SingletonJPASpring.openEntity();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(contatto);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//		System.out.println("Contatto inserito correttamente!");
//		
//		StringBuilder b = new StringBuilder("<!doctype html>\r\n" + 
//				"<html>\r\n" + 
//				"	<head>\r\n" + 
//				"	<title></title>\r\n" + 
//				"	</head>\r\n" + 
//				"	<body>\r\n" + 
//				"		<form action=\"h\" method=\"POST\">\r\n" + 
//				"		<button type=\"submit\"> MENU' PRINCIPALE</button>\r\n" + 
//				"		</form>		\r\n" + 
//				"	</body>\r\n" + 
//				"</html>");
//		response.getWriter().append(b);
//	}
//}
