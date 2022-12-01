package assignments;

public class ArmstrongNumber {

	public static void main(String[] args)
	
	{
// to find the given number is armstrong
		
// armstrong number is sum of the cube of the digits is equal to the given number
		//eg- 153
		// (1*1*1) + (5*5*5) + (3*3*3) = 153
		
		
		// initialise four variables
		
		int n =153, arm=0, remainder;
		
		while (n>0) 
		{
			remainder = n%10;
			arm = arm + (remainder*remainder*remainder);
			n=n/10;
			
		}
		if (arm==n) 
		{
			System.out.println("Number n 153 is armstrong ");
		} else
		{
			System.out.println("Number n 153 is not armstrong ");
		}

	}

}
