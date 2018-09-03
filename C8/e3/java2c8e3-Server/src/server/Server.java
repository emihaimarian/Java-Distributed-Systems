package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.ProdusService;

public class Server {

    public static void main(String[] args) {
        
        try{
            Registry registry = LocateRegistry.createRegistry(4444);
            registry.rebind("produsService", new ProdusService());
        } catch (RemoteException e){
            e.printStackTrace();
        }
    }    
}