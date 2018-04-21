import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.util.Pair;

// This is working answer using additional collection for tracking max numbers in each iteration (both collections have the same sizes)
// This version works similarly as ver. 3 but max values are placed in a separate collection

public class MaximumElement4 {

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
            	if(currentNumber > totalCurrentMax) {
            		totalCurrentMax = currentNumber;
            	}   
            	maxSerie.add(totalCurrentMax);     	  
            } else if(temp == 2) {           	
                    elements.pollLast();  
                    maxSerie.pollLast();  
                    if(maxSerie.size() == 0) {   // avoiding NullPointerException
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