import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/truck-tour/problem
 * Based on LinkedList implementation of Queue interface. All testcases solved.
 * 
 * @author dream-tree
 */

public class TruckTour2 {
	
	public static void main(String[] args) throws IOException  {
		
		Queue<Integer> q = new LinkedList<>();
		
		Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/TruckTour9.txt"));
		int numberOfEntries = in.nextInt();
		for(int i = 0; i < numberOfEntries; i++) {
			int litres = in.nextInt();
			int distance = in.nextInt();
			int difference = litres - distance;
			q.add(difference);
		}
		System.out.println(q);
		
		int limit = q.size();   
		int count = 0;
		
		outer:
		while(limit > 0) {
			inner:
			for(Iterator<Integer> it = q.iterator(); it.hasNext(); ) { 			
				int temp = it.next();
				count+=temp;
				
				if(count<0) {
					count = 0;
					break inner;
				}
				if(!it.hasNext()) {   // reaching the end of list - we found the desired path
					System.out.println(q.size()-limit);
					break outer;
				}
			}
		    limit-=1;               // counting number of swap operations
			int head = q.poll();    // swap
			q.add(head);		
		}	
	}	
}