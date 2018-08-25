package main;

import db.Angajat;
import db.LocParcare;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplu1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4e1PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            LocParcare locParcare = new LocParcare();
            locParcare.setNumar(5);
            
            Angajat angajat = new Angajat();
            angajat.setNume("Goe");
            angajat.setLocParcare(locParcare);
            
            em.getTransaction().begin();
            
            em.persist(locParcare);
            em.persist(angajat);
            
            em.getTransaction().commit();
            
        } finally{
            em.close();
            emf.close();
        }
    }  
}   