package Warriors;

public class ClassAttack {

	public int attackValue;
	public boolean isBeatBack;
	public Warrior attacker;
	public Warrior defender;
	
	public ClassAttack(Warrior attacker, Warrior defender, int attackValue, boolean isBeatBack)
	{
		this.attackValue = attackValue;
		this.attacker = attacker;
		this.defender = defender;
		this.isBeatBack = isBeatBack;
		
	}
}