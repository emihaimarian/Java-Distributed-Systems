package main;

import dao.TshirtDao;
import db.Color;
import db.Tshirt;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
     
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3e3PU");
        EntityManager em = emf.createEntityManager();
        TshirtDao tshirtDao = new TshirtDao(em);
        
        em.getTransaction().begin();
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("XL");
        tshirt.setColor(Color.WHITE);
        tshirtDao.add(tshirt);
        em.getTransaction().commit();
    }
}
