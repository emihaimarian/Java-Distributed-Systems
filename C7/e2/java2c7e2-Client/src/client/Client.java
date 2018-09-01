package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        
        try{
            Socket socket = new Socket("localhost", 4444);
            BufferedReader in = 
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream())
                    );
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            BufferedReader cons = 
                    new BufferedReader(
                            new InputStreamReader(System.in));
                    
            System.out.println("X: ");
            String x = cons.readLine();
            System.out.println("Y: ");
            String y = cons.readLine();
            out.println(x);
            out.println(y);
            System.out.println("SUMA " + in.readLine());
       } catch (Exception e){
            e.printStackTrace();
        }
    }    
}