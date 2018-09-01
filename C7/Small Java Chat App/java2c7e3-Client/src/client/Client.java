package client;

import javax.swing.JOptionPane;

public class Client {

    public static void main(String[] args) {
        
        String nume = JOptionPane.showInputDialog("Nume: ");
        
        MainFrame mainFrame = new MainFrame(nume);
        mainFrame.startDisplayThread();

    }    
}