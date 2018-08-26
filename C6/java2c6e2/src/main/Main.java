package main;

import db.Avocat;
import db.Programator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e2PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Programator programator = new Programator();
            programator.setNume("Mihai");
            programator.setLimbajDeProgramare("Java");
            
            Avocat avocat = new Avocat();
            avocat.setNume("Gigel");
            avocat.setSpecializare("Specializare");
        
            em.getTransaction().begin();
            em.persist(programator);
            em.persist(avocat);
            em.getTransaction().commit();
        } finally{
            em.close();
            emf.close();
        }
    } 
}