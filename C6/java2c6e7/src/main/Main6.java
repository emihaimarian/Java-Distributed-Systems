package main;

import db.Factura;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main6 {
 
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e7PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            String sql = "SELECT factura.serie, COUNT(factura) FROM Factura factura LEFT JOIN FETCH factura.linii WHERE factura.numar = :numar";
            Query factura = em.createQuery(sql);
            factura.setParameter("numar", 11);
            
            List<Object []> facturi = factura.getResultList();
            Object [] values = facturi.get(0);
            Arrays.asList(values).forEach(System.out::println);
        } finally{
            em.close();
            emf.close();
        }
    }
}