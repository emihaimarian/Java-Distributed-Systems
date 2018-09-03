package service;

import dao.ProdusDao;
import db.Produs;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IProdusService;

public class ProdusService extends UnicastRemoteObject implements IProdusService{
    
    private EntityManagerFactory emf;
    
    public ProdusService() throws RemoteException{
        
        emf = Persistence.createEntityManagerFactory("java2c8e3ServerPU");
    }

    @Override
    public void addProdus(Produs produs){
        
        EntityManager em = emf.createEntityManager();
        ProdusDao produsDao = new ProdusDao(em);
        
        try{
            em.getTransaction().begin();
            produsDao.addProdus(produs);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }

    @Override
    public List<Produs> getAllProducts(){
        
        EntityManager em = emf.createEntityManager();
        ProdusDao produsDao = new ProdusDao(em);
        
        try{
            return produsDao.getAllProducts();
        } finally{
            em.close();
        }
    }

    @Override
    public void deleteProduc(Produs produs){
        
        EntityManager em = emf.createEntityManager();
        ProdusDao produsDao = new ProdusDao(em);
        
        try{
            em.getTransaction().begin();
            produsDao.deleteProduct(produs);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }
}