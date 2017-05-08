/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Gavin
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//import that class that in assignment1
import World.Clock;
import World.City;
import World.Headquarters;
import World.WorldProperty;
import Warriors.WarriorType;
import Warriors.Warrior;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;



/**
 *
 * @author Gavin
 */
public class task3ClientController implements Initializable {
    
    // try to merge the world object to this controller
    //parameter for the world to run
    	public static Clock clock =new Clock();
	public City[] CityList;
       public boolean startGame; 
       public boolean nextTurn = true;
       public boolean endGame;
    
    // the object that related to java fx layout
    @FXML
    public Button nextTurn0;
    public Button gameStart;
    private Button submitParameter;
    public Label label;
    public ImageView imageViewArr [];
    public Image imageArr[];
    public ImageView CityImageViewArr [];
    public Image CityImageArr[];
    public HBox cityBar;
    public HBox soldierBar;
    public VBox overview;
    public ImageView imageview1;
    public TextFlow textFlow0;
    private int i = 0;
    public ImageView soldier0;
    public ImageView soldier1;
    public ImageView soldier2;
    public ImageView soldier3;
    public ImageView soldier4;
    public ImageView soldier5;
    public ImageView soldier6;
    public ImageView soldier7;
    public ImageView soldier8;
    public ImageView soldier9;
    public ImageView flag0;
    public ImageView flag1;
    public ImageView flag2;
    public ImageView flag3;
    public ImageView flag4;
    public Button button0;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Label lifeElementText;
    public Label timeText;
    public Label countDownLabel;
    public GridPane gridPane;
    public Label typeText;
    public Label partyText;
    public Label idText;
    public Label locationText;
    public Label hpText;
    public Label attackText;
    public Label killText;
    public Label stepText;
    public int option;
    private Service<Void> backgroundThread;
    private Service<Void> timeThread;
    //as this is created as Globol variable
    //String Assignment2.console;
    public long countDownStart = System.currentTimeMillis();
    @FXML
    public void clickButton(ActionEvent e)
    {
        System.out.println("time" + Integer.toString(clock.getMinute()));
        //"dragon", "ninja", "iceman", "lion", "wolf"
        

        option = 5;
        if(clock.getMinute() != 0)
        {
            
            return;
        }
        if((((Button)e.getSource()).getId()).equals("button0"))
        {   
            //System.out.println("0");
            option =0;
        }
        if((((Button)e.getSource()).getId()).equals("button1"))
        {
            //System.out.println("1");
            option =2;
        }
        if((((Button)e.getSource()).getId()).equals("button2"))
        {
           // System.out.println("2");
            option =3;
        }
        if((((Button)e.getSource()).getId()).equals("button3"))
        {
           // System.out.println("3");
            option =4;
        }
        if((((Button)e.getSource()).getId()).equals("button4"))
        {
           // System.out.println("4");
            option =2;
        }
        if((((Button)e.getSource()).getId()).equals("button5"))
        {
            //System.out.println("5");
            option =5;
        }
    }
    
    
    @FXML
    public void showHoverInfo(MouseEvent e)
    {
        if((((Button)e.getSource()).getId()).equals("button0"))
        {
            typeText.setText("Dragon");
       partyText.setText("Blue");
        hpText.setText(""+Assignment2.HP[0]);
        attackText.setText(""+Assignment2.Attack[0]);
        }
        
        if((((Button)e.getSource()).getId()).equals("button1"))
        {
            typeText.setText("Iceman");
       partyText.setText("Blue");
        hpText.setText(""+Assignment2.HP[1]);
        attackText.setText(""+Assignment2.Attack[1]);
        }
        
        if((((Button)e.getSource()).getId()).equals("button2"))
        {
            typeText.setText("Lion");
       partyText.setText("Blue");
        hpText.setText(""+Assignment2.HP[2]);
        attackText.setText(""+Assignment2.Attack[2]);
        }
        
        if((((Button)e.getSource()).getId()).equals("button3"))
        {
            typeText.setText("Wolf");
       partyText.setText("Blue");
        hpText.setText(""+Assignment2.HP[3]);
        attackText.setText(""+Assignment2.Attack[3]);
        }
        
        if((((Button)e.getSource()).getId()).equals("button4"))
        {
            typeText.setText("Ninja");
       partyText.setText("Blue");
        hpText.setText(""+Assignment2.HP[4]);
        attackText.setText(""+Assignment2.Attack[4]);
        }
       
        if((((Button)e.getSource()).getId()).equals("button5"))
        {
            typeText.setText("N/A");
       partyText.setText("N/A");
        hpText.setText("N/A");
        attackText.setText("N/A");
        }
       
        
    }
    

    
    
