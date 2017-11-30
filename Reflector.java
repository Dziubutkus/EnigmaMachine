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
			wheelLettering = "YRUQSPXNOZWVT";
		}
		else if (type == 'C')
		{
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
		System.out.println(letter);
		int reflectedLetter = ' ';
		
		if (letter-65 < 13) //first half of alphabet
		{
			reflectedLetter = wheelLettering.charAt(letter-65);
		}
		else if (letter-65 >= 13) //second half of alphabet
		{
			reflectedLetter = 65 + wheelLettering.charAt(indexLetter(letter-65));
		}
		return reflectedLetter;
	}
	
	public int indexLetter(int letter)
	{
		boolean found = false;
		int index = 0;
		while (index < 13 && !found)
		{
			if (letter == ((int)wheelLettering.charAt(index)-65))
			{
				found = true;
			}
			if (!found)
			{
				index++;
			}
		}
		return index;
	}
	
	//getters and setters
	
}
