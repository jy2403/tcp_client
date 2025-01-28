/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanf.TCPDemoClient.networkclients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author juanf
 */
public class TCPClient {
    private String serverAddress;
    private int port;
    private Socket clientSocket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    
    public TCPClient(String serverAddress, int port){
        this.serverAddress =serverAddress;
        this.port=port;
    }
    public void connect() throws IOException{
        clientSocket = new Socket(serverAddress,port);
        System.out.println("Connection established");
        inputStream = new DataInputStream(clientSocket.getInputStream());
        outputStream = new DataOutputStream(clientSocket.getOutputStream()); 
    }
    public String sendMessage(String name, String lastName){
        String response = "Error";
        try {
            connect();
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(":").append(lastName);
            String message = sb.toString();
            System.out.println("Sending: "+message);
            outputStream.writeUTF(message);
            response = inputStream.readUTF();
            System.out.println("Response: "+response);
        } catch (IOException ex) {
            System.out.println("Client error: "+ex.getMessage());
        } finally{
            closeConnection();
        }
        return response;
    }
    
    public void closeConnection(){
        try {
            if (inputStream != null){
            inputStream.close();
            }
            if (outputStream != null){
            }
            if(clientSocket!= null){
                System.out.println("error");
            }
        } catch (IOException e) {
            
        }
        
    }
}
