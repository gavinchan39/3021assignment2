package World;

import java.util.Scanner;

import Warriors.Warrior;
import Warriors.WarriorType;

public class World {

	public static Clock clock =new Clock();
	public City[] CityList;
	

	
	public void runGame(){
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input: ");
		WorldProperty.InitLifeElements = scanner.nextInt();
		WorldProperty.NumberOfCity = scanner.nextInt();
		WorldProperty.MaxMinutes = scanner.nextInt();
		
		for(int a= 0;a<5;++a)
		{
			WarriorType.HP_LIST[a] = scanner.nextInt();
		}
		for(int a= 0;a<5;++a)
		{
			WarriorType.ATTACK_LIST[a] = scanner.nextInt();
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
		

		System.out.print(" \n"+"Output: \n");

		
		do{
			int minutes = clock.getMinute();
			

			if(minutes == 0)
			{

				if(((Headquarters)CityList[0]).tryToProduceWarrior())
				{
					System.out.print(clock.customFormat(clock.getTime(), clock.getMinute()));
					System.out.println(WorldProperty.PartyNames[0]+" "
					+WarriorType.WarriorNames[((Headquarters) CityList[0]).RedWarriorStation.get((((Headquarters) CityList[0]).RedWarriorStation).size()-1).type]+
					" "+((Headquarters) CityList[0]).RedWarriorStation.get((((Headquarters) CityList[0]).RedWarriorStation).size()-1).ProductionID+" born");
				}

				if(((Headquarters)CityList[WorldProperty.NumberOfCity+1]).tryToProduceWarrior())
				{
					System.out.print(clock.customFormat(clock.getTime(), clock.getMinute()));
					System.out.println(WorldProperty.PartyNames[1]+" "
					+WarriorType.WarriorNames[((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation.get((((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation).size()-1).type]+
					" "+((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation.get((((Headquarters) CityList[WorldProperty.NumberOfCity+1]).BlueWarriorStation).size()-1).ProductionID+" born");
				}
			}
			
			
			if(minutes == 10)
			{
				marchWarriors();
				if(((Headquarters)CityList[0]).checkOccupied())
				{
					System.out.print(clock.customFormat(clock.getTime(), clock.getMinute()));
					System.out.println("red headquarter was taken");
			
				}
				if(((Headquarters)CityList[WorldProperty.NumberOfCity+1]).checkOccupied())
				{
					System.out.print(clock.customFormat(clock.getTime(), clock.getMinute()));
					System.out.println("blue headquarter was taken");
			
				}
				
			}
			
			
			if(minutes == 20)
			{

				ProduceLifeElements();
				
			}
			
			
			if(minutes == 30)
			{

				warriorsFetchLifeElementsFromCity();
				

				
			}
			
			
			if(minutes == 40)
			{

				holdBattlesAndWorkAfterBattles();

			}
			
			
			if(minutes == 50)
			{

				headquartersReportLifeElements();
			}

			clock.increase();
		}while(Integer.parseInt(clock.getTime())*60+clock.getMinute()<=WorldProperty.MaxMinutes &&
				!((Headquarters)CityList[0]).checkOccupied() && !((Headquarters)CityList[WorldProperty.NumberOfCity+1]).checkOccupied());
		
	}
	
	private void holdBattlesAndWorkAfterBattles(){
			int count =1;
			while(count<WorldProperty.NumberOfCity+1)
			{
			if(CityList[count].BlueWarriorStation.size()>0 && CityList[count].RedWarriorStation.size()>0)
			{
				System.out.print(Clock.customFormat(clock.getTime(), clock.getMinute()));
				CityList[count].organizeBattle(clock);
				
				if(CityList[count].BlueWarriorStation.get(0).Dead == true)
				{
					if(CityList[count].LifeElement>0)
					{
						System.out.print(Clock.customFormat(clock.getTime(), clock.getMinute()));
						System.out.println(WorldProperty.PartyNames[CityList[count].RedWarriorStation.get(0).Party]+
								" "+WarriorType.WarriorNames[CityList[count].RedWarriorStation.get(0).type]+
								" "+CityList[count].RedWarriorStation.get(0).ProductionID+" earned "
								+CityList[count].LifeElement+" elements for his headquarter");
					}
					if(CityList[count].PartyOfLastRoundWinner == 0)
					{
						if(CityList[count].Flag != 0)
						{
							System.out.print(Clock.customFormat(clock.getTime(), clock.getMinute()));
							CityList[count].payTribute();
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
							System.out.print(Clock.customFormat(clock.getTime(), clock.getMinute()));
							System.out.println(WorldProperty.PartyNames[CityList[count].BlueWarriorStation.get(0).Party]+
									" "+WarriorType.WarriorNames[CityList[count].BlueWarriorStation.get(0).type]+
									" "+CityList[count].BlueWarriorStation.get(0).ProductionID+" earned "
									+CityList[count].LifeElement+" elements for his headquarter");

						}
						if(CityList[count].PartyOfLastRoundWinner == 1)
						{
							if(CityList[count].Flag != 1)
							{
								System.out.print(Clock.customFormat(clock.getTime(), clock.getMinute()));
								CityList[count].payTribute();
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
		System.out.print(Clock.customFormat(clock.getTime(), clock.getMinute()));
		System.out.println(CityList[0].LifeElement+ " elements in red headquarter");
		System.out.print(Clock.customFormat(clock.getTime(), clock.getMinute()));
		System.out.println(CityList[WorldProperty.NumberOfCity+1].LifeElement+ " elements in blue headquarter");
	}
	

	private void warriorsFetchLifeElementsFromCity(){
		for(int a= 1;a<WorldProperty.NumberOfCity+1;++a)
		{
			if(CityList[a].RedWarriorStation.size()==1)
			{
				if(CityList[a].BlueWarriorStation.size()==0)
				{
					System.out.print(Clock.customFormat(clock.getTime(),clock.getMinute()));
					System.out.println(WorldProperty.PartyNames[CityList[a].RedWarriorStation.get(0).Party]+" "+WarriorType.WarriorNames[CityList[a].RedWarriorStation.get(0).type]+" "+CityList[a].RedWarriorStation.get(0).ProductionID+" earned "+CityList[a].LifeElement+" elements for his headquarter");
					((Headquarters)CityList[WorldProperty.RED]).addLifeElement(CityList[a].popLifeElements());
				}
			}
			
			if(CityList[a].BlueWarriorStation.size()==1)
			{
				if(CityList[a].RedWarriorStation.size()==0)
				{
					System.out.print(Clock.customFormat(clock.getTime(),clock.getMinute()));
					System.out.println(WorldProperty.PartyNames[CityList[a].BlueWarriorStation.get(0).Party]+" "+WarriorType.WarriorNames[CityList[a].BlueWarriorStation.get(0).type]+" "+CityList[a].BlueWarriorStation.get(0).ProductionID+" earned "+CityList[a].LifeElement+" elements for his headquarter");
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
			if(CityList[a-1].RedWarriorStation.size()==1)
			{
				if(a==WorldProperty.NumberOfCity+1)
				{
					((Headquarters)CityList[WorldProperty.NumberOfCity+1]).setNewArrival();
				}
				
				Warrior temp =CityList[a-1].RedWarriorStation.get(0);
				temp.move();
				CityList[a-1].RedWarriorStation.remove(temp);
				CityList[a].RedWarriorStation.add(temp);
			}
			
		}
		
		for(int a=0;a<WorldProperty.NumberOfCity+1;++a)
		{
			if(CityList[a+1].BlueWarriorStation.size()==1)
			{
				if(a==0)
				{
					((Headquarters)CityList[0]).setNewArrival();
				}
				
				Warrior temp = CityList[a+1].BlueWarriorStation.get(0);
				temp.move();
				CityList[a+1].BlueWarriorStation.remove(temp);
				CityList[a].BlueWarriorStation.add(temp);
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
		System.out.print(Clock.customFormat(clock.getTime(), clock.getMinute()));
		if(city.CityID ==0 || city.CityID== WorldProperty.NumberOfCity+1)
		{
			if(city.CityID==0)
			{
				System.out.println(WorldProperty.PartyNames[warrior.Party]+ " "+ WarriorType.WarriorNames[warrior.type]+" "+ warrior.ProductionID+ " reached "+ WorldProperty.PartyNames[0]+" headquarter with "+warrior.HP+ " elements and force "+ warrior.AttackValue);
			}
			else
			{
				System.out.println(WorldProperty.PartyNames[warrior.Party]+ " "+ WarriorType.WarriorNames[warrior.type]+" "+ warrior.ProductionID+ " reached "+ WorldProperty.PartyNames[1]+" headquarter with "+warrior.HP+ " elements and force "+ warrior.AttackValue);
			}
			
			}
		else
		{
			System.out.println(WorldProperty.PartyNames[warrior.Party]+" " + WarriorType.WarriorNames[warrior.type]+" "+warrior.ProductionID+" marched to city "+city.CityID+ " with "+warrior.HP+" elements and force "+ warrior.AttackValue);
		}
	}
}
