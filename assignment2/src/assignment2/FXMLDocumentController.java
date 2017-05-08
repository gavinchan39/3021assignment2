/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Gavin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button submitParameter;
    private ImageView haha;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        System.out.println("haha");
        label.setText("haha");
    }
    
    
    @FXML
    private void display(ActionEvent event)
    {
         System.out.println("display");
         Assignment2.mainStage.setScene(Assignment2.scene2);
    }
    
    @FXML
    private void singlePlayer(ActionEvent event)
    {
         System.out.println("singlePlayer");
         Assignment2.mainStage.setScene(Assignment2.scene4);
    }
    
    @FXML
    private void MultiPlayer(ActionEvent event)
    {
         System.out.println("MultiPlayer");
         Assignment2.mainStage.setScene(Assignment2.scene6);
    }
    
    @FXML
    private void showImage()
    {
//        String pathToImageSortBy = "file:figure/castle_0.png";
//        Image temp = new Image(pathToImageSortBy);
//        haha = new ImageView(temp);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       showImage();
        
    }    
    
}
