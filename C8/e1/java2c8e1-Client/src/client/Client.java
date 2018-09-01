package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.IMyService;

public class Client {
    public static void main(String[] args) {
        
        try{
            Registry registry = LocateRegistry.getRegistry("localhost", 4444);
            IMyService iMyService = (IMyService) registry.lookup("server");
            String result = iMyService.reverseString("Hello Word!");
            System.out.println(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }    
}