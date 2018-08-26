package main;

import db.Concert;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c5e7PU");
        EntityManager em = emf.createEntityManager();
        
        Concert concert = new Concert();
        Map<Date, String> dates = new HashMap<>();
        
        dates.put(new Date(System.currentTimeMillis()), "Cluj");
        concert.setLocatii(dates);
        
        em.getTransaction().begin();
        em.persist(dates);
        em.getTransaction().commit();
        
        Cache cache = emf.getCache();
        // Daca am obiectul cu id-ul 100 in cache, acesta va fi elimintat
        cache.evict(Concert.class, 100);
        System.out.println(cache.contains(Concert.class, 100));
        
        em.close();
        emf.close();
    }    
}