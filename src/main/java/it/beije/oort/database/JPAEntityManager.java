package it.beije.oort.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class JPAEntityManager {
    private JPAEntityManager(){}

    private static final Map<String, EntityManager> managerMap = new HashMap<>();

    public static EntityManager getEntityManager(String database){
        if (managerMap.get(database) == null){
            System.out.println("Creo nuovo EntityManager");
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(database);
            System.out.println("Factory creata");
            EntityManager em = entityManagerFactory.createEntityManager();
            managerMap.put(database, em);
        }
        System.out.println("Servo l'EntityManager");
        return managerMap.get(database);
    }
}