    @FXML
    public void updateText()
    {
        lifeElementText.setText(""+((Headquarters)CityList[Assignment2.numberOfCity+1]).LifeElement);
        timeText.setText((clock.customFormat(clock.getTime(), clock.getMinute())));
    }
    
    @FXML
    private void submit(ActionEvent event)
    {
         System.out.println("change scene");
         System.out.println("LifeElement");
         System.out.println(Assignment2.lifeElement);
         label.setText(""+Assignment2.lifeElement);
         
    }
    

    
    @FXML
    private void startGame(ActionEvent event) {
        System.out.println("start Game lala");
        if(!startGame)
        {
            runGame();
           // movePhoto(0);
            System.out.println(Assignment2.console);
            gameStart.setText("Game started");
            

        }
        

  
    }
    
    
       // @Override
        @FXML
        public void initialize(URL url, ResourceBundle rb) {
        // TODO

       //Image temp = new Image("file:figure/dragon_red.png");
       //Image temp = new Image("file:figure/castle_0.png");
       //soldier0.setImage(temp);
        
        //Image temp = new Image("file:src/figure/castle_0.png");

       //imageview1.setImage(temp);
       //imageview1 = new ImageView(temp);

       // System.out.println("imageview la");
       startGame = false;
       endGame = false;
       option =5;
 
       
       //set the init message in the grid pane
        typeText.setText("N/A");
        partyText.setText("N/A");
        idText.setText("N/A");
        locationText.setText("N/A");
        hpText.setText("N/A");
        attackText.setText("N/A");
        killText.setText("N/A");
        stepText.setText("N/A");
       
        lifeElementText.setText("");
        timeText.setText("");
       // display the lines between grid
       gridPane.setGridLinesVisible(true);
       //set the image of the button
       Image temp0 = new Image("file:figure/dragon_small.png");
       button0.setGraphic(new ImageView(temp0));
       temp0 = new Image("file:figure/iceman_small.png");
       button1.setGraphic(new ImageView(temp0));
       temp0 = new Image("file:figure/Lion_small.png");
       button2.setGraphic(new ImageView(temp0));
       temp0 = new Image("file:figure/wolf_small.png");
       button3.setGraphic(new ImageView(temp0));
       temp0 = new Image("file:figure/ninja_small.png");
       button4.setGraphic(new ImageView(temp0));
       temp0 = new Image("file:figure/no_small.png");
       button5.setGraphic(new ImageView(temp0));
       
       Text text1 = new Text(Assignment2.console);
       textFlow0.getChildren().add(text1);
       
        CityImageViewArr = new ImageView[Assignment2.numberOfCity];
        CityImageArr = new Image[Assignment2.numberOfCity];
        
        imageViewArr = new ImageView[Assignment2.numberOfCity*2];
        imageArr = new Image[Assignment2.numberOfCity*2];
     
        
        
        /*
        for(int a=0;a<Assignment2.numberOfCity;++a)
        {
            if(a==0 || a== (Assignment2.numberOfCity-1))
            {
                CityImageArr[a] = new Image("file:srcfigure/castle_0.png");
            }
            else
            {
                CityImageArr[a] = new Image("file:srcfigure/castle_1.png");
            }
            
            CityImageViewArr[a] = new ImageView(CityImageArr[a]);
            cityBar.getChildren().add(CityImageViewArr[a]);
        }
        
        
        for(int a=0; a<Assignment2.numberOfCity*2; ++a)
        {
            imageArr[a] = new Image("file:srcfigure/empty.png");
            imageViewArr[a] = new ImageView(imageArr[a]);
            imageViewArr[a].setFitHeight(50);
            imageViewArr[a].setFitWidth(50);
            if(a%2 ==0)
            {
                imageViewArr[a].setX(Assignment2.cityXPosition[a/2]);
                imageViewArr[a].setY(Assignment2.cityYPosition);
            }
            else
            {
                imageViewArr[a].setX(Assignment2.cityXPosition[(a-1)/2+50]);
                imageViewArr[a].setY(Assignment2.cityYPosition);
            }
            
            soldierBar.getChildren().add(imageViewArr[a]);
        }
        */
        
    }  
        @FXML
        //0 is red 1 is blue, red is left, blue is right
        //0=dragon, 1=ninja, 2=iceman, 3=lion, 4=wolf
        public void addPhotoToSoldier(int type, int campaign)
        {
            if(campaign ==0)
            {
                
                Image temp;
                switch(type)
                {
                    case 0:
                        temp = new Image("file:figure/dragon_red.png");
                        soldier0.setImage(temp);
                        break;
                    case 1:
                        temp = new Image("file:figure/ninja_red.png");
                        soldier0.setImage(temp);
                        break;
                    case 2:
                        temp = new Image("file:figure/iceman_red.png");
                        soldier0.setImage(temp);
                        break;
                    case 3:
                        temp = new Image("file:figure/lion_red.png");
                        soldier0.setImage(temp);
                        break;
                    case 4:
                        temp = new Image("file:figure/wolf_red.png");
                        soldier0.setImage(temp);
                        break;
                }
                
            }
                
            else
            {
                Image temp;
                switch(type)
                {
                    case 0:
                        temp = new Image("file:figure/dragon_blue.png");
                        soldier9.setImage(temp);
                        break;
                    case 1:
                        temp = new Image("file:figure/ninja_blue.png");
                        soldier9.setImage(temp);
                        break;
                    case 2:
                        temp = new Image("file:figure/iceman_blue.png");
                        soldier9.setImage(temp);
                        break;
                    case 3:
                        temp = new Image("file:figure/lion_blue.png");
                        soldier9.setImage(temp);
                        break;
                    case 4:
                        temp = new Image("file:figure/wolf_blue.png");
                        soldier9.setImage(temp);
                        break;
                }
            }
        }
        
