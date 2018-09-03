package client.controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.IFileService;

public class ClientController {
    
    private IFileService fileService;
    
    private ClientController(){
    
        try{
            Registry registry = LocateRegistry.getRegistry("localhost", 4444);
            fileService = (IFileService) registry.lookup("fileservice");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder{
        private static final ClientController SINGLETON = new ClientController();    
    }
    
    public static ClientController getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public String list(String pathLocation){
        try{
            return fileService.list(pathLocation);
        } catch (RemoteException e){
            e.printStackTrace();
        }
        return "Error";
    }
    
    public void createFile(String fileLocation){
        try{
            fileService.createFile(fileLocation);
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }
}