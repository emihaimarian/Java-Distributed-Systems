package server.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import rmi.IFileService;

public class FileService extends UnicastRemoteObject implements IFileService{

    public FileService() throws RemoteException{
        
    }
    
    @Override
    public String list(String dirLocation) throws RemoteException {
        
        Path path = Paths.get(dirLocation);
        
        try {
            return Files.list(path)
                    .map(p -> p.toString())
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void createFile(String fileLocation) throws RemoteException {
        
        try{
            Path path = Paths.get(fileLocation);
            Files.createFile(path);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void execComand(String command) throws IOException{
        // Runtime.getRuntime().exec(command);
    }
    
    
}