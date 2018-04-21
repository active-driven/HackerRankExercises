import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MaximumElement2 {
	
	public static void main(String[] args) {

		LinkedList<Integer> elements = new LinkedList<>();   
		
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
            	elements.add(in.nextInt());   
            } else if(temp == 2) {
            	elements.pollLast();   
            } else {
            	int x = elements               // also Terminated due to timeout
            	.stream()
        //    	.sorted()    // unnecessary
            	.reduce(Math::max)
            	.get();
            	System.out.println(x);         	
            }
        }        
    }
}


