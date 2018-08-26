package main;

import dao.TransmisieDao;
import db.TipTransmisie;
import db.Transmisie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3e2PU");
        EntityManager em = emf.createEntityManager();
        TransmisieDao transmisieDao = new TransmisieDao(em);
        
        em.getTransaction().begin();
        Transmisie transmisie = new Transmisie();
        transmisie.setMesaj("abc");
        transmisie.setTipTransmisie(TipTransmisie.WIRELESS);
        transmisieDao.adaugaTransmisie(transmisie);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
}