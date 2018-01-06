
public class Machine
{
	private int []rotSetting=new int[3]; //rotor settings, start positions
	private char codeType; //encrypt or decrypt
	private String message;
	private String rotorSettings;
	private Reflector reflector;
	private char reflectorType;
	Rotor rotor1;
	Rotor rotor2;
	Rotor rotor3;
	
	//Encryption Constructor
	public Machine(char reflectorType, String encryptionMessage, char typeChar, int[] rotorSettings)
	{
		rotSetting = rotorSettings;
		reflector = new Reflector(reflectorType);
		rotor1 = new Rotor(rotSetting[0],1);
		rotor2 = new Rotor(rotSetting[1],2);
		rotor3 = new Rotor(rotSetting[2],3);
		message = encryptionMessage;
		codeType = typeChar;
	}
	public Machine()
	{
		for(int i =0; i<3;i++)
		{
			this.rotSetting[i]=-1;
		}
		this.message= "nothing";
		this.codeType='?';
	}
	
	public String encrypt()
	{
		int messLength=message.length ( ); //gets length of message
		int letterNum = -1; //set to -1 for initialization (should be okay??)
		char letter = ' ';
		String encryptMess = "";
		if(codeType == 'E')
		{
			for (int i=0;i<messLength;i++)
			{
				letterNum=(int)message.charAt(i);
				rotor1.shift(rotor1, rotor2, rotor3);
				letterNum=rotor1.changeLetter(letterNum,rotor1,rotor2,rotor3);
				letterNum=rotor2.changeLetter(letterNum,rotor1,rotor2, rotor3);
				letterNum=rotor3.changeLetter(letterNum,rotor1, rotor2, rotor3);
				letterNum=reflector.changeLetter(letterNum);
				letterNum=rotor3.changeLetterDecrypt(letterNum,rotor1,rotor2,rotor3);
				letterNum=rotor2.changeLetterDecrypt(letterNum,rotor1,rotor2,rotor3);
				letterNum=rotor1.changeLetterDecrypt(letterNum,rotor1,rotor2,rotor3);
				
				letter=(char)letterNum;
				encryptMess=encryptMess+letter;
			}
		}
		else if(codeType == 'D')
		{
			for (int i=0;i<messLength;i++)
			{
				letterNum=(int)message.charAt(i);
				rotor1.shift(rotor1, rotor2, rotor3);
				letterNum=rotor1.changeLetter(letterNum,rotor1,rotor2,rotor3);
				letterNum=rotor2.changeLetter(letterNum,rotor1,rotor2,rotor3);				//System.out.println(letterNum);
				letterNum=rotor3.changeLetter(letterNum,rotor1,rotor2,rotor3);				//System.out.println(letterNum);
				letterNum=reflector.changeLetter(letterNum);
				letterNum=rotor3.changeLetterDecrypt(letterNum,rotor1,rotor2,rotor3);				
				letterNum=rotor2.changeLetterDecrypt(letterNum,rotor1,rotor2,rotor3);				
				letterNum=rotor1.changeLetterDecrypt(letterNum,rotor1,rotor2,rotor3);
				letter=(char)letterNum;
				encryptMess=encryptMess+letter;
			}
		}

		     //Formatting
		String rotorSettings = null; //rotor starting settings
		for (int r=0;r<3;r++)
		{
			char setting=(char)rotSetting[r];
			rotorSettings+=setting;
		}
		return encryptMess;
	}
	
		
	//Getters and Setters
	public int[ ] getRotSetting( )
	{
		return rotSetting;
	}

	public void setRotSetting( int[ ] rotSetting )
	{
		this.rotSetting = rotSetting;
	}

	public char getCodeType( )
	{
		return codeType;
	}

	public void setCodeType( char codeType )
	{
		this.codeType = codeType;
	}
	
}
