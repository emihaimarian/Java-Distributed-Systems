package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFileService extends Remote{
    
    public String list(String dirLocation) throws RemoteException;
    
    public void createFile(String fileLocation) throws RemoteException;
}