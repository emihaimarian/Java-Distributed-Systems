package main;

import db.LinieFactura;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main2 {
     public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e7PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            String sql = "SELECT * FROM liniefactura lf WHERE lf .pret > ?";
            Query q = em.createNativeQuery(sql, LinieFactura.class);
            q.setParameter(1, 200);
            
            List<LinieFactura> listLinieFactura =  q.getResultList();
            listLinieFactura.forEach(System.out::println);
        } finally{
            em.close();
            emf.close();
        }
     }
}