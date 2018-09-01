package main;

import db.Factura;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main4 {
 
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e7PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            String sql = "SELECT factura FROM Factura factura WHERE factura.numar = :numar";
            TypedQuery<Factura> factura = em.createQuery(sql, Factura.class);
            factura.setParameter("numar", 11);
            
            List<Factura> facturi = factura.getResultList();
            facturi.forEach(System.out::println);
        } finally{
            em.close();
            emf.close();
        }
    }
}