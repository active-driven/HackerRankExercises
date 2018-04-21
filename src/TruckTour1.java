import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/truck-tour/problem
 * Very inefficient ArrayList-based solution. Just checking understanding of exercise problem.
 * Timeout for 9 of 13 testcases.
 * 
 * @author dream-tree
 */

public class TruckTour1 {
	
	public static void main(String[] args) throws IOException  {
		
		List<Integer> list = new ArrayList<>();
		
		Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/TruckTour1.txt"));
		int numberOfEntries = in.nextInt();
		for(int i = 0; i < numberOfEntries*2; i++) {
			list.add(in.nextInt());
		}
//		System.out.println(list);
		int limit = list.size();   
		int count = 0;
		for(int j = 0; j < list.size(); j++) {
			if(j%2==0) {
				count+=list.get(j);
			} else {
				count-=list.get(j);
			}
			if(count<0) {
				System.err.println("ERROR at index " + j + ", starting at next index (zero really) ");
				int temp1 = list.remove(0);   // removing first element and
				list.add(temp1);      // adding it to the end of the list (circular move)
				int temp2 = list.remove(0);   // again - we have pairs of numbers
				list.add(temp2);     
				j=-1;           // reset of initializer in the for loop  
				limit-=2;       // counting number of swap operations
				count=0;
			}
			if(j==list.size()-1) {   // reaching the end of list - we found the desired path
				break;
			}
//			System.out.println(list);
		}
		System.out.println((list.size()-limit)/2); 
	
	}
}