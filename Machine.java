
public class Machine
{
	private int[] rotorSetting = new int[3]; // Rotor settings
	// private int[] rotorType = new int[3]; // Rotor type from 1 to 5
	// ringSettings ???
	// messageSettings ???
	private String message; // Message  that needs to be encrypted
	private char code; // Encrypt or Decrypt
	
	// Constructor
	public Machine()
	{
		for(int i = 0; i < 3; i++)
		{
			this.rotorSetting[i] = 0;
			//this.rotorType[i] = 0;
		}
		// this.ringSettings;
		// this.messageSettings;
		this.message = "empty";
		this.code = ' ';
	}

	public Machine(int[] rotorSetting, String message, char code) {
		super();
		this.rotorSetting = rotorSetting;
		// this.rotorType = rotorType;
		// this.ringSettings = ringSettings;
		// this.messageSettings = messageSettings;
		this.message = message;
		this.code = code;
	}
	
	/*
	 * encrypt()
	 * @params
	 * @return message
	 * Return encrypted message
	 */
	public String encrypt()
	{
		// Initialize rotors
		Rotors rotor1 = new Rotors(rotorSetting[0], 1/*, startNumber??, rotorSettings?? */);
		Rotors rotor2 = new Rotors(rotorSetting[1], 2);
		Rotors rotor3 = new Rotors(rotorSetting[2], 3);
		
		// Shift letters
		int messageLength = message.length(); // Get the length of the message
		int letter; // ASCII value of the letter
		for(int i = 0; i < messageLength - 1; i++)
		{
			letter = (int)message[i]; // Change the letter to ASCII value
			letter = rotor1.changeLetter(letter);
			letter = rotor2.changeLetter(letter);
			letter = rotor3.changeLetter(letter);
			// letter = reflector(letter);
			letter = rotor3.changeLetter(letter);
			letter = rotor2.changeLetter(letter);
			letter = rotor1.changeLetter(letter);
		}
		char charLetter = (char)letter; // Change ASCII value(int) to char
		// Append charLetter to new message
		return message; // Return encrypted message
	}
	
	
	// Getters and Setters
	public int[] getRotorSetting() {
		return rotorSetting;
	}

	public void setRotorSetting(int[] rotorSetting) {
		this.rotorSetting = rotorSetting;
	}

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}
	
	
	
}
