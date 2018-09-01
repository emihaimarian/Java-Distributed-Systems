package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            while(true){
                ServerThread serverThread = ServerEngine.getInstance().connectClient();
                ClientsContainer.addClient(serverThread);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}