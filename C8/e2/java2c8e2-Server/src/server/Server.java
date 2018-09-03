package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.service.FileService;

public class Server {

    public static void main(String[] args) {
        
        try{
            Registry registry = LocateRegistry.createRegistry(4444);
            registry.rebind("fileservice", new FileService());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}