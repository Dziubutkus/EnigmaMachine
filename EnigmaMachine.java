//package EnigmaMachine;
import java.util.Scanner;

public class EnigmaMachine
{

	public static void main( String[ ] args )
	{
		Scanner input = new Scanner (System.in);
		
		System.out.println ( "Are you encyrpting or decrypting?" );
		int type = -1;  //whether encypting a message or decrypting a message
        char typeChar;
        int[] rotorSettings = new int[3];
		char loopCheck = 'n';
        do
        {
            typeChar = input.next().toUpperCase().charAt(0);
            if (typeChar == 'E')
            {
                type = 0;  //encrypting
                loopCheck = 'y';
            }
		    else if (typeChar == 'D')
		    {
		        type = 1;  //decrypting
                loopCheck = 'y';
            }
		    else
		    {
		        System.out.println("Invalid input. Try Again.");
		    }
		} while (loopCheck == 'n');
		

        //encryption and decryption will be inputted differently
        //decryption will have settings
        //encryptions will strictly be a message (no parsing for encryption needed)
        String junk;
	System.out.println("Which rotors do you want to use? (Input 3 Numbers with no spaces inbetween)");
	String rotorNum = input.next();
	System.out.println("What rotor settings do you want to use?");
	for(int i = 1; i < 4; i++)
	{
		System.out.println("Rotor " + i + ":");
		rotorSettings[i-1] = input.nextInt();
	}
	System.out.println("What reflector do you want to use?");
        char reflectorType = input.next().toUpperCase().charAt(0);
	System.out.println("What message to you want to encrypt?");
        String encryption;
        junk = input.nextLine(); //picks up end line output on last line
        encryption = input.nextLine().toUpperCase();
        Machine enigmaMachine = new Machine(reflectorType, encryption, typeChar, rotorSettings);
        System.out.println(enigmaMachine.encrypt());  //should return encrypted message
        
    }
	
    /*
     *
     * Reflector, WheelSetting, Ring Setting, Start Position, Wheel Order,
     * message settings, Message
     */
	public static String[] parseDecryption (String decryption)
	{
        String deliminator = "[,]+";  //deliminator is a comma (for now)
        String[] args = decryption.split(deliminator);
        System.out.println(args.length);  //for debugging purposes


		return args;
	}
	
}
