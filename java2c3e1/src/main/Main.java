package main;

import dao.ProdusDao;
import db.Produs;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
  
        MainFrame mf = new MainFrame();
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3e1PU");
//        EntityManager em = emf.createEntityManager();
        
//        Produs produs = new Produs();
//        produs.setName("Bere");
//        produs.setPrice(10);
       
//        ProdusDao produsDao = new ProdusDao(em);
        /* persist este o operatie de modificare a datelor si trebuie 
         *  facuta pe o tranzactie
        */ 
//        em.getTransaction().begin();
//        produsDao.addProdus(produs);
        /*
         * Apeland commit speceficiam nu doar ca se inchide tranzactia 
         *   ci ca si toate modificarile pot fi persistante
         * rollback -> tranzactia trebuie sa se intoarca la 
         *  locul de unde s-a facut begin. Nicio modificare care s-a facut intre
         * begin si rollback nu se va persista 
         *  O tranzactie marcheaza un set de operatii atomice care se executa fie toate fie niciuna
         */
//        em.getTransaction().commit();
        
//        Produs produs = produsDao.getProdus(1);
//        System.out.println(produs);

//        Produs produs = new Produs();
//        produs.setId(1);
//        em.getTransaction().begin();
//        produs = produsDao.mergeProdus(produs);
//        produsDao.deleteProdus(produs);
//        em.getTransaction().commit();

//        em.getTransaction().begin();
//        Produs produs = produsDao.getProdus(1);
//        produs.setPrice(30);
//        em.getTransaction().commit();
//        
//        
//        em.close();
//        emf.close();
   }  
}