        @FXML
        public void raisedFlag(int city,int party)
        {
            Image temp;
            switch(city)
            {
                case 0:
                    if(party ==0)
                    {
                        temp = new Image("file:figure/flag_red.png");
                        flag0.setImage(temp);
                    }
                    else
                    {
                        temp = new Image("file:figure/flag_blue.png");
                        flag0.setImage(temp);
                    }
                    break;
                    
                case 1:
                     if(party ==0)
                    {
                        temp = new Image("file:figure/flag_red.png");
                        flag1.setImage(temp);
                    }
                    else
                    {
                        temp = new Image("file:figure/flag_blue.png");
                        flag1.setImage(temp);
                    }               
                    break;
                 case 2:
                    if(party ==0)
                    {
                        temp = new Image("file:figure/flag_red.png");
                        flag2.setImage(temp);
                    }
                    else
                    {
                        temp = new Image("file:figure/flag_blue.png");
                        flag2.setImage(temp);
                    }                     
                    break;
                    
                case 3:
                    if(party ==0)
                    {
                        temp = new Image("file:figure/flag_red.png");
                        flag3.setImage(temp);
                    }
                    else
                    {
                        temp = new Image("file:figure/flag_blue.png");
                        flag3.setImage(temp);
                    }               
                    break;
                case 4:
                    if(party ==0)
                    {
                        temp = new Image("file:figure/flag_red.png");
                        flag4.setImage(temp);
                    }
                    else
                    {
                        temp = new Image("file:figure/flag_blue.png");
                        flag4.setImage(temp);
                    }               
                    break;
                    
                    
            }
        }
        
