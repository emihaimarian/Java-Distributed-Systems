package main;

import db.JavaCurs;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e4PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            JavaCurs jc = new JavaCurs();
            jc.setInstructor("Mihai");
            jc.setDurata(100);
            
            em.getTransaction().begin();
            em.persist(jc);
            em.getTransaction().commit();
       } finally {
            em.getTransaction().begin();
            em.getTransaction().commit();
        }
    }    
}