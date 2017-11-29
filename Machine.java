
public class Machine
{
	private int []rotSetting=new int[3]; //rotor settings, start positions
	private int []rotNum=new int[3]; //rotor numbers 1-5
	private char codeType; //encrypt or decrypt
	private String message;
	
	//Constructors
	public Machine(int[ ] rotSetting, int[ ] rotNum, String message, char codeType)
	{
		this.rotSetting = rotSetting;
		this.rotNum = rotNum;
		this.message = message;
		this.codeType = codeType;
	}
	
	public Machine()
	{
		for(int i =0; i<3;i++)
		{
			this.rotSetting[i]=-1;
			this.rotNum[i]=-1;
		}
		this.message= "nothing";
		this.codeType='?';
	}
	
	public String encrypt(char reflectorType, String rotorNum, String encryptionMessage)
	{
		int rotor1Num=(int)rotorNum.charAt(0);
		int rotor2Num=(int)rotorNum.charAt(1);
		int rotor3Num=(int)rotorNum.charAt(2);
		
		for (int i=0;i<3;i++)
		{
			rotSetting[i]=(int)(Math.random()*26);
		}
		
		Rotor rotor1=new Rotor(rotSetting[0],rotor1Num);
		Rotor rotor2=new Rotor(rotSetting[1],rotor2Num);
		Rotor rotor3=new Rotor(rotSetting[2],rotor3Num);
		Relflector reflector=new Reflector(reflectorType);
		
		int messLength=message.length ( ); //gets length of message
		int letterNum;
		char letter;
		String encryptMess;
		int charCount=0;
		
		while(charCount<=messLength)
		{
			for (int i=0;i<messLength-1;i++)
			{
				letterNum = (int)letter;
				letterNum=rotor1.changeLetter(letterNum,rotor2,rotor3);
				letterNum=rotor2.changeLetter(letterNum,rotor1,rotor3);
				letterNum=rotor3.changeLetter(letterNum,rotor1,rotor2);
				//letterNum=relflector.changeLetter(letterNum);
				letterNum=rotor3.changeLetter(letterNum,rotor1,rotor2);
				letterNum=rotor2.changeLetter(letterNum,rotor1,rotor3);
				letterNum=rotor1.changeLetter(letterNum,rotor2,rotor3);
			}
			letter=(char)letterNum;
			encryptMess=encryptMess+letter;
		}
		String rotorNumbers; //rotor number settings
		String rotorSettings; //rotor starting settings
		for (int r=0;r<3;r++)
		{
			char number=(char)rotNum[r];
			rotorNumbers+=number;
			char setting=(char)rotSetting[r];
			rotorSettings+=setting;
		}
		encryptMess=rotorNumbers +" "+rotorSettings+" "+encryptMess;
		return encryptMess;
	}
	
	public String decrypt(char reflectorType, String rotorNum,String decryptMess)
	{
		int rotor1Num=(int)rotorNum.charAt(0);
		int rotor2Num=(int)rotorNum.charAt(1);
		int rotor3Num=(int)rotorNum.charAt(2);
		
		
		Rotor rotor1=new Rotor(rotSetting[0],rotor1Num);
		Rotor rotor2=new Rotor(rotSetting[1],rotor2Num);
		Rotor rotor3=new Rotor(rotSetting[2],rotor3Num);
		Relflector reflector=new Reflector(reflectorType);
		
		int messLength=message.length ( ); //gets length of message
		int letterNum;
		char letter;
		int charCount=0;
		
		while(charCount<=messLength)
		{
			for (int i=0;i<messLength-1;i++)
			{
				letterNum = (int)letter;
				letterNum=rotor1.changeLetter(letterNum,rotor2,rotor3);
				letterNum=rotor2.changeLetter(letterNum,rotor1,rotor3);
				letterNum=rotor3.changeLetter(letterNum,rotor1,rotor2);
				//letterNum=relflector.changeLetter(letterNum);
				letterNum=rotor3.changeLetter(letterNum,rotor1,rotor2);
				letterNum=rotor2.changeLetter(letterNum,rotor1,rotor3);
				letterNum=rotor1.changeLetter(letterNum,rotor2,rotor3);
			}
			letter=(char)letterNum;
			decryptMess=decryptMess+letter;
		}

		return decryptMess;
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