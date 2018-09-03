package client.Controller;

import db.Produs;
import java.awt.List;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;
import rmi.IProdusService;

public class ClientController {
 
    private IProdusService produsService;
    
    private ClientController(){
    
        try{
            Registry registry = LocateRegistry.getRegistry("localhost", 4444);
            produsService = (IProdusService) registry.lookup("produsService");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static final class SingeltonHolder{
        private static final ClientController SINGLETON = new ClientController();
    }
    
    public static ClientController getInstance(){
        return SingeltonHolder.SINGLETON;
    }
    
    public void addProdus(Produs produs){
        
        try{
            produsService.addProdus(produs);
        } catch(RemoteException e){
           e.printStackTrace();
        }
    }
    
    public List<Produs> getAllProducts(){
        try{
            return produsService.getAllProducts();
        } catch(RemoteException e){
            e.printStackTrace();
        }
        return Collection.emptyList();
    }
    
    public void deleteProduct(Produs produs){
        try{
            produsService.deleteProduc(produs);
        } catch (RemoteException e){
            e.printStackTrace();
        }
    }
}