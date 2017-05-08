package World;

import Warriors.Dragon;
import Warriors.Iceman;
import Warriors.Lion;
import Warriors.Ninja;
import Warriors.Warrior;
import Warriors.WarriorType;
import Warriors.Wolf;

public class Headquarters extends City{
	private int[] ProductionOrder;
	private int WarriorIndex;
	private int ProductionID;
	private int Party;
	private boolean HasNewArrival;
	
	public Headquarters(int[] ProductionOrder, int cityID, int Party, int flag)
	{
		super(cityID);
		this.ProductionOrder = ProductionOrder;
		WarriorIndex =0;
		ProductionID=1;
		this.Party = Party;
		HasNewArrival = false;
		
	}
	
	public void addLifeElement(int LifeElement)
	{
		this.LifeElement += LifeElement;
	}
	
	public void increaseLifeElement(int LifeElement)
	{
		this.LifeElement +=LifeElement;
	}
	
	public void showOrder()
	{
		for(int a=0; a< ProductionOrder.length;++a)
		{
			System.out.print(ProductionOrder[a]+" ");
		}
	}
	
	public void setNewArrival(){
		HasNewArrival = true;
	}
	
	public void clearNewArrival(){
		HasNewArrival = false;
	}
	
	public Warrior getNewArrivedWarrior()
	{
		if(Party == WorldProperty.RED)
		{
			return BlueWarriorStation.get(BlueWarriorStation.size()-1);
		}
		else
		{
			if(Party == WorldProperty.BLUE)
			{
			return RedWarriorStation.get(RedWarriorStation.size()-1);
			}
		}
		return null;
	}
	
	public boolean checkNewArrival(){
		return HasNewArrival;
	}
	
	public boolean rewardWarrior(Warrior warrior, int reward)
	{

		if(LifeElement >= reward)
		{
			warrior.HP +=reward;

			LifeElement = LifeElement - reward;

			return true;
		}
		else
		{
			return false;
		}
			
	}
	
	public void rewardAmy(){
		
	}
	
	public boolean tryToProduceWarrior()
	{
		if(produceWarrior(ProductionOrder[WarriorIndex]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
        
       public boolean tryToProduceWarrior(int index)
	{
		if(produceWarrior(index))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean produceWarrior(int index)
	{
		if(LifeElement >= WarriorType.HP_LIST[index])
		{
			LifeElement -= WarriorType.HP_LIST[index];
			Warrior warrior =null;
			if(index == WarriorType.DRAGON)
			{
				warrior = new Dragon(index, Party,ProductionID);
			}
			if(index == WarriorType.NINJA)
			{
				warrior = new Ninja(index, Party,ProductionID);
			}
			if(index == WarriorType.ICEMAN)
			{
				warrior = new Iceman(index, Party,ProductionID);
			}
			if(index == WarriorType.LION)
			{
				warrior = new Lion(index, Party,ProductionID);
			}
			if(index == WarriorType.WOLF)
			{
				warrior = new Wolf(index, Party,ProductionID);
			}

			
			addWarrior(warrior);
			ProductionID++;
			WarriorIndex++;
			WarriorIndex%= 5;
			return true;				
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkOccupied()
	{
		if(Party == WorldProperty.RED && BlueWarriorStation.size()>=2 || Party == WorldProperty.BLUE && RedWarriorStation.size()>=2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
