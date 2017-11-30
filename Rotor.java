package EnigmaMachine;

public class Rotor {

	private int rotorNumber;//rotor identification
	private int rotorStartNum;//starting position
	private int rotorSettings;//settings for rotor starting position 
	private int shiftCount = 0;
	private int startNumber = 0;
	//private Rotor rotor2;
	//private Rotor rotor3;
	
	
	// Constructor
	public Rotor()
	{
		this.rotorSettings = 0;
		this.rotorNumber = 0;
	}
	
	public int changeLetter(int letter, Rotor rotor2, Rotor rotor3) // ASCII A = 65, Z = 90
	{
		letter = letter + rotorSettings;
		if(letter > 90)
		{
			letter = 65 + (letter - 90); // If letter > 90, which is not a letter anymore, start from A again
		}
		shift(rotor2, rotor3);
		return letter;
	}
	
	public void shift (Rotor rotor2, Rotor rotor3)
	{
	rotor2.setSettings(5);  //for debugging purposes
		if(rotorNumber == 1)
		{
			rotorSettings++;
			startNumber++;
			if (startNumber >= 26)
			{
				rotor2.setSettings(rotor2.getSettings()+1);
				if (rotor2.getStartNumber() >= 26 )
				{
					rotor3.setSettings(rotor3.getSettings()+1);
				}
			}	
		}	
	}
	
	// Getters and Setters
	public Rotor(int rotorSettings, int rotorNumber) {
		super();
		this.rotorSettings = rotorSettings;
		this.rotorNumber = rotorNumber;
	}

	public int getSettings() {
		return rotorSettings;
	}

	public void setSettings(int rotorSettings) {
		this.rotorSettings = rotorSettings;
	}
	public int getStartNumber()
	{
		return startNumber;
	}
	
}
