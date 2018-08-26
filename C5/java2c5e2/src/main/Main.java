package main;

import db.Culoare;
import db.Semafor;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c5e2PU");
        EntityManager em = emf.createEntityManager();
        
        Semafor semafor = new Semafor();
        Map<Culoare, String > map = new HashMap<>();
        map.put(Culoare.ROSU, "ABC");
        map.put(Culoare.ROSU, "XYZ");
        semafor.setCulori(map);
        
        em.getTransaction().begin();
        em.persist(semafor);
        em.getTransaction().commit();
      
        em.close();
        emf.close();
    }
}