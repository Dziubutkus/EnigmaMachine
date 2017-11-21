import java.util.Scanner;

public class EnigmaMacine
{

	public static void main( String[ ] args )
	{
		Scanner input = new Scanner (System.in);
		
		System.out.println ( "Put input here" );
		String encryption = input.nextLine();
		
		String [] settings = new String [5];
			settings = parse (encryption);
		

	}
	
	public static String [] parse (String encryption)
	{
		String [] args = new String [5];
		return args;
	}
	
	
	

}
