package it.beije.oort.database;

import it.beije.oort.model.IBibliotecaModel;
import it.beije.oort.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class GenericDatabaseManager {
    private final static String PERSISTENCE_UNIT_NAME = "Biblioorteca";
    private final static EntityManager em = JPAEntityManager.getEntityManager(PERSISTENCE_UNIT_NAME);

    public void insert(IBibliotecaModel object){
        System.out.println("Adding this obj: " + object.getClass());
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public IBibliotecaModel get(Class<? extends IBibliotecaModel> classe, Long id){
        try {
            return em.find(classe, id);
        } catch (NoResultException e){
            return null;
        }
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
            em.getTransaction().begin();
            em.remove(deleteMe);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Utente getUtente(String cf){
        try {
            String jpql = "SELECT u FROM Utente as u WHERE u.codiceFiscale = :cf";
            Query query = em.createQuery(jpql).setParameter("cf", cf);
            return (Utente) query.getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public Utente getUtenteFromMail(String email){
        try {
            String jpql = "SELECT u FROM Utente as u WHERE u.email = :email";
            Query query = em.createQuery(jpql).setParameter("email", email);
            return (Utente) query.getSingleResult();
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
