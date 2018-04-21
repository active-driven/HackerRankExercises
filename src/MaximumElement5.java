import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

// This is working answer using additional collection for tracking max numbers in each iteration but 
// we we add to second collection only numbers greater or equal to current max (coz might be duplicates of max numbers)
// Attention: no 'among numbers' might be max numbers!! - it's not clear unless you don't understand it truly

public class MaximumElement5 {

	public static void main(String[] args) {
		
		int totalCurrentMax = Integer.MIN_VALUE;
		
		LinkedList<Integer> elements = new LinkedList<>();   
		LinkedList<Integer> maxSerie = new LinkedList<>();  
		
		Scanner in = null;
		try {	
			in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/maxElement2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        int numberOfEntries = in.nextInt();
        for(int i = 0; i < numberOfEntries; i++) { 
        	int temp = in.nextInt();
            if(temp == 1) {   
            	int currentNumber = in.nextInt();
            	elements.add(currentNumber);
            	if(currentNumber >= totalCurrentMax) {
            		totalCurrentMax = currentNumber;
            		maxSerie.add(totalCurrentMax); 
            	}              	    	  
            } else if(temp == 2) {           	
                    int poll = elements.pollLast();
                    if(maxSerie.peekLast() == poll) {
                    	maxSerie.pollLast();  
                    }                   
                    if(maxSerie.size() == 0) {  // avoiding NullPointerException
                		totalCurrentMax = 0;
                	} else {          		         
                        totalCurrentMax = maxSerie.peekLast();
                	}  
            } else {
            	System.out.println(maxSerie.peekLast());     
            }           
        }        
    }
}