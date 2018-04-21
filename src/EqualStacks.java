import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/equal-stacks/problem
 * This exercise might be done without removing elements from the "stack" - we can move through indices of array/arraylist.
 * Each array must be allocated with max number of possible elements then.
 * 
 * @author dream-tree
 */


public class EqualStacks {

	public static void main(String[] args) throws FileNotFoundException {
       
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        Queue<Integer> q3 = new LinkedList<Integer>();
    	
        int sum1 = 0;
    	int sum2 = 0;
    	int sum3 = 0;
		
    	Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/equalStacksOriginal.txt")); 
	        int n1 = in.nextInt();
	        int n2 = in.nextInt();
	        int n3 = in.nextInt();

	        // summing elements might be done here without using streaming operations later (but I'm exercising here)
	        for(int i = 0; i < n1; i++){
	            q1.add(in.nextInt());
	        }
	        for(int i = 0; i < n2; i++){
	            q2.add(in.nextInt());
	        }
	        for(int i = 0; i < n3; i++){
	            q3.add(in.nextInt());
	        }
	        in.close();

	        sum1 = q1
	        		.stream()
	        		.reduce((a, b) -> a+b)
	        		.get();
	        sum2 = q2
	        		.stream()
	        		.reduce((a, b) -> a+b)
	        		.get();
	        sum3 = q3
	        		.stream()
	        		.reduce((a, b) -> a+b)
	        		.get();
	        
	        int minSum = Math.min(sum1, Math.min(sum2, sum3));
	        int minSize = Math.min(q1.size(), Math.min(q2.size(), q3.size()));
	        
			System.out.printf(q1 + " sum1: " + sum1);
			System.out.println(q2 + "       sum2: " + sum2);
			System.out.println(q3 + "    sum3: " + sum3);
			System.out.println("minSum: " + minSum + ", minSize: " + minSize);

			while(minSum >= 0 && minSize >= 0) {
				// This if branch is necessary because there is a note in the challenge:
				// "An empty stack is still a stack."
				// Besides, that's why in while loop, >= operator is used instead of > operator.
                if(sum1 == 0 && sum2 == 0 && sum3 == 0) {
                    System.out.println(0);
                    break;
                }
				if(sum1 > minSum) {
					int a = q1.poll();
					sum1-=a;
				}
				if(sum2 > minSum) {
					int b = q2.poll();
					sum2-=b;
				}
				if(sum3> minSum) {
					int c = q3.poll();
					sum3-=c;
				}
				if(sum1 == sum2 && sum2 == sum3) {
					System.out.println(minSum);
					break;
				} else {
					minSum = Math.min(sum1, Math.min(sum2, sum3));
				}
			}	
	}
}
