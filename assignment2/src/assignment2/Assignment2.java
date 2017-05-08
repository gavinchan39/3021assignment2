/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import World.World;
import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Gavin
 */
public class Assignment2 extends Application {
    
    public static Stage mainStage;
    public static Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8;
    private static Assignment2 instance;
    
    public static int lifeElement;
    public static int numberOfCity;
    public static int maxTime;
    public static int cityXPosition[];
    public static int cityYPosition = 50;
    
    public static int HP[] = new int[5];
    public static int Attack[] = new int[5];
    
    public static String console="";
    public static Socket socket;
    public static String serverIP;
   
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        scene1 = new Scene(root);
        
        Parent root2 = FXMLLoader.load(getClass().getResource("Input.fxml"));
        scene2 = new Scene(root2);
        
        Parent root3 = FXMLLoader.load(getClass().getResource("assignment1.fxml"));
        scene3 = new Scene(root3);
        
        Parent root4 = FXMLLoader.load(getClass().getResource("InputTask2.fxml"));
        scene4 = new Scene(root4);
        
        Parent root5 = FXMLLoader.load(getClass().getResource("task2.fxml"));
        scene5 = new Scene(root5);
        
        Parent root6 = FXMLLoader.load(getClass().getResource("InputIPTask3.fxml"));
        scene6 = new Scene(root6);
        
        Parent root7 = FXMLLoader.load(getClass().getResource("InputTask3.fxml"));
        scene7 = new Scene(root7);
        
       // Parent root8 = FXMLLoader.load(getClass().getResource("task3.fxml"));
       // scene8 = new Scene(root8);
        
        mainStage = stage;
        
        mainStage.setScene(scene1);
        mainStage.show();
    }
    
    public static void updateCityPosition()
    {
        //System.out.println("updataCityPosition");
       // System.out.println(numberOfCity);
        
        if(numberOfCity !=0)
        cityXPosition = new int[numberOfCity];
        
        int temp = (int)((mainStage.getWidth()-150)/5);
        for(int a=0;a<numberOfCity;++a)
        {
           // System.out.println(a);
            if(a ==0)
            {
                cityXPosition[0]= 50;
                continue;
            }
            
            cityXPosition[a]= cityXPosition[a-1]+ temp; 
        }
        
        /*
        for(int b=0;b<numberOfCity;++b)
        {
            System.out.println(cityXPosition[b]+" ");
        }
        */
        
    }
    
    public Assignment2()
    {
        Assignment2.instance = this;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // World world = new World();
       // world.runGame();
        launch(args);
    }
    
}
