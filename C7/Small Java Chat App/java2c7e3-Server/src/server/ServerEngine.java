package server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerEngine {
    
    private ServerSocket serverSocket;
    
    private ServerEngine(){
    
        try{
            serverSocket = new ServerSocket(4444);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder{
        private static final ServerEngine INSTANCE = new ServerEngine();
    }
    
    public static ServerEngine getInstance(){
        return SingletonHolder.INSTANCE;
    }
    
    public ServerThread connectClient() throws Exception{
        Socket socket = serverSocket.accept();
        ServerThread serverThread = new ServerThread(socket);
        serverThread.start();
        return serverThread;
    }
}