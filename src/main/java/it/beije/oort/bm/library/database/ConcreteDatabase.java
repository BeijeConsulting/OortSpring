package it.beije.oort.bm.library.database;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ConcreteDatabase implements Database {
	private static ConcreteDatabase istance;
	private EntityManagerFactory factory;
	
	
	private ConcreteDatabase() {
		factory = Persistence.createEntityManagerFactory("library");
	}
	
	@Override
	public boolean add(Object data) {
		EntityManager s = getEntityManager();
		try {
			s.getTransaction().begin();
			s.persist(data);
			s.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			s.close();
		}
		return true;
	}

	@Override
	public <T> boolean remove(Class<T> table, int id) {
		EntityManager s = getEntityManager();
		try {
			s.getTransaction().begin();
			T elem = s.find(table, id);
			s.remove(elem);
			s.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			s.close();
		}
		return true;
	}

	@Override
	public <T> boolean update(Class<T> beanType, int id, Object data) {
		EntityManager s = getEntityManager();
		try {
			s.getTransaction().begin();
			Object elem = s.find(beanType, id);
			Field[] fields = getProperties(beanType);
			Map<String, Method> getters = getGetters(beanType);
			Map<String, Method> setters = getSetters(beanType);
			for(Field f : fields) {
				Method getMethod = getters.get(f.getName());
				Method setMethod = setters.get(f.getName());
				if(getMethod != null && setMethod != null) {
					Object newVal = getMethod.invoke(data, new Object[0]);
					boolean isString = newVal instanceof String;
					if(newVal != null) {
						if(isString) {
							if(newVal.equals("")) continue;
						} else {
							setMethod.invoke(elem, newVal);
						}
					}
				}
			}
//			switch(t_name) {
//			case USER:
//				User newU = (User) data;
//				User oldU = (User) elem;
//				if(!(newU.getSurname() == null || newU.getSurname().equals(""))) oldU.setSurname(newU.getSurname());
//				if(!(newU.getName() == null || newU.getName().equals(""))) oldU.setName(newU.getName());
//				if(!(newU.getFc() == null || newU.getFc().equals(""))) oldU.setFc(newU.getFc());
//				if(!(newU.getPhone() == null || newU.getPhone().equals(""))) oldU.setPhone(newU.getPhone());
//				if(!(newU.getEmail() == null || newU.getEmail().equals(""))) oldU.setEmail(newU.getEmail());
//				if(!(newU.getAddress() == null || newU.getAddress().equals(""))) oldU.setAddress(newU.getAddress());
//				break;
//			case BOOK:
//				Book newB = (Book) data;
//				Book oldB = (Book) elem;
//				if(!(newB.getTitle() == null || newB.getTitle().equals(""))) oldB.setTitle(newB.getTitle());
//				if(!(newB.getDescription() == null || newB.getDescription().equals(""))) oldB.setDescription(newB.getDescription());
//				if(newB.getAuthor() != null) oldB.setAuthor(newB.getAuthor());
//				if(newB.getPublisher() != null) oldB.setPublisher(newB.getPublisher());
//				if(!(newB.getYear() == null || newB.getYear().equals(""))) oldB.setYear(newB.getYear());
//				break;
//			case AUTHOR:
//				Author newA = (Author) data;
//				Author oldA = (Author) elem;
//				if(!(newA.getSurname() == null || newA.getSurname().equals(""))) oldA.setSurname(newA.getSurname());
//				if(!(newA.getName() == null || newA.getName().equals(""))) oldA.setName(newA.getName());
//				if(!(newA.getDate_of_birth() == null || newA.getDate_of_birth().equals(""))) oldA.setDate_of_birth(Date.valueOf(newA.getDate_of_birth()));
//				if(!(newA.getDate_of_death() == null || newA.getDate_of_death().equals(""))) oldA.setDate_of_death(Date.valueOf(newA.getDate_of_death()));
//				if(!(newA.getBiography() == null || newA.getBiography().equals(""))) oldA.setBiography(newA.getBiography());
//				break;
//			case LOAN:
//				Loan newL = (Loan) data;
//				Loan oldL = (Loan) elem;
//				if(newL.getUser() != null) oldL.setUser(newL.getUser());
//				if(newL.getBook() != null) oldL.setBook(newL.getBook());
//				if(!(newL.getStart_date() == null || newL.getStart_date().equals(""))) oldL.setStart_date(Date.valueOf(newL.getStart_date()));
//				if(!(newL.getEnd_date() == null || newL.getEnd_date().equals(""))) oldL.setEnd_date(Date.valueOf(newL.getEnd_date()));
//				if(!(newL.getNotes() == null || newL.getNotes().equals(""))) oldL.setNotes(newL.getNotes());
//				break;
//			case PUBLISHER:
//				Publisher newP = (Publisher) data;
//				Publisher oldP = (Publisher) elem;
//				if(!(newP.getName() == null || newP.getName().equals(""))) oldP.setName(newP.getName());
//				if(!(newP.getDescription() == null || newP.getDescription().equals(""))) oldP.setDescription(newP.getDescription());
//				break;
//			default:
//				throw new IllegalArgumentException("");
//			}
			s.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			s.close();
		}
		return true;
	}

	@Override
	public <T> List<T> getAll(Class<T> beanType) {
		String query = "SELECT x FROM " + beanType.getSimpleName() + " AS x";
		List<T> ret;
		ret = inquiry(beanType, query);
		return ret;
	}

	@Override
	public <T> List<T> searchRecord(Class<T> beanType, T data){
		String type = data.getClass().getSimpleName();
		List<T> ret = null;
		StringBuilder query = new StringBuilder();
		query.append("SELECT x FROM ").append(type).append(" AS x WHERE ");
		boolean requireAnd = false;
		Field[] fields = getProperties(beanType);
		Map<String, Method> methods = getGetters(beanType);
		for(Field f : fields) {
			Method m = methods.get(f.getName());
			if(m != null) {
				Object value = null;
				try {
					value = m.invoke(data, new Object[0]);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace();}
				boolean isString = value instanceof String;
				if(requireAnd) query.append("AND ");
				query.append(f.getName()).append(" = ");
				if(isString) query.append("\'");
				query.append(value);
				if(isString)query.append("\' ");
				requireAnd = true;
			}
		}
//		switch(type) {
//		case USER:
//			User user = (User) data;
//			if(!(user.getSurname() == null || user.getSurname().equals(""))) {
//				query.append("surname = ").append("\'").append(user.getSurname()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(!(user.getName() == null || user.getName().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("name = ").append("\'").append(user.getName()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(!(user.getFc() == null || user.getFc().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("fc = ").append("\'").append(user.getFc()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(!(user.getAddress() == null || user.getAddress().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("address = ").append("\'").append(user.getAddress()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(!(user.getPhone() == null || user.getPhone().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("phone = ").append("\'").append(user.getPhone()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(!(user.getEmail() == null || user.getEmail().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("email = ").append("\'").append(user.getEmail()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(!(user.getPassword() == null || user.getPassword().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("password = ").append("\'").append(user.getPassword()).append("\'").append(" ");
//			}
//			break;
//		case BOOK:
//			Book book = (Book) data;
//			if(!(book.getTitle() == null || book.getTitle().equals(""))) {
//				query.append("title = ").append("\'").append(book.getTitle()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(book.getPublisher() != null) {
//				if(requireAnd) query.append("AND ");
//				query.append("publisher = ").append(book.getPublisher()).append(" ");
//				requireAnd = true;
//			}
//			if(book.getAuthor() != null) {
//				if(requireAnd) query.append("AND ");
//				query.append("author = ").append(book.getAuthor()).append(" ");
//				requireAnd = true;
//			}
//			if(!(book.getYear() == null || book.getYear().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("year = ").append("\'").append(book.getYear()).append("\'").append(" ");
//			}			
//			break;
//		case AUTHOR:
//			Author author = (Author) data;
//			if(!(author.getSurname() == null || author.getSurname().equals(""))) {
//				query.append("surname = ").append("\'").append(author.getSurname()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(!(author.getName() == null || author.getName().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("name = ").append("\'").append(author.getName()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(!(author.getDate_of_birth() == null || author.getDate_of_birth().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("date_of_birth = ").append("\'").append(author.getDate_of_birth()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(!(author.getDate_of_death() == null || author.getDate_of_death().equals(""))) {
//				if(requireAnd) query.append("AND ");
//				query.append("date_of_death = ").append("\'").append(author.getDate_of_death()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(author.getId() != 0) {
//				if(requireAnd) query.append("AND ");
//				query.append("id = ").append("\'").append(author.getId()).append("\'").append(" ");
//			}
//			break;
//		case LOAN:
//			Loan loan = (Loan) data;
//			if(loan.getBook() != null) {
//				query.append("book = ").append(loan.getBook()).append(" ");
//				requireAnd = true;
//			}
//			if(loan.getUser() != null) {
//				if(requireAnd) query.append("AND ");
//				query.append("user = ").append(loan.getUser()).append(" ");
//				requireAnd = true;
//			}
//			if(loan.getStart_date() != null) {
//				if(requireAnd) query.append("AND ");
//				query.append("start_date = ").append("\'").append(loan.getStart_date().toString()).append("\'").append(" ");
//				requireAnd = true;
//			}
//			if(loan.getEnd_date() != null) {
//				if(requireAnd) query.append("AND ");
//				query.append("end_date = ").append("\'").append(loan.getEnd_date()).append("\'").append(" ");
//			}	
//			break;
//		case PUBLISHER:
//			Publisher p = (Publisher) data;
//			if(!(p.getName() == null || p.getName().equals(""))) {
//				query.append("name = ").append("\'").append(p.getName()).append("\'").append(" ");
//			}
//			if(p.getId() != 0) {
//				if(requireAnd) query.append("AND ");
//				query.append("id = ").append("\'").append(p.getId()).append("\'").append(" ");
//			}
//			break;
//		default:
//			throw new IllegalArgumentException("Something went really wrong man.");
//		}
		ret = inquiry(beanType, query.toString());
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> inquiry(Class<T> resultType, String query) {
		List<T> ret;
		EntityManager s = getEntityManager();
		Query results = s.createQuery(query);
		ret = results.getResultList();
		s.close();
		return ret;
	}
	
	private EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static ConcreteDatabase getDatabase() {
		if(istance == null) istance = new ConcreteDatabase();
		return istance;
	}
	
	private static <T> Map<String, Method> getSetters(Class<T> targetClass) throws SecurityException {
		Map<String, Method> methods = new HashMap<>();
		Field[] fields = getProperties(targetClass);
		String methodName = null;
		for(int i = 0; i<fields.length; i++) {
			methodName = "set" + toCapitalLetter(fields[i].getName());
			Method method = null;
			try {
				targetClass.getMethod(methodName, new Class[] {fields[i].getType()});
			} catch (NoSuchMethodException e) {
			}
			methods.put(fields[i].getName(), method);
		}
		return methods;
	}
	
	private static <T> Map<String, Method> getGetters(Class<T> targetClass) throws  SecurityException {
		Map<String, Method> methods = new HashMap<>();
		Field[] fields = getProperties(targetClass);
		String methodName = null;
		for(int i = 0; i<fields.length; i++) {
			methodName = "set" + toCapitalLetter(fields[i].getName());
			Method method = null;
			try {
				targetClass.getMethod(methodName, new Class[0]);
			} catch (NoSuchMethodException e) {
			}
			methods.put(fields[i].getName(), method);
		}
		return methods;
	}
	
	private static <T> Field[] getProperties(Class<T> targetClass) {
		return targetClass.getDeclaredFields();
	}
	
	private static String toCapitalLetter(String s) {
		s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
		return s;
	}
}
