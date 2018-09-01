package server;

import java.net.ServerSocket;
public class Server {

    public static void main(String[] args) {
        
        try{
            ServerSocket serverSocket = new ServerSocket(4444);
            
            while(true){
                new ServerThread(serverSocket.accept()).start(); 
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }   
}