import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximum-element/problem
 * 
 * @author dream-tree
 */

public class MaximumElement1 {
	
	public static void main(String[] args) {

		LinkedList<Integer> elements = new LinkedList<>();   // nie mogę Queue bo ona nie ma pollLast()
		
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
            	elements.add(in.nextInt());   // adding NEXT number from input
            } else if(temp == 2) {
            	elements.pollLast();   
            } else {
            	int max = 0;
            	for(Iterator<Integer> it = elements.iterator(); it.hasNext(); ) {   // Terminated due to timeout
            		int queueElement = it.next();
           		if(queueElement > max) {
           			max = queueElement;
             		}
            	}
           	System.out.println(max);   
            }
        }   
        in.close();
    }
}


