package main;

import db.Contact;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4e6PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Contact contact = new Contact();
            contact.setNumeContact("Contact 1");
            contact.setTelefoane(new ArrayList<>());
            contact.getTelefoane().add("123456");
            contact.getTelefoane().add("1231456");
           
            em.getTransaction().begin();
            em.persist(contact);
            em.getTransaction().commit();
       } finally{
            em.close();
            emf.close();
        }        
    }    
}