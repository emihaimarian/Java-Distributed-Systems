package main;

import db.Factura;
import db.Factura_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Main8 {
 
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e7PU");
        EntityManager em = emf.createEntityManager();
        
        try{        
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Factura> cq = cb.createQuery(Factura.class);
            
            Root<Factura> factura = cq.from(Factura.class);
            cq.select(factura).where(cb.equal(factura.get(Factura_.id), 255));
//            cq.where(cb.equal(factura.get("id"), factura));
            
            TypedQuery <Factura> tq = em.createQuery(cq);
            List<Factura> facturi = tq.getResultList();
            facturi.forEach(System.out::println);
            
        } finally{
            em.close();
            emf.close();
        }
    }
}