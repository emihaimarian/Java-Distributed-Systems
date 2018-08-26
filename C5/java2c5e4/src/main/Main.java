package main;

import db.Adresa;
import db.Locatie;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c5e4PU");
        EntityManager em = emf.createEntityManager();
        
        Locatie locatie = new Locatie();
        Map<String, Adresa> adrese = new HashMap<>();
        
        Adresa adresa = new Adresa();
        adresa.setOras("Bucurest");
        adresa.setStrada("Unirii");
        adresa.setNumar(21);
        adrese.put("12345", adresa);
        
        locatie.setAdresa(adrese);
        
        em.getTransaction().begin();
        em.persist(locatie);
        em.getTransaction().commit();           
    }    
}