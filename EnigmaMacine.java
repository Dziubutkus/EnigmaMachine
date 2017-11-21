import java.util.Scanner;

public class EnigmaMacine
{

	public static void main( String[ ] args )
	{
		Scanner input = new Scanner (System.in);
		
		System.out.println ( "Are you encyrpting or decrypting?" );
		int type = -1;  //whether encypting a message or decrypting a message
        char typeChar;
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
        if (type == 0)
        {
            //encryption
            System.out.println("What message to you want to encrypt?");
            String encryption;
            junk = input.nextLine(); //picks up end line output on last line
            encryption = input.nextLine();
            System.out.println(encryption);
            //parse encryption
        }
        else
        {
            //decryption
            System.out.println("What code do you want decrypted?");
            junk = input.nextLine();
            String decryption = input.nextLine();
            String[] settings = new String [5];
            settings = parseDecryption(decryption);
            System.out.println(decryption);
        }
		

	}
	
	public static String[] parseDecryption (String decryption)
	{
		String [] args = new String [5];
		return args;
	}
	
	
	

}
