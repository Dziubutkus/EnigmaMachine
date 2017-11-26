
public class Rotors {
	private int rotorSetting;
	private int rotorNumber;
	
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
	
	/*
	 *  I think shift and changeLetter should be in machine class
	 */
	public void shift()
	{
		if(rotorNumber == 1)
		{
			rotorSetting += 1;
			if(rotorSetting > 26)
			{
				rotorSetting = 1;
				// Set rotor2 setting + 1 and check rotor3 setting
			}
		}
		else if(rotorNumber == 2)
		{
			
		}
		else if(rotorNumber == 3)
		{
			
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
