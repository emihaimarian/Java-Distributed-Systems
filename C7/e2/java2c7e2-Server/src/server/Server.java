package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
    
        try{
            ServerSocket serverSocket = new ServerSocket(4444);
            Socket socket = serverSocket.accept();
            
            BufferedReader in = 
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream())
                    );
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            int x = Integer.parseInt(in.readLine());
            int y = Integer.parseInt(in.readLine());
            out.println(x + y);
            System.out.println("Server-ul se inchide");    
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}