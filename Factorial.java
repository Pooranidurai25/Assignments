package assignments;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// find the factorial of 7
		// initialise the i and fact
		// use for loop 
		// print the output
		
		int n = 7;
		int fact = 1;
		
		for (int i = n; i > 0; i--) 
		{
			fact = fact * i;
			
			
		}
		System.out.println("factorial of n " + fact);

	}

}
