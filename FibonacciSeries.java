package assignments;

public class FibonacciSeries {

	public static void main(String[] args) {
// Fibonacci series is sum of the consecutive numbers
		// 0,1,1,2,3,5,8,13...

		// using for loop
		// declare four variables
		// where n= no of terms
		/*
		 * f= first term s= second term t = third term
		 */
		
		  int range=15, f=0, s=1, t;
		  
		  System.out.println(f);
		  
		  for (int i = 1; i <= range; i++)
		  { t= f+s; f=s; s=t;
		  
		  System.out.println(t);
		  
		  }
		  
		 
	}

}
