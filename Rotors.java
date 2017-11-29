
public class Rotors {

	private int rotorNum;//rotor identification
	private int roterStartNum;//starting position
	private int roterSettings;//settings for rotor starting position 
	private int shiftCount = 0;
	private int startNumber = 0;
	
	
	// Constructor
	public Rotors()
	{
		this.rotorSetting = 0;
		this.rotorNumber = 0;
	}
	
	public int changeLetter(int letter) // ASCII A = 65, Z = 90
	{
		letter = letter + rotorSetting;
		if(letter > 90)
		{
			letter = 65 + (letter - 90); // If letter > 90, which is not a letter anymore, start from A again
		}
		shift();
		return letter;
	}
	
	static void shift ()
	{
		
		if(rotorNumber == 1)
		{
			rotorSettings++;
			startNumber++;
			if (startNumber >= 26)
			{
				rotor2.setSetting(rotor2.getSetting()+1);
				if (rotor2.getStartNumber() >= 26 )
				{
					rotor3.setSetting(rotor3.getSetting()+1);
				}
			}	
		}	
	}
	
	// Getters and Setters
	public Rotors(int rotorSetting, int rotorNumber) {
		super();
		this.rotorSetting = rotorSetting;
		this.rotorNumber = rotorNumber;
	}

	public int getRotorSetting() {
		return rotorSetting;
	}

	public void setRotorSetting(int rotorSetting) {
		this.rotorSetting = rotorSetting;
	}
	
}
