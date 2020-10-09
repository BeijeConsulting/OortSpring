package it.beije.oort.database;

import it.beije.oort.model.IBibliotecaModel;
import it.beije.oort.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class GenericDatabaseManager {
    private final static String PERSISTENCE_UNIT_NAME = "Biblioorteca";
    private final static EntityManager em = JPAEntityManager.getEntityManager(PERSISTENCE_UNIT_NAME);

    public void insert(IBibliotecaModel object){
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public IBibliotecaModel get(Class<? extends IBibliotecaModel> classe, Long id){
        return em.find(classe, id);
    }

    public boolean exist(Class<? extends IBibliotecaModel> classe, int id){
        return em.find(classe, id) != null;
    }

    public List<? extends IBibliotecaModel> getAll(Class<? extends IBibliotecaModel> classe) {
        return em.createQuery("Select o from " + classe.getSimpleName() + " as o", IBibliotecaModel.class)
                .getResultList();
    }

    public void delete(Class<? extends IBibliotecaModel> classe, Long id){
        IBibliotecaModel deleteMe = null;
        try{
            deleteMe = this.get(classe, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        em.getTransaction().begin();
        em.remove(deleteMe);
        em.getTransaction().commit();
    }

    public User getUtente(String cf){
        try {
            String jpql = "SELECT u FROM User as u WHERE u.codiceFiscale = :cf";
            Query query = em.createQuery(jpql).setParameter("cf", cf);
            return (User) query.getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public  User getUtenteFromMail(String email){
        try {
            String jpql = "SELECT u FROM User as u WHERE u.email = :email";
            Query query = em.createQuery(jpql).setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
//
//    public static List<Prestito> getPrestitiFromUser(String userCF){
//        try {
//            String jpql = "SELECT p FROM Prestito as p WHERE p.cfUtente = " +
//                    "'" + userCF + "'";
//            TypedQuery<Prestito> query = em.createQuery(jpql, Prestito.class);
//            return query.getResultList();
//        } catch (NoResultException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static void deleteUtente(String cf){
//        Utente deleteMe = getUtenteFromCF(cf);
//        em.getTransaction().begin();
//        em.remove(deleteMe);
//        em.getTransaction().commit();
//    }
//
//    public static List<? extends IBibliotecaModel> search(Class<?> classe, String column, String query){
//        String jpql = "SELECT o FROM " + classe.getSimpleName() + " as o WHERE " + column + " LIKE " +
//                "'%" + query + "%'";
//        Query q = em.createQuery(jpql);
//        return q.getResultList();
//    }
}
