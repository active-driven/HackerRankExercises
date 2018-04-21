import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/down-to-zero-ii/problem
 * Two important notes:
 * 1/ Greedy solution doesn't work - the lowest factor from the max ones is not always the best move, i.e every number from the statement
 *    int temp = Math.max(i, n/i); must be checked, not the lowest only.
 *    It was rather obvious. Not as the second one:
 * 2/ It is sometimes better to decrement a non prime number by 1 instead of using the factor!
 * 
 * DP solution.
 * Why this is in Queue section?
 * 
 * @author oVoISheRe
 */

public class DowntoZero {
	
	private static int max = 1000001;
	private static int[] a = new int[max];
	
	public static void main(String[] args) throws FileNotFoundException {
		a[0] = 0;    
		a[1] = 1;   
		a[2] = 2;
		a[3] = 3;     // we can stop here
		a[4] = 3;     // every array element represents a number of required moves down
		a[5] = 4;
		a[6] = 4;
     	a[7] = 5;
		a[8] = 4;

		for(int i = 9; i <= 1000000; i++) {	    // and start from 4 here
			test(i); 
		}
		
		 Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/DowntoZeroTwo1.txt"));
	        int testCases = in.nextInt();
	        for(int i = 0; i < testCases; i++) {
	           	System.out.println(a[(in.nextInt())]); 
	        }
	  //      System.out.println(Arrays.toString(a));
		}	
	
	public static void test(int n) {
		
		int min = Integer.MAX_VALUE;

		// looking for all max factors
		// and checking which one gives the best solution, i.e. checking number of moves down in next move for every given factor
		for(int i = 2; i <= Math.sqrt(n); i++) { // not n/2 coz it uses looots more time; sqrt gives 2 equal numbers (lets say 2xF) and  
			if(n%i==0) {                         // every other pair consists of 1 number below and 1 above F so all combinations are checked!
				int temp = Math.max(i, n/i);     // this is critical for 
				if(a[temp] < min) {       // checking best solution described in note 1/
					min = a[temp];				 	
				}
			}
		}
		if(min == Integer.MAX_VALUE) {    // = if there is no (n%i==0)
			a[n] = a[n-1]+1;              // predecessor + 1 (move down)
		} else {
			if(min+1 < a[n-1]+1) {        // checking best solution described in note 2/
				a[n] = min+1;
			} else {
				a[n] = a[n-1]+1;
			}
			
		}
	}
}