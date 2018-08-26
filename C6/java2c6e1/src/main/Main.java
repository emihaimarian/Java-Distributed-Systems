package main;

import db.Bere;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e1PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Bere bere1 = new Bere();
            bere1.setNume("Tuborg");
            bere1.setPret(4);
            bere1.setProcentAlcool(5);
            
            em.getTransaction().begin();
            em.persist(bere1);
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    
    }    
}