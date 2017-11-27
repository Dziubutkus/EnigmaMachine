
public class Machine
{
	private int []rotSetting=new int[3]; //rotor settings
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
	
	public String encrypt()
	{
		Rotor rotor1=new Rotor(rotSetting[0]);
		Rotor rotor2=new Rotor(rotSetting[1]);
		Rotor rotor3=new Rotor(rotSetting[2]);
		//reflector part of Rotor or separate???
		
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
				letterNum=rotor1.changeLetter(letterNum);
				letterNum=rotor2.changeLetter(letterNum);
				letterNum=rotor3.changeLetter(letterNum);
				//reflector goes here
				letterNum=rotor1.changeLetter(letterNum);
				letterNum=rotor2.changeLetter(letterNum);
				letterNum=rotor3.changeLetter(letterNum);
			}
			letter=(char)letterNum;
			encryptMess=encryptMess+letter;
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