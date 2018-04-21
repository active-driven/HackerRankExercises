import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.util.Pair;

// editorial way of solving:
// keep track of max numbers and their indices; add max only if new entry is greater than the current maximum element; 
// delete only if the number and the index of the popped element with the element on top of the maximum elements stack are the same
// index works here as checking if given max number was the first occurence in series - only in this is true it is deleted;
// Using JavaFX Pair class you have to use equals() method in line 48 instead of == operator. 
// Otherwise it gives wrong answers in testcases 5-16.
// Some other minor changes required also using my own Pair class/JavaFX class.
// Important: testcases saved here might be OK but ALL testcases at hackerrank might be not. Test all there.

public class MaximumElement6 {

	public static void main(String[] args) {
		
		int totalCurrentMax = Integer.MIN_VALUE;
		
		LinkedList<Pair<Integer, Integer>> elements = new LinkedList<>();   
		LinkedList<Pair<Integer, Integer>> maxSerie = new LinkedList<>();  
		
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
            	elements.add(new Pair<Integer, Integer>(currentNumber, i));
            	if(currentNumber > totalCurrentMax) {
            		totalCurrentMax = currentNumber;
            		maxSerie.add(new Pair<Integer, Integer>(totalCurrentMax, i)); 
            	}              	    	  
            } else if(temp == 2) {           	
                    Pair<Integer, Integer> removed = elements.pollLast();
                    if(removed.getKey().equals(maxSerie.peekLast().getKey()) 
                    		&& maxSerie.peekLast().getValue().equals(removed.getValue())) {
                    	maxSerie.pollLast();  
                    }                   
                    if(maxSerie.size() == 0) {
                		totalCurrentMax = 0;   // avoiding NullPointerException
                	} else {          		         
                        totalCurrentMax = maxSerie.peekLast().getKey();
                	}  
            } else {
            	System.out.println(maxSerie.peekLast().getKey());     
            }           
        }  
    	in.close();
    }
}