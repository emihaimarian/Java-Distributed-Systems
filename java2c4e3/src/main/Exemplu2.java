package main;

import db.Librarie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu2 {

    public static void main (String [] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4e3PU");
        EntityManager em = emf.createEntityManager();
    
        try{
            Librarie librarie = em.find(Librarie.class, 2);
            
            System.out.println(librarie.getAdresa());
            System.out.println(librarie.getCarti());
        
        } finally {
            em.close();
            emf.close();
        }
    }
}