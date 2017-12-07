//package EnigmaMachine;

public class Rotor {

	private int rotorNumber;//rotor identification
	private int rotorStartNum;//starting position
	private int rotorSettings;//settings for rotor starting position 

	// Constructor
	public Rotor()
	{
		this.rotorSettings = 0;
		this.rotorNumber = 0;
	}
	
	public int changeLetter(int letter, Rotor rotor1, Rotor rotor2, Rotor rotor3) // ASCII A = 65, Z = 90
	{
		System.out.println("Rotor Number: " + rotorNumber);
		System.out.println("Rotor setting: " + rotorSettings);
		letter = letter + rotorSettings;
		System.out.println("Letter + rotorSettings: " + letter);
		if(letter > 90)
		{
			letter = 65 + (letter - 90); // If letter > 90, which is not a letter anymore, start from A again
			System.out.println("Letter if bigger than 90: " + letter);
		}
		//shift(rotor1, rotor2, rotor3);
		System.out.println();
		return letter;
	}
	public int changeLetterDecrypt(int letter, Rotor rotor1, Rotor rotor2, Rotor rotor3) // ASCII A = 65, Z = 90
	{
		System.out.println("Rotor setting: " + rotorSettings);
		letter = letter - rotorSettings;
		System.out.println("Letter - rotorSettings: " + letter);
		if(letter < 65)
		{
			// 
			letter = 90 - (65 - letter); // If letter > 90, which is not a letter anymore, start from A again
			System.out.println("Letter if bigger than 90: " + letter);
		}
		//shift(rotor1,rotor2, rotor3);
		System.out.println();
		return letter;
	}
	
	public void shift (Rotor rotor1, Rotor rotor2, Rotor rotor3)
	{
		System.out.println("Rotor Number: " + rotorNumber);

		rotor1.setSettings(rotor1.getSettings() + 1);
		if (rotor1.getSettings() > 26)
		{
			rotor2.setSettings(rotor2.getSettings()+1);
			rotor1.setSettings(1);
			System.out.println("ROTOR SETTINGS CHANGED: " + rotor1.getSettings());
			if (rotor2.getSettings() > 26 )
			{
				rotor2.setSettings(1);
				rotor3.setSettings(rotor3.getSettings()+1);
			}
		}	
	}
	
	// Getters and Setters
	public Rotor(int rotorSettings, int rotorNumber) {
		this.rotorSettings = rotorSettings;
		this.rotorNumber = rotorNumber;
	}

	public int getSettings() {
		return rotorSettings;
	}

	public void setSettings(int rotorSettings) {
		this.rotorSettings = rotorSettings;
	}
	
}
