package World;
import java.util.ArrayList;

import Warriors.Warrior;
import assignment2.Assignment2;

public class City {
	public int CityID;
	public int LifeElement;
	public ArrayList<Warrior> RedWarriorStation;
	public ArrayList<Warrior> BlueWarriorStation;
	public int Flag;
	public int PartyOfLastRoundWinner;
	public boolean Status_AfterBattle;
	
	public City(int id){
		CityID = id;
		LifeElement = 0;
		RedWarriorStation = new ArrayList<Warrior>();
		BlueWarriorStation = new ArrayList<Warrior>();
		PartyOfLastRoundWinner = 3;
		Flag = 3;
	}
	
	public void produceLifeElement()
	{

		LifeElement += 10;

	}
	
	public int popLifeElements()
	{
		int lifeElement = LifeElement;
		LifeElement = 0;
		return lifeElement;
	}
	
	public boolean addWarrior(Warrior warrior)
	{

		if(warrior.Party == WorldProperty.RED)
		{
			RedWarriorStation.add(warrior);
			return true;
		}
		if(warrior.Party == WorldProperty.BLUE)
		{
			BlueWarriorStation.add(warrior);
			return true;
		}
		return false;
		
	}
	
	public boolean removeWarrior(Warrior warrior)
	{
		if(warrior.Party == WorldProperty.RED)
		{
			RedWarriorStation.remove(RedWarriorStation.indexOf(warrior));
			return true;
		}
		if(warrior.Party == WorldProperty.BLUE)
		{
			BlueWarriorStation.remove(BlueWarriorStation.indexOf(warrior));
			return true;
		}
		return false;
	}
	

	public boolean organizeBattle(Clock clock){
		if(Flag == 0)
		{
			if(RedWarriorStation.get(0).attack(BlueWarriorStation.get(0),clock))
			{
				return true;
			}	
		}
		else
		{
		
			if(Flag == 1)
			{
				if(BlueWarriorStation.get(0).attack(RedWarriorStation.get(0),clock))
				{
					return true;
				}
			}
			else
			{
				if(CityID%2 != 0)
				{
					if(RedWarriorStation.get(0).attack(BlueWarriorStation.get(0),clock))
					{
						return true;						
					}
				}
				else
				{
					if(CityID%2 == 0)
					{
						if(BlueWarriorStation.get(0).attack(RedWarriorStation.get(0),clock))
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public int payTribute()
	{
		Flag = PartyOfLastRoundWinner;
		Assignment2.console+=(WorldProperty.PartyNames[Flag]+" flag raised in city "+CityID+"\n");
              return Flag;
	}
}
