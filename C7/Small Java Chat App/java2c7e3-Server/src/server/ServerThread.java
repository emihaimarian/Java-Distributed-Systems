package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public ServerThread(Socket socket) throws Exception{
        this.socket = socket;
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    public void sendMessage(String message){
        out.println(message);
    }
    
    public String receiveMessage() throws Exception{
        return in.readLine();
    }
       
    @Override
    public void run(){
        try{
            while(true){
                String message = receiveMessage();
                //Trimite messajul catre toti
                ClientsContainer.sendMessageToAll(message);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}