        @FXML
        public void movePhoto(int from)
        {
            Image temp;
            switch(from)
            {
              case 0:
                  temp = soldier0.getImage();
                  soldier2.setImage(temp);
                  temp = new Image("file:figure/empty_grey.png");
                  soldier0.setImage(temp);
                  break;
              case 1 :
                  System.out.println("walk to the end");
                    break;
              case 2 :
                  temp = soldier2.getImage();
                  soldier4.setImage(temp);
                  temp = new Image("file:figure/empty_grey.png");
                  soldier2.setImage(temp);
                    break;
              case 3 :
                  temp = soldier3.getImage();
                  soldier1.setImage(temp);
                  temp = new Image("file:figure/empty_grey.png");
                  soldier3.setImage(temp);
                    break;
              case 4 :
                  temp = soldier4.getImage();
                  soldier6.setImage(temp);
                  temp = new Image("file:figure/empty_grey.png");
                  soldier4.setImage(temp);
                    break;
              case 5 :
                  temp = soldier5.getImage();
                  soldier3.setImage(temp);
                  temp = new Image("file:figure/empty_grey.png");
                  soldier5.setImage(temp);
                    break;
              case 6 :
                  temp = soldier6.getImage();
                  soldier8.setImage(temp);
                  temp = new Image("file:figure/empty_grey.png");
                  soldier6.setImage(temp);
                    break;
              case 7 :
                  temp = soldier7.getImage();
                  soldier5.setImage(temp);
                  temp = new Image("file:figure/empty_grey.png");
                  soldier7.setImage(temp);
                    break;
              case 8:
                  System.out.println("walk to the end");
                  break;
              case 9:
                  temp = soldier9.getImage();
                  soldier7.setImage(temp);
                  temp = new Image("file:figure/empty_grey.png");
                  soldier9.setImage(temp);
                  break;
              default:
                  System.out.println("SHIT!!!!!!!!!!!!!!!!!!!!!!!!!!");
                   
                    
            }
        }
        
        @FXML
        public void removePhoto(int index)
        {
            Image temp;
            switch(index)
            {
                case 0:
                  temp = new Image("file:figure/empty_grey.png");
                  soldier0.setImage(temp);
                    break;
                case 1:
                  temp = new Image("file:figure/empty_grey.png");
                  soldier1.setImage(temp);
                    break;
               case 2:
                   temp = new Image("file:figure/empty_grey.png");
                  soldier2.setImage(temp);
                    break;
               case 3:
                   temp = new Image("file:figure/empty_grey.png");
                  soldier3.setImage(temp);
                    break;
               case 4:
                   temp = new Image("file:figure/empty_grey.png");
                  soldier4.setImage(temp);
                    break;
               case 5:
                   temp = new Image("file:figure/empty_grey.png");
                  soldier5.setImage(temp);
                    break;
               case 6:
                   temp = new Image("file:figure/empty_grey.png");
                  soldier6.setImage(temp);
                    break;
               case 7:
                   temp = new Image("file:figure/empty_grey.png");
                  soldier7.setImage(temp);
                    break;
               case 8:
                   temp = new Image("file:figure/empty_grey.png");
                  soldier8.setImage(temp);
                    break;
               case 9:
                   temp = new Image("file:figure/empty_grey.png");
                  soldier9.setImage(temp);
                    break;
            }
        }
        
