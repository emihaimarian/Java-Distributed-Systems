package main;

import db.Carte;
import db.Librarie;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c5e5PU");
        EntityManager em = emf.createEntityManager();
        
        Carte carte = new Carte();
        carte.setTitlu("Titlu 1");
        
        Carte carte2 = new Carte();
        carte2.setTitlu("Titlu 2");
        
        Librarie librarie = new Librarie();
        
        Map<String, Carte> carti = new HashMap<>();
        carti.put("12345", carte);
        carti.put("123456", carte2);
        
        librarie.setCarti(carti);
        
        em.getTransaction().begin();
        em.persist(librarie);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }    
}