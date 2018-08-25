package main;

import db.CardAccess;
import db.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4e2PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Person person = new Person();
            person.setName("Gigel");
            
            CardAccess cardAccess = new CardAccess();
            cardAccess.setSerie("12345");
            
            person.setCardAccess(cardAccess);
            cardAccess.setPerson(person);
            
            em.getTransaction().begin();
            em.persist(person);
            em.persist(cardAccess);
            em.getTransaction().commit();
            
        } finally{
            em.close();
            emf.close();
        }
    }    
}
