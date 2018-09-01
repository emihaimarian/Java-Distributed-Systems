package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
    
        try{
            System.out.println("Se incearca deschiderea portului 4444");
            ServerSocket serverSocket = new ServerSocket(4444);
            /*
             * Astept conectarea cu un client. Va astepta pana cand un client se va conecta 
             */
            System.out.println("Portul 4444 a fost deschis");
            System.out.println("Se asteapta un client...");
            /*
             * socket-ul returnat de accept al serverSocketului este socket-ul clientului
             */
            Socket socket = serverSocket.accept();
            System.out.println("Clientul s-a conectat");
            /*
             * Creez un un bufferedReader pe baza fluxului lowlvl pe care il obtin din socketul clientului
             */
            BufferedReader in = 
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream())
                    );
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Se asteapta un mesaj");
            String line = in.readLine();
            out.println(new StringBuilder(line).reverse().toString());
            System.out.println("Am primit " + line);
            System.out.println("Serverul se inchide...");    
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}