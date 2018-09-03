package rmi;

import db.Produs;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IProdusService extends Remote {
    
    public void addProdus(Produs produs) throws RemoteException;
    
    public List<Produs> getAllProducts() throws RemoteException;
    
    public void deleteProduc(Produs produs) throws RemoteException;
}
