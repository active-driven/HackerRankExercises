import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

// Have to use another collection or pair of numbers for max entries coz some entries in some testcases removes more 
// than one earlier entry in one round as in 1 93, 2, 2, 2, 3, 3, 2, 3, 3, 2, 2, 2, 2, 1 27, 2, 2, 2  etc.
// what's more entries may be duplicates and removals are done more than once in each iteration;
// If pair of numbers we have same number of entries and currentMaxes; if another collection:
// either second collection have same size as all entries collection and it tracks max number in each iteration with each entry 
// in parallel or we add to second collection only numbers greater or equal to current max (coz might be duplicates of max numbers)
// Attention: no 'among numbers' might be max numbers - it's not clear unless you don't understand it truly
// More: can't use SortedSet coz entries may be duplicates
// This is working answer using additional object for tracking numbers on stack and max number altogether in each iteration (same sizes)

public class MaximumElement3 {

	public static void main(String[] args) {
		
		int totalCurrentMax = Integer.MIN_VALUE;
		
		LinkedList<EntryAndMax> elements = new LinkedList<>();   

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
            	if(currentNumber > totalCurrentMax) {
            		totalCurrentMax = currentNumber;
            	}
            	elements.add(new EntryAndMax(currentNumber, totalCurrentMax));  
            } else if(temp == 2) {
            	elements.pollLast();    
            	if(elements.size() == 0) {
            		totalCurrentMax = Integer.MIN_VALUE;   // avoiding NullPointerException
            	} else {          		         
                	totalCurrentMax = elements.peekLast().getCurrentMax();
            	}
            } else {
            	System.out.println(elements.peekLast().getCurrentMax());     
            }           
        }        
    }
}

	class EntryAndMax {
		
		int entry;
		int currentMax;
		
		public EntryAndMax(int entry, int currentMax) {
			this.entry = entry;
			this.currentMax = currentMax;
		}
		
		public int getEntry() {
			return this.entry;
		}
		
		public int getCurrentMax() {
			return this.currentMax;
		}
		
		@Override
		public String toString() {
			return "entry: " + entry + ", currentMax: " + currentMax;
		}	
	}