        @FXML
       private void nextTurn(ActionEvent event) {

                nextTurn = true;
                countDownStart = System.currentTimeMillis();
            
            
             System.out.println("You clicked me!");
        //label.setText("Getting Started");
        
        backgroundThread = new Service<Void>(){
            @Override
            protected Task<Void> createTask(){
                return new Task<Void>(){
                    @Override
                    protected Void call() throws Exception {
                        //TODO: ADD MODEL CODE HERE.
                        for (i=0;i<100000000;i++){
                            Thread.sleep(1000);

                            Platform.runLater(
                            //TODO: ADD GUI CODE HERE.
                                () -> {
                                   // final String labelText = String.valueOf(i);
                                   // label.setText(labelText);

                    //wait for user to press the next turn button

                            if((!endGame) &&nextTurn)
                            {

                            
                                nextTurn = false;
                            int minutes = clock.getMinute();

                            Assignment2.console="";
                            if(minutes == 0)
                            {
                                System.out.println("Minutes 0");
             

                                    if(((Headquarters)CityList[0]).tryToProduceWarrior())
                                    {       //blue
                                        addPhotoToSoldier(((Headquarters) CityList[0]).RedWarriorStation.get((((Headquarters) CityList[0]).RedWarriorStation).size()-1).type,0);
                                            //System.out.println("haha");
                                       // System.out.println(WorldProperty.PartyNames[0]);
                                       // System.out.println(WarriorType.WarriorNames[((Headquarters) CityList[0]).RedWarriorStation.get((((Headquarters) CityList[0]).RedWarriorStation).size()-1).type]);
                                      //  System.out.println("haha");
                                        Assignment2.console+=(clock.customFormat(clock.getTime(), clock.getMinute()));
                                            Assignment2.console+=(WorldProperty.PartyNames[0]+" "
                                            +WarriorType.WarriorNames[((Headquarters) CityList[0]).RedWarriorStation.get((((Headquarters) CityList[0]).RedWarriorStation).size()-1).type]+
                                            " "+((Headquarters) CityList[0]).RedWarriorStation.get((((Headquarters) CityList[0]).RedWarriorStation).size()-1).ProductionID+" born"+"\n");
                                    }
                                
                
                                    
                                    if(option != 5)
                                    {
                                        if(((Headquarters)CityList[WorldProperty.NumberOfCity+1]).tryToProduceWarrior(option))
                                          {
                                              option = 5;
                                                System.out.println("produce warrior with index: "+option);
                                               addPhotoToSoldier(((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation.get((((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation).size()-1).type,1);
                                               //System.out.println("Blue change time: "+clock.customFormat(clock.getTime(), clock.getMinute()));
                                                    Assignment2.console+=(clock.customFormat(clock.getTime(), clock.getMinute()));
                                                    Assignment2.console+=(WorldProperty.PartyNames[1]+" "
                                                    +WarriorType.WarriorNames[((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation.get((((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation).size()-1).type]+
                                                    " "+((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation.get((((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation).size()-1).ProductionID+" born"+"\n");
                                          }
                                        
                                    }
                                    else
                                    {
                                        System.out.println("no warrior produced");
                                    }
                                    
                                   // updateText();
                            }


                            if(minutes == 10)
                            {
                                System.out.println("Minutes 10");
                                    marchWarriors();
                                    if(((Headquarters)CityList[0]).checkOccupied())
                                    {
                                            Assignment2.console+=(clock.customFormat(clock.getTime(), clock.getMinute()));
                                            Assignment2.console+=("red headquarter was taken\n");

                                    }
                                    if(((Headquarters)CityList[WorldProperty.NumberOfCity+1]).checkOccupied())
                                    {
                                            Assignment2.console+=(clock.customFormat(clock.getTime(), clock.getMinute()));
                                            Assignment2.console+=("blue headquarter was taken\n");

                                    }
                                    //updateText();
                            }


                            if(minutes == 20)
                            {
                                   System.out.println("Minutes 20");
                                    ProduceLifeElements();
                                    //updateText();
                            }


                            if(minutes == 30)
                            {
                                    System.out.println("Minutes 30");
                                    warriorsFetchLifeElementsFromCity();
                                   // updateText();


                            }


                            if(minutes == 40)
                            {
                                    System.out.println("Minutes 40");
                                    holdBattlesAndWorkAfterBattles();
                                    //updateText();
                            }


                            if(minutes == 50)
                            {
                                    System.out.println("Minutes 50");
                                    headquartersReportLifeElements();
                                    //updateText();
                            }

                            clock.increase();
                            updateText();
                            Text text1 = new Text(Assignment2.console);
                            textFlow0.getChildren().add(text1);
                            endGame =!(Integer.parseInt(clock.getTime())*60+clock.getMinute()<=WorldProperty.MaxMinutes &&
				!((Headquarters)CityList[0]).checkOccupied() && !((Headquarters)CityList[WorldProperty.NumberOfCity+1]).checkOccupied());
                            
                        }
                       // System.out.print("show you the monkey");
                       // System.out.println(WorldProperty.MaxMinutes );


                                }
                            );
                        }
                        return null;
                    }   
                };
            }
        };
        
       backgroundThread.setOnSucceeded(new EventHandler<WorkerStateEvent>(){
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println("Done");        
            }
        }
        );
        backgroundThread.restart(); 
            
        
        

        
        
        
        }

        
        //code from assignment1
        	public void runGame(){
	
		//Scanner scanner = new Scanner(System.in);
		//System.out.println("Input: ");
		WorldProperty.InitLifeElements = Assignment2.lifeElement;
		WorldProperty.NumberOfCity = Assignment2.numberOfCity;
		WorldProperty.MaxMinutes = Assignment2.maxTime;

		for(int a= 0;a<5;++a)
		{
			WarriorType.HP_LIST[a] = Assignment2.HP[a];
		}
		for(int a= 0;a<5;++a)
		{
			WarriorType.ATTACK_LIST[a] = Assignment2.Attack[a];
		}
		
		CityList = new City[WorldProperty.NumberOfCity+2];
		CityList[WorldProperty.NumberOfCity+1] = new Headquarters(WorldProperty.BlueProductionOrder
				, WorldProperty.NumberOfCity+1, WorldProperty.BLUE, WorldProperty.BLUE);
		
		CityList[0] = new Headquarters(WorldProperty.RedProductionOrder, 0, WorldProperty.RED, WorldProperty.RED);
		CityList[0].LifeElement=WorldProperty.InitLifeElements;
		CityList[WorldProperty.NumberOfCity+1].LifeElement = WorldProperty.InitLifeElements;
		
		for(int a =1; a<=WorldProperty.NumberOfCity; ++a)
		{
			CityList[a] = new City(a);
		}

                
                countDownStart = System.currentTimeMillis();
                timeThread = new Service<Void>(){
            @Override
            protected Task<Void> createTask(){
                return new Task<Void>(){
                    @Override
                    protected Void call() throws Exception {
                        //TODO: ADD MODEL CODE HERE.
                        for (i=0;i<100000000;i++){
                            Thread.sleep(1000);

                            Platform.runLater(
                            //TODO: ADD GUI CODE HERE.
                                () -> {
                            long countDownElapsed = 10 - (System.currentTimeMillis()- countDownStart) / 1000;
                            countDownLabel.setText(Long.toString(countDownElapsed));
                                    if(countDownElapsed <= 0)
                                    {
                                        nextTurn0.fire();
                                        countDownStart = System.currentTimeMillis();
                                    }
                                    
                                }
                            );
                        }
                        return null;
                    }   
                };
            }
        };
        timeThread.setOnSucceeded(new EventHandler<WorkerStateEvent>(){
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println("Done");        
            }
        }
        );
        timeThread.restart(); 
		//System.out.print(" \n"+"Output: \n");

		

		
	}
                
                
                    @FXML
    private void handleButtonAction(ActionEvent event)  {
       
    }
                
	
       @FXML
	private void holdBattlesAndWorkAfterBattles(){
			int count =1;
			while(count<WorldProperty.NumberOfCity+1)
			{
			if(CityList[count].BlueWarriorStation.size()>0 && CityList[count].RedWarriorStation.size()>0)
			{
				Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
				CityList[count].organizeBattle(clock);
				
				if(CityList[count].BlueWarriorStation.get(0).Dead == true)
				{
					if(CityList[count].LifeElement>0)
					{
						Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
						Assignment2.console+=(WorldProperty.PartyNames[CityList[count].RedWarriorStation.get(0).Party]+
								" "+WarriorType.WarriorNames[CityList[count].RedWarriorStation.get(0).type]+
								" "+CityList[count].RedWarriorStation.get(0).ProductionID+" earned "
								+CityList[count].LifeElement+" elements for his headquarter"+"\n");
					}
					if(CityList[count].PartyOfLastRoundWinner == 0)
					{
						if(CityList[count].Flag != 0)
						{
							Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
							int flag= CityList[count].payTribute();
                                                 raisedFlag(count,flag);
                                                 
						}
					}
					else
					{
						CityList[count].PartyOfLastRoundWinner = 0;
					}
				}
				else
				{
					if(CityList[count].RedWarriorStation.get(0).Dead == true)
					{
						if(CityList[count].LifeElement>0)
						{
							Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
							Assignment2.console+=(WorldProperty.PartyNames[CityList[count].BlueWarriorStation.get(0).Party]+
									" "+WarriorType.WarriorNames[CityList[count].BlueWarriorStation.get(0).type]+
									" "+CityList[count].BlueWarriorStation.get(0).ProductionID+" earned "
									+CityList[count].LifeElement+" elements for his headquarter\n");

						}
						if(CityList[count].PartyOfLastRoundWinner == 1)
						{
							if(CityList[count].Flag != 1)
							{
								Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
								int flag = CityList[count].payTribute();
                                                        raisedFlag(count, flag);
							}
						}
						else
						{
							CityList[count].PartyOfLastRoundWinner = 1;
						}

					}
					else
					{
						CityList[count].PartyOfLastRoundWinner = 3;
					}
				}
			}
			count++;
		}
		
		
		
		count =1;
		while(count< WorldProperty.NumberOfCity+1)
		{
			if(CityList[count].BlueWarriorStation.size()>0 && CityList[count].RedWarriorStation.size()>0)
			{
				
				if(CityList[count].RedWarriorStation.get(0).Dead == true)
				{
					((Headquarters) CityList[WorldProperty.NumberOfCity+1]).rewardWarrior(CityList[count].BlueWarriorStation.get(0),WorldProperty.rewardNumber);
				}
			}
			
			if(CityList[WorldProperty.NumberOfCity+1-count].BlueWarriorStation.size()>0 && CityList[WorldProperty.NumberOfCity+1-count].RedWarriorStation.size()>0)
			{
				if(CityList[WorldProperty.NumberOfCity+1-count].BlueWarriorStation.get(0).Dead == true)
				{
					((Headquarters) CityList[0]).rewardWarrior(CityList[WorldProperty.NumberOfCity+1-count].RedWarriorStation.get(0),WorldProperty.rewardNumber);
				}
			}
			++count;
		}
		
		
		for(int c=1;c<WorldProperty.NumberOfCity+1;c++)
		{
			if(CityList[c].BlueWarriorStation.size()>0 && CityList[c].RedWarriorStation.size()>0)
			{
				if(CityList[c].BlueWarriorStation.get(0).Dead == true)
				{
					if(CityList[c].LifeElement>0)
					{
						((Headquarters)CityList[WorldProperty.RED]).addLifeElement(CityList[c].popLifeElements());
					}

					CityList[c].removeWarrior(CityList[c].BlueWarriorStation.get(0));
                                   removePhoto((c*2)+1);
				}
				else
				{
					if(CityList[c].RedWarriorStation.get(0).Dead == true)
					{
						if(CityList[c].LifeElement>0)
						{

							((Headquarters)CityList[WorldProperty.NumberOfCity+1]).addLifeElement(CityList[c].popLifeElements());
						}

						CityList[c].removeWarrior(CityList[c].RedWarriorStation.get(0));
                                          removePhoto((c*2));
					}

				}
			}
			else
			{
				continue;
			}
		}
		
	}
	

	private void headquartersReportLifeElements()
	{
		Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
		Assignment2.console+=(CityList[0].LifeElement+ " elements in red headquarter\n");
		Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
		Assignment2.console+=(CityList[WorldProperty.NumberOfCity+1].LifeElement+ " elements in blue headquarter\n");
	}
	

	private void warriorsFetchLifeElementsFromCity(){
		for(int a= 1;a<WorldProperty.NumberOfCity+1;++a)
		{
			if(CityList[a].RedWarriorStation.size()==1)
			{
				if(CityList[a].BlueWarriorStation.size()==0)
				{
					Assignment2.console+=(Clock.customFormat(clock.getTime(),clock.getMinute()));
					Assignment2.console+=(WorldProperty.PartyNames[CityList[a].RedWarriorStation.get(0).Party]+" "+WarriorType.WarriorNames[CityList[a].RedWarriorStation.get(0).type]+" "+CityList[a].RedWarriorStation.get(0).ProductionID+" earned "+CityList[a].LifeElement+" elements for his headquarter\n");
					((Headquarters)CityList[WorldProperty.RED]).addLifeElement(CityList[a].popLifeElements());
				}
			}
			
			if(CityList[a].BlueWarriorStation.size()==1)
			{
				if(CityList[a].RedWarriorStation.size()==0)
				{
					Assignment2.console+=(Clock.customFormat(clock.getTime(),clock.getMinute()));
					Assignment2.console+=(WorldProperty.PartyNames[CityList[a].BlueWarriorStation.get(0).Party]+" "+WarriorType.WarriorNames[CityList[a].BlueWarriorStation.get(0).type]+" "+CityList[a].BlueWarriorStation.get(0).ProductionID+" earned "+CityList[a].LifeElement+" elements for his headquarter\n");
					((Headquarters)CityList[WorldProperty.NumberOfCity+1]).addLifeElement(CityList[a].popLifeElements());
				}
			}
		}
	}
	

	public void ProduceLifeElements()
	{
		for(int a=1; a< WorldProperty.NumberOfCity+1; ++a)
		{
			CityList[a].produceLifeElement();
		}
	}
	
	

	public void marchWarriors()
	{
		for(int a= WorldProperty.NumberOfCity+1;a!=0;--a)
		{
                    //last city has enemy
			if(CityList[a-1].RedWarriorStation.size()==1)
			{
                            //walk to the enemy headquarter
				if(a==WorldProperty.NumberOfCity+1)
				{
					((Headquarters)CityList[WorldProperty.NumberOfCity+1]).setNewArrival();
                                    movePhoto((a)*2);
				}
				
				Warrior temp =CityList[a-1].RedWarriorStation.get(0);
				temp.move();
				CityList[a-1].RedWarriorStation.remove(temp);
				CityList[a].RedWarriorStation.add(temp);
                                movePhoto((a-1)*2);
                                
                                System.out.println("a: "+(a-1)*2);
			}
			
		}
		
		for(int a=0;a<WorldProperty.NumberOfCity+1;++a)
		{
			if(CityList[a+1].BlueWarriorStation.size()==1)
			{
				if(a==0)
				{
					((Headquarters)CityList[0]).setNewArrival();
                                    System.out.println("1 moved !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println((clock.customFormat(clock.getTime(), clock.getMinute())));
                                    movePhoto((a)*2+1);
				}
				
				Warrior temp = CityList[a+1].BlueWarriorStation.get(0);
				temp.move();
				CityList[a+1].BlueWarriorStation.remove(temp);
				CityList[a].BlueWarriorStation.add(temp);
                            System.out.println("2 moved !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println((clock.customFormat(clock.getTime(), clock.getMinute())));
                            System.out.println("a:" +a);
                            System.out.println("(a+1)*2+1 :" +((a+1)*2+1));
                            movePhoto((a+1)*2+1);
			}
		}
		
		for(int a=0;a<WorldProperty.NumberOfCity+2; ++a)
		{
			if(a==0 && CityList[a].BlueWarriorStation.size()>0 && ((Headquarters)CityList[0]).checkNewArrival())
			{
				warriorReportMarch(CityList[a], CityList[a].BlueWarriorStation.get(CityList[a].BlueWarriorStation.size()-1));
				((Headquarters)CityList[0]).clearNewArrival();
			}
			else
			{
				if(a!=0 && a!=(WorldProperty.NumberOfCity+1))
				{
					if(CityList[a].RedWarriorStation.size()>0)
					{
						warriorReportMarch(CityList[a], CityList[a].RedWarriorStation.get(0));		
					}
				}
				
			}
			
			if(a== (WorldProperty.NumberOfCity+1) && CityList[a].RedWarriorStation.size()>0 && ((Headquarters)CityList[WorldProperty.NumberOfCity+1]).checkNewArrival())
			{
				warriorReportMarch(CityList[a], CityList[a].RedWarriorStation.get(CityList[a].RedWarriorStation.size()-1));
				((Headquarters)CityList[WorldProperty.NumberOfCity+1]).clearNewArrival();
			}
			else
			{
				if(a != 0&& a!=(WorldProperty.NumberOfCity+1))
				{
					if(CityList[a].BlueWarriorStation.size()>0)
					{
							warriorReportMarch(CityList[a], CityList[a].BlueWarriorStation.get(0));			
					}
				}
				
			}

			
			
			
		}
	}
	

	private void warriorReportMarch(City city, Warrior warrior)
	{
		Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
		if(city.CityID ==0 || city.CityID== WorldProperty.NumberOfCity+1)
		{
			if(city.CityID==0)
			{
				Assignment2.console+=(WorldProperty.PartyNames[warrior.Party]+ " "+ WarriorType.WarriorNames[warrior.type]+" "+ warrior.ProductionID+ " reached "+ WorldProperty.PartyNames[0]+" headquarter with "+warrior.HP+ " elements and force "+ warrior.AttackValue+"\n");
			}
			else
			{
				Assignment2.console+=(WorldProperty.PartyNames[warrior.Party]+ " "+ WarriorType.WarriorNames[warrior.type]+" "+ warrior.ProductionID+ " reached "+ WorldProperty.PartyNames[1]+" headquarter with "+warrior.HP+ " elements and force "+ warrior.AttackValue+"\n");
			}
			
			}
		else
		{
			Assignment2.console+=(WorldProperty.PartyNames[warrior.Party]+" " + WarriorType.WarriorNames[warrior.type]+" "+warrior.ProductionID+" marched to city "+city.CityID+ " with "+warrior.HP+" elements and force "+ warrior.AttackValue+"\n");
		}
	}
}
        

