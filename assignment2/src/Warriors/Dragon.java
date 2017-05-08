package Warriors;

import World.WorldProperty;
import World.Clock;
public class Dragon extends Warrior {

	public Dragon(int type, int party,int productionID)
	{
		super(type,  party, productionID);
	}
	
	public void cheers()
	{
		System.out.println(WorldProperty.PartyNames[Party]+ " dragon " + ProductionID+" yelled in city "+Location);
	}
	
	public boolean attack(Warrior warrior, Clock clock)
	{
		boolean temp = super.attack(warrior, clock);
		if(!Dead)
		{
			System.out.print(Clock.customFormat(clock.getTime(), clock.getMinute()));
			cheers();
		}
		return temp;
	}
	
}
