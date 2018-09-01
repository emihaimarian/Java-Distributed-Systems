package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi.IMyService;

/*
 * God Object !
*/
public class Server extends UnicastRemoteObject implements IMyService {
    
    public Server() throws RemoteException{
        
        /*
        * LocateRegistry creeaza un registru care este in realitate o impl de 
        * RegistryPattern unde unei chei i se asociaza o valoare.
        */
        Registry registry = LocateRegistry.createRegistry(4444);
        registry.rebind("server", this);
    }
    
    /*
    * UniCastRemoteObject este clasa pe care obiectul care defineste mecanismul
    * de comunicare trebuie sa o mosteneasca in RMI ptr ca ea in spate face
    * deschiderea portului, firele de executie necesare ca mai multi clienti sa
    * poate accesa server-ul. 
    */
    public static void main(String[] args) {
        
        try {
            new Server();
        } catch (Exception e){
            e.printStackTrace();
        }
    }    

    @Override
    public String reverseString(String str) throws RemoteException {
        
        StringBuilder stringBuilder = new StringBuilder(str);
        
        return stringBuilder.reverse().toString();
    }
}