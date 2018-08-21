package service;

import dao.ProdusDao;
import db.Produs;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainService {

    private EntityManagerFactory emf;
    
    public MainService(){
        /*
         * ii dam ca parametru numele persistence-ului 
         */
        emf = Persistence.createEntityManagerFactory("java2c2e1PU");
    }
    public void adaugaZeceProduse(){
        EntityManager em = emf.createEntityManager();
        ProdusDao produsDao = new ProdusDao(em);
        
        try{
            for(int i = 1; i <= 10; i++){
                Produs produs = new Produs();
                produs.setNume("Produs " + i);
                produs.setPret(10);
                produsDao.adaugaProdus(produs);
            }
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }
}