package main;

import db.Culoare;
import db.Tricou;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c5e3PU");
        EntityManager em = emf.createEntityManager();
        
        Tricou tricou = new Tricou();
        Map<String, Culoare> map = new HashMap<>();
        
        map.put("XL", Culoare.VERDE);
        map.put("XXL", Culoare.ALBASTRU);
        map.put("L", Culoare.GABLEN);
        tricou.setCulori(map);
        
        em.getTransaction().begin();
        em.persist(tricou);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
}