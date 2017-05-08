/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Gavin
 */
public class inputIPTask3Controller implements Initializable {
    
    @FXML
    String ip;
    private Button submitParameter;
    public Label label1;

  DataOutputStream toServer = null;
  DataInputStream fromServer = null;
    public InetAddress inetAddress;
    public TextArea ta;
    public Label IPAddress;
    public TextField hostIPAddress;
    
    @FXML
    private void submit(ActionEvent event)
    {
        
         
         //System.out.println("change scene");

        // Assignment2.mainStage.setScene(Assignment2.scene7);
    }
    
        @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        System.out.println("haha");

    }
    
    @FXML
    public void beClient(ActionEvent event)
    {
        
        String temp = hostIPAddress.getText();
            try {
      // Create a socket to connect to the server
      Socket socket = new Socket(temp, 8120);
      // Socket socket = new Socket("130.254.204.36", 8000);
      // Socket socket = new Socket("drake.Armstrong.edu", 8000);

      // Create an input stream to receive data from the server
      fromServer = new DataInputStream(socket.getInputStream());

      // Create an output stream to send data to the server
      toServer = new DataOutputStream(socket.getOutputStream());
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
        
        
    }
    
    @FXML
    public void openServer(ActionEvent event)
    {
        
        Alert alert = new Alert(AlertType.INFORMATION);
        new Thread( () -> {
      try {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8120);

  
        // Listen for a connection request
        Socket socket = serverSocket.accept();
  
        // Create data input and output streams

        DataInputStream inputFromClient = new DataInputStream(
          socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(
          socket.getOutputStream());
  
        while (true) {
          // Receive radius from the client
//          double radius = inputFromClient.readDouble();
//  
//          // Compute area
//          double area = radius * radius * Math.PI;
  
          // Send area back to the client
//          outputToClient.writeDouble(area);
  
          Platform.runLater(() -> {
//            ta.appendText("Radius received from client: " 
//              + radius + '\n');
//            ta.appe
//ndText("Area is: " + area + '\n'); 
            alert.close();
            Assignment2.mainStage.setScene(Assignment2.scene7);
            
          });
        }
      }
      catch(IOException ex) {
        ex.printStackTrace();
      }
    }).start();
        
        

alert.setTitle("waiting for client");
alert.setHeaderText("Look, client is coming");
alert.setContentText("wait for a minutes");
ButtonType buttonTypeOne = new ButtonType("Cancel");
alert.getButtonTypes().set(0, buttonTypeOne);
alert.showAndWait();



        
    }
    
        @FXML
        @Override
    public void initialize(URL url, ResourceBundle rb) {
//       
//        new Thread( () -> {
//      try {
//        // Create a server socket
//        ServerSocket serverSocket = new ServerSocket(8001);
//
//            Platform.runLater(() ->
//         // IPAddress.setText(serverSocket.getInetAddress()));
//        // Listen for a connection request
//        Socket socket = serverSocket.accept();
//
//        // Create data input and output streams
//        DataInputStream inputFromClient = new DataInputStream(
//          socket.getInputStream());
//        DataOutputStream outputToClient = new DataOutputStream(
//          socket.getOutputStream());
//  
//        while (true) {
//          // Receive radius from the client
//          double radius = inputFromClient.readDouble();
//  
//          // Compute area
//          double area = radius * radius * Math.PI;
//  
//          // Send area back to the client
//          outputToClient.writeDouble(area);
//  
//          Platform.runLater(() -> {
//            ta.appendText("Radius received from client: " 
//              + radius + '\n');
//            ta.appendText("Area is: " + area + '\n'); 
//          });
//        }
//        
//      }
//      catch(IOException ex) {
//        ex.printStackTrace();
//      }
//    }).start();
        
        
//        new Thread( () -> {
//
//            
//                
//        try {
//            server = new ServerSocket(8001);
//            socket = server.accept();
//            inetAddress = socket.getInetAddress();
//            label1.setText("321");
//        } catch (IOException ex) {
//          ex.printStackTrace();
//        }
//        
//        }).start();
        // TODO
        
    try {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            // filters out 127.0.0.1 and inactive interfaces
            if (iface.isLoopback() || !iface.isUp())
                continue;

            Enumeration<InetAddress> addresses = iface.getInetAddresses();
                
            InetAddress addr = addresses.nextElement()         ;
                    ip = addr.getHostAddress();
                    IPAddress.setText(""+ip);


//            while(addresses.hasMoreElements()) {
//                InetAddress addr = addresses.nextElement();
//                ip = addr.getHostAddress();
//                System.out.println(iface.getDisplayName() + " " + ip);
//            }
        }
    } catch (Exception k) {
        throw new RuntimeException(k);
    }

    }  
}
