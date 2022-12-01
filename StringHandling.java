package assignments;

public class StringHandling {

	public static void main(String[] args)
	{

		String s="Exercise Regularly";
		System.out.println(s.indexOf("g"));
		System.out.println(s.indexOf("e"));
		System.out.println(s.lastIndexOf("e"));
		System.out.println(s.indexOf("e",6) );

		// Assignment exploring equals
		
		String str1= "I am Learning Selenium";
		String str2= "I am learning selenium";
		
		if (str1==str2) 
		{
			System.out.println("compares memeory address: Output as same text");
		
		}
		else
			System.out.println("compares memeory address: Output as different text");
		
		System.out.println("***************");
		
		if(str1.equals(str2))
		{System.out.println("compares case sensitivity and displays as same text");
		}
		
		else
			System.out.println("compares case sensitivity and displays as different text");
		
		System.out.println("***************");

		
		if (str1.equalsIgnoreCase(str2)) 
		{
			System.out.println("Ignores case sentivity and Output as same text");
		} else 
		{
System.out.println("Default value");
		}
		
		System.out.println("*******************************");
		//Replace the  character
		
		String original= "Searching Job for 2 months";
		
		String replaceAll = original.replaceAll("\\d", "4");
		
		System.out.println("Replaced : " + replaceAll );
		System.out.println(replaceAll.concat("#"));
		System.out.println(replaceAll.substring(5, 13));
		
	}

}
