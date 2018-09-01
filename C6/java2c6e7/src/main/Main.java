package main;

import db.Factura;
import db.LinieFactura;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e7PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            LinieFactura linieFactura = new LinieFactura();
            linieFactura.setProdus("Produs 1");
            linieFactura.setCantitate(10);
            linieFactura.setPret(50);
            
            LinieFactura linieFactura2 = new LinieFactura();
            linieFactura2.setProdus("Produs 2");
            linieFactura2.setCantitate(20);
            linieFactura2.setPret(100);
            
            LinieFactura linieFactura3 = new LinieFactura();
            linieFactura3.setProdus("Produs 3");
            linieFactura3.setCantitate(30);
            linieFactura3.setPret(1000);
            
            LinieFactura linieFactura4 = new LinieFactura();
            linieFactura4.setProdus("Produs 4");
            linieFactura4.setCantitate(40);
            linieFactura4.setPret(00100);
            
            Factura factura = new Factura();
            factura.setSerie("XY");
            factura.setNumar(11);
            
            Factura factura2 = new Factura();
            factura2.setSerie("XY");
            factura2.setNumar(22);
            
            factura.setLinii(Arrays.asList(linieFactura, linieFactura2, linieFactura3));
            linieFactura.setFactura(factura);
            linieFactura2.setFactura(factura);
            linieFactura3.setFactura(factura);
            
           factura2.setLinii(Arrays.asList(linieFactura4));
           linieFactura4.setFactura(factura2);
           
           em.getTransaction().begin();
           em.persist(linieFactura);
           em.persist(linieFactura2);
           em.persist(linieFactura3);
           em.persist(linieFactura4);
           em.persist(factura);
           em.persist(factura2);
           em.getTransaction().commit();
        } finally{
            em.close();
            emf.close();
        }
    }    
}