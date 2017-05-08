/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Gavin
 */
public class inputTask3Controller implements Initializable {
    
    @FXML
    private Button submitParameter;
    public TextField lifeElement;
    public TextField numberOfCity;
    public TextField maxTime;
    public TextField HP0;
    public TextField HP1;
    public TextField HP2;
    public TextField HP3;
    public TextField HP4;
    public TextField Attack0;
    public TextField Attack1;
    public TextField Attack2;
    public TextField Attack3;
    public TextField Attack4;
    
    @FXML
    private void submit(ActionEvent event)
    {
         Assignment2.lifeElement = Integer.parseInt(lifeElement.getText());
         Assignment2.numberOfCity = Integer.parseInt(numberOfCity.getText());
         Assignment2.maxTime = Integer.parseInt(maxTime.getText());
         
         Assignment2.HP[0] = Integer.parseInt(HP0.getText());
         Assignment2.HP[1] = Integer.parseInt(HP1.getText());
         Assignment2.HP[2] = Integer.parseInt(HP2.getText());
         Assignment2.HP[3] = Integer.parseInt(HP3.getText());
         Assignment2.HP[4] = Integer.parseInt(HP4.getText());
         
         Assignment2.Attack[0] = Integer.parseInt(Attack0.getText());
         Assignment2.Attack[1] = Integer.parseInt(Attack1.getText());
         Assignment2.Attack[2] = Integer.parseInt(Attack2.getText());
         Assignment2.Attack[3] = Integer.parseInt(Attack3.getText());
         Assignment2.Attack[4] = Integer.parseInt(Attack4.getText());
         
         //System.out.println("change scene");
         Assignment2.updateCityPosition();
//         Assignment2.mainStage.setScene(Assignment2.scene8);
         
         
    new Thread( () -> {
      try {
        String temp = ""+Assignment2.lifeElement+","+Assignment2.numberOfCity+","+Assignment2.maxTime
                       +","+Assignment2.HP[0]+","+Assignment2.HP[1]+","+Assignment2.HP[2]+","
                        +Assignment2.HP[3]+","+Assignment2.HP[4]+","+Assignment2.Attack[0]+","
                        +Assignment2.Attack[1]+","+Assignment2.Attack[2]+","+Assignment2.Attack[3]+","
                        +Assignment2.Attack[4]+","+"99";
        DataOutputStream outputToClient = new DataOutputStream(
          Assignment2.socket.getOutputStream());
        while(true)
             {
                outputToClient.writeUTF(temp);
                //outputToClient.writeInt(11);
                Platform.runLater(() -> {

                Assignment2.mainStage.setScene(Assignment2.scene8);
          });
                
             }

                    }
        catch(IOException ex) {
        ex.printStackTrace();
      }
        
      
    }).start();

         

    }
    
        @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");

        System.out.println("haha");
  
    }
    
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}
