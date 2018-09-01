package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMyService extends Remote {
 
    /*
     * Are rolul de a abstractiza doar metodele care 
     * sunt expuse catre un anumit tip de clienti
     * Metodele care expun remote trebuie sa propage RemoteException
     * (Exceptie care generealizeaza orice situatie problematica care a aparut 
     * in comunicare: s-a intrerupt streamul, reteaua nu mai functioneaza etc.); 
     */
    
    public String reverseString(String str) throws RemoteException;
}