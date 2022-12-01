package assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateNumbers {

	public static void main(String[] args) 
	{
		// create list
		List<String> mylist = new ArrayList<String>();
		// sort and make zero to right side
		// int[] num = {4,0,3,0,1,5,2,0}
		//move all the 0 to the right 
		//output:  4,3,1,5,2,0,0,0
		
mylist.add("4"); 
mylist.add("0");
mylist.add("3");
mylist.add("0");
mylist.add("1");
mylist.add("5");
mylist.add("2");
mylist.add("0");

System.out.println("Original list "+ mylist);

// rotate the elements by 3

 Collections.sort(mylist);
 System.out.println("Sorted List "+ mylist);
 
// Rotate the list
Collections.rotate(mylist, 1);

System.out.println("Rotated list "+ mylist);
	}

}
