package World;
import Warriors.WarriorType;

public class WorldProperty {

	public static int InitLifeElements;
	public static int NumberOfCity;
	public static int MaxMinutes;
	public static final int RED = 0;
	public static final int BLUE = 1;
	public static final String[] PartyNames = {"red","blue"};
	public static final int [] RedProductionOrder = {WarriorType.ICEMAN,WarriorType.LION,WarriorType.WOLF,WarriorType.NINJA,WarriorType.DRAGON};
	public static final int [] BlueProductionOrder = {WarriorType.LION,WarriorType.DRAGON,WarriorType.NINJA,WarriorType.ICEMAN,WarriorType.WOLF};
	public static final int rewardNumber = 8;
	
	public WorldProperty()
	{
		
	}
}
