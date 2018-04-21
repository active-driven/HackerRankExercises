import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.util.Pair;

// Same way of solving as in MaximumElement6.
// Used own Pairs class here. 
// Checking equality using == operator.

public class MaximumElement7 {

	public static void main(String[] args) {
		
		int totalCurrentMax = Integer.MIN_VALUE;
		
		LinkedList<Pairs> elements = new LinkedList<>();   
		LinkedList<Pairs> maxSerie = new LinkedList<>();  
		
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
            	elements.add(new Pairs(currentNumber, i));
            	if(currentNumber > totalCurrentMax) {
            		totalCurrentMax = currentNumber;
            		maxSerie.add(new Pairs(totalCurrentMax, i)); 
            	}              	    	  
            } else if(temp == 2) {           	
                    Pairs removed = elements.pollLast();
                    // instead: maxSerie.peekLast().getMax()  might be also: totalCurrentMax
                    if(removed.getMax() == maxSerie.peekLast().getMax() && removed.getIndex() == maxSerie.peekLast().getIndex()) {
                    	maxSerie.pollLast();  
                    }                   
                    if(maxSerie.size() == 0) {
                		totalCurrentMax = 0;   // avoiding NullPointerException
                	} else {          		         
                        totalCurrentMax = maxSerie.peekLast().getMax();
                	}  
            } else {
            	System.out.println(maxSerie.peekLast().getMax());     
            }           
        }  
    	in.close();
    }
}

	class Pairs {
		int max;
		int index;
		
		public Pairs(int max, int index) {
			this.max=max;
			this.index=index;
		}
		
		public int getMax() {
			return this.max;
		}
		public int getIndex() {
			return this.index;
		}
	}