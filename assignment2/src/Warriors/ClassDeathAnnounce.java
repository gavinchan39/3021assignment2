package Warriors;

public class ClassDeathAnnounce {

	int HPBeforeDeath;
	Warrior warrior; 
	
	public ClassDeathAnnounce(Warrior warrior, int HPBeforeDeath)
	{
		this.warrior = warrior;
		this.HPBeforeDeath = HPBeforeDeath;
	}
}
