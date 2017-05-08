package Warriors;

public class Iceman extends Warrior {

	public Iceman(int type, int party,int productionID)
	{
		super(type,  party, productionID);
	}

	public boolean move()
	{
		MovedDistance++;
		if(Party ==0)
		{
			Location++;
		}
		else
		{
			Location--;
		}
		
		if( MovedDistance%2 ==0)
		{
			HP = HP-9;
			if(HP<=0)
			{
				HP = 1;
			}
			AttackValue = AttackValue +20;
			
			
		}
		
		return true;
	}

}

