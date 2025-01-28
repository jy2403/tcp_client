/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networklayer;


import business.NamesManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanf
 */
public class TCPserver {
    private int port;
    
    public TCPserver(int port){
        this.port=port;
    }
    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("server listing on port: "+port);
            while (true) {                
                //accept connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("connected from: "+clientSocket.getInetAddress());
                //defining input and output
                DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
                
                String clientMessage = inputStream.readUTF();
                System.out.println("client message: "+clientMessage);
                clientMessage = clientMessage.trim();
                String[] parts = clientMessage.split(":");
                NamesManager manager = new NamesManager();
                String response = manager.generateMessage(parts[0],parts[1]);
                System.out.println("Response: "+response);
                outputStream.writeUTF(response);
                clientSocket.close();
                System.out.println("connection closed");
                 
            }
        } catch (IOException ex) {
            System.out.println("error: "+ex.getMessage());
        }
    }
}
