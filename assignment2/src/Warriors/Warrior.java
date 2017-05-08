package Warriors;

import World.Clock;
import World.WorldProperty;
import assignment2.Assignment2;

public abstract class Warrior {
	public int HP;
	public int AttackValue;
	public int type;
	public int Party;
	public boolean Dead;
	public int ProductionID;
	public int NumberOfKilledWarrior;
	public int MovedDistance;
	public String WarriorNameclassAttackrd;
	public int Location;
	
	public Warrior(int type, int party,int productionID)
	{
		HP= WarriorType.HP_LIST[type];
		AttackValue = WarriorType.ATTACK_LIST[type];
		this.type = type;
		Party = party;
		Dead =false;
		ProductionID = productionID;
		NumberOfKilledWarrior= 0;
		MovedDistance = 0;
		WarriorNameclassAttackrd = WarriorType.WarriorNames[type];
		if(Party == 0)
		{
			Location = 0;
		}
		else
		{
			Location = WorldProperty.NumberOfCity+1;
		}
	}
	
	public boolean move()
	{
		if(!Dead)
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

			return true;
		}
		else
		{
			return false;
		}	
	}
	
	public boolean attack(Warrior x,Clock clock){
		Assignment2.console+=(WorldProperty.PartyNames[Party]+" "+WarriorType.WarriorNames[type]+" "+ProductionID+" attacked "+WorldProperty.PartyNames[x.Party]
				+" "+WarriorType.WarriorNames[x.type]+" "+x.ProductionID+" in city "+Location+" with "+HP+" elements and force "+AttackValue+"\n");
		ClassAttack classAttack = new ClassAttack(this,x,AttackValue,false);
		x.getAttack(classAttack,clock);
		
		return true;
	}
	
	public boolean getDeathAnnounce(ClassDeathAnnounce DeathAnnounce ,Clock clock)
	{
		Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
		Assignment2.console+=(WorldProperty.PartyNames[DeathAnnounce.warrior.Party]+ " "+WarriorType.WarriorNames[DeathAnnounce.warrior.type]+
				" "+ DeathAnnounce.warrior.ProductionID+ " was killed in city "+Location+"\n");
		if(DeathAnnounce.warrior.type == WarriorType.LION)
		{
			HP+=DeathAnnounce.HPBeforeDeath;
		}
		
		return true;
	}
	
	protected void tryToChangeFlag(){
		
	}
	
	public boolean getAttack(ClassAttack cAttack,Clock clock){
		if(cAttack.attackValue>=this.HP)
		{
			ClassDeathAnnounce cda = new ClassDeathAnnounce(this,HP);
			removeHP(HP);
			Dead = true;
			if(cAttack.isBeatBack == false)
			{
				cAttack.attacker.NumberOfKilledWarrior++;
			}
				

			
			if(cAttack.attacker.type == WarriorType.WOLF && cAttack.attacker.NumberOfKilledWarrior%2 == 0 && cAttack.isBeatBack == false)
			{
					cAttack.attacker.HP*=2;
					cAttack.attacker.AttackValue*=2;
			}
			cAttack.attacker.getDeathAnnounce(cda,clock);
			return true;
		}
		else
		{
			removeHP(cAttack.attackValue);
			if(cAttack.defender.type == WarriorType.NINJA)
			{
				return false;
			}
			if(cAttack.isBeatBack == false)
			{
				ClassAttack classAttack = new ClassAttack(this,cAttack.attacker,AttackValue/2,true);
				Assignment2.console+=(Clock.customFormat(clock.getTime(), clock.getMinute()));
				Assignment2.console+=(WorldProperty.PartyNames[Party]+" "+WarriorType.WarriorNames[type]+" "+ProductionID+" fought back against "
				+WorldProperty.PartyNames[cAttack.attacker.Party]+" "+WarriorType.WarriorNames[cAttack.attacker.type]+" "+cAttack.attacker.ProductionID
				+" in city "+Location+"\n");
				
				if(cAttack.attacker.getAttack(classAttack,clock))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		
		}
	}
	
	public boolean removeHP(int harm)
	{
		if(HP<0)
		{
			return false;
		}
		else
		{	
			if((HP-harm)>0)
			{
				HP = HP-harm;
			}
			else
			{
				HP=0;
				Dead = true;
				new ClassDeathAnnounce(this, HP);
			}
			return true;
		}
		
	}
	
	public boolean die()
	{
		return Dead;
	}
}
