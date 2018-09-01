package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.User;
import service.RegisterService;

public class ServerThread extends Thread{

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
   
    public ServerThread(Socket socket){
        
        try{
            this.socket = socket;
            this.in = new ObjectInputStream(socket.getInputStream());
            this.out = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void run(){
        
        try{
            while(true){
                User user = (User) in.readObject();
                boolean result = RegisterService.getInstance().register(user);
                out.writeObject(true);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}