package main;

import db.Persoana;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c5e1PU");
        EntityManager em = emf.createEntityManager();
        
        Persoana persoana = new Persoana();
        
        Map<String, String> prieteni = new HashMap<>();
        prieteni.put("12345", "Popescu");
        prieteni.put("12346", "Ionescu");
        persoana.setPrieteni(prieteni);
        
        try{
            em.getTransaction().begin();
            em.persist(persoana);
            em.getTransaction().commit(); 
        } finally {
            em.close();
            emf.close();
        }
    }
} 