package main;

import db.Carte;
import db.Librarie;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Exemplu1 {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4e3PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Librarie librarie = new Librarie();
            librarie.setAdresa("Adresa");
            
            Carte carte = new Carte();
            carte.setTitlu("Titlu");
            
            Carte carte2 = new Carte();
            carte2.setTitlu("Titlu 2");
            
            librarie.setCarti(new ArrayList<>());
            librarie.getCarti().add(carte);
            librarie.getCarti().add(carte2);
            
            carte.setLibrarie(librarie);
            carte2.setLibrarie(librarie);
            
            em.getTransaction().begin();
            em.persist(librarie);
            em.persist(carte);
            em.persist(carte2);
            em.getTransaction().commit();
            
        } finally {
            em.close();
            emf.close();
        }
    } 
}