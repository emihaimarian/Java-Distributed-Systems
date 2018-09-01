package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.User;

public class ConnectionController {
    
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    private ConnectionController(){
    
        try{
            this.socket = new Socket("localhost", 4444);
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder{
        private static final ConnectionController SINGLETON = new ConnectionController();
    }
    
    public static ConnectionController getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public boolean register(String username, String password){
    
        try{
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            out.writeObject(user);
            return (Boolean) in.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}