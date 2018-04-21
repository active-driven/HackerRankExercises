import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/truck-tour/problem
 * Based on LinkedList implementation of Queue interface. All testcases solved.
 * More efficient version due to tutorial section explanations:
 * 1) Suppose we start at x and our sum is less than zero at y: if we start from any other petrol pump between x and y, 
 * we will definitely get stuck at y again. Starting somewhere between x and y, we can only have extra fuel from previous pumps - 
 * we can't be below 0 (if so, we would had to stop there). So at starting point between x and y we have lost that fuel 
 * (in best case we have 0 items of fuel). So, it's clear that we need to skip any petrol pumps between x and y as our starting point.
 * Time Complexity: Any petrol pump may be visited at most twice, so the complexity is linear.
 * 2) There is no need to use any Collection at all. 
 * Whereever we start our journey from, we can't make the full journey if at any point the remaining fuel value gets negative. 
 * To overcome this, we have to start from where the global minimum occurred, thus the value will remain non-negative at every point.
 * To be true - after that global minimum. 
 * Important is that in this problem impossible cases are not taken into account. 
 * 
 * Solution below is made by me taking into account this 2) note above. 
 * LinkedList or ArrayList version could be based on the same concept.
 * All testcases solved.
 * 
 * @author dream-tree
 */

public class TruckTour3 {
	
	public static void main(String[] args) throws IOException  {
				
		int minimum = Integer.MAX_VALUE;
		int index = 0;
		int difference = 0;
		Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/TruckTour9.txt"));
		int numberOfEntries = in.nextInt();
		for(int i = 0; i < numberOfEntries; i++) {
			int litres = in.nextInt();
			int distance = in.nextInt();
			difference = difference + litres - distance;
			if(difference < minimum) {
				minimum = difference;    // looking for global minimum
				index = i;               // saving index where (global) minimum occured
			}
		}
		System.out.println(index+1);
		
	}	
}