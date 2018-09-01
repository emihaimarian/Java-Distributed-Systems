package main;

import db.Factura;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main7 {
        
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e7PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            TypedQuery<Factura> factura = em.createNamedQuery("Factura.getById", Factura.class);
            factura.setParameter("id", 255);
            
            List<Factura> facturi = factura.getResultList();
            facturi.forEach(System.out::println);
        } finally{
            em.close();
            emf.close();
        }
    }
}