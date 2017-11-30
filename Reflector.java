//package EnigmaMachine;

/*
* A reflector is basically a rotor that doesn't move.
* The reflector makes it so that the sequence that came from the first
* three rotors doesn't translate back to the message
*/
public class Reflector
{
	//member variables
	private char type;  //Will be either B or C
	private String wheelLettering;
		//we will have two reflector types (B and C) they will be hard coded in
		//M3B:
				//ABCDEFGHIJKLM
				//YRUQSPXNOZWVT
		//M3C:
				//ABCDEFGHIJKLM
				//VPOYRZXWTUQSN
	//Constructor
	//We will have two different reflectors to choose from (B or C)
	Reflector(char type)
	{
		if (type == 'B')
		{
					//ABCDEFGHIJKLM
			wheelLettering = "YRUQSPXNOZWVT";
		}
		else if (type == 'C')
		{
			                //ABCDEFGHIJKLM
			wheelLettering = "VPOYRZXWTUQSN";
		}
		else
		{
			wheelLettering = "null";
		}
	}
	
	//member methods
	public int changeLetter(int letter) // ASCII A = 65, Z = 90
	{
		int reflectedLetter = ' ';
		
		if (letter <= 13) //first half of alphabet
		{
			reflectedLetter = wheelLettering.charAt(letter);
		}
		else if (letter > 13) //second half of alphabet
		{
			reflectedLetter = 65 + wheelLettering.charAt(indexLetter(letter));
		}
		return reflectedLetter;
	}
	
	public int indexLetter(int letter)
	{
		boolean found = false;
		int index = 0;
		while (index < 13 && !found)
		{
			if ((char)letter == wheelLettering.charAt(index))
			{
				found = true;
			}
		}
		return index;
	}
	
	//getters and setters
	
}
