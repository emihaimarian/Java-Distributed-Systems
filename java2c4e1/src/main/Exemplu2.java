package main;

import db.Angajat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu2 {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4e1PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            
            Angajat angajat = em.find(Angajat.class, 1);
            System.out.println(angajat);
        } finally{
            em.close();
            emf.close();
        }
    }
}
