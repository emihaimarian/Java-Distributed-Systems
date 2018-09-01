package client;

import java.util.ArrayList;
import java.util.List;

public class DisplayThread extends Thread {
    
    private List<ClientMessageListener> listeners;
    
    public DisplayThread(){
        listeners = new ArrayList<>();
    }
    
    public void run(){
        while(true){
            String message = ConnectionController.getInstance().receiveMessage();
            notifyAllListeners(message);
        }
    }
    
    public void addClientMessageListener(ClientMessageListener cml){
        listeners.add(cml);
    }
    
    private void notifyAllListeners(String message){
        listeners.forEach(cml -> cml.messageReceived(message));
    }
}