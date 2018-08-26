package main;

import db.Articol;
import db.Carte;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e3PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            
            Articol articol = new Articol();
            articol.setRevista("Revista 1");
            articol.setTitlu("Titlu 2");
            
            em.getTransaction().begin();
            em.persist(articol); 
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }    
}