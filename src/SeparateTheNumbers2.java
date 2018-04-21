/**
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 * Same solution as in SeparateTheNumbers1. Difference:
 * Used while loop instead of for+if. Outer loop-break removed.
 * 
 * @author dream-tree
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeparateTheNumbers2 {
	
	 public static void main(String[] args) throws FileNotFoundException {
		 
	 //  Scanner in = new Scanner(System.in);
		 Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/SeparateTheNumbers.txt"));
	     int q = in.nextInt();
	     for(int a = 0; a < q; a++) {
	         String s = in.next();
	         solve(s);
	     }   
	     in.close();  
	 }
	 	
	    
	 public static void solve(String s) {
		 boolean flag = false;
    	 System.out.println("s:         " + s);
    	 String start = "";
    	 for(int i = 1; i<s.length()/2+1; i++) {
    		 start = s.substring(0, i);
	    	 long a = Long.parseLong(start);
	    	 StringBuilder sb = new StringBuilder(start);
	    	 System.out.println("sb start:  " + sb);

	    	 while(sb.toString().length() < s.length()) {
	    		a+=1;
		    	sb.append(a);  
		    	System.out.println("sb inside: " + sb);
	    	}    		 
	  //  	 System.out.println("sb: " + sb);
	    	 
	    	 if(s.equals(sb.toString())) {
	    		 flag = true;
	    		 break;
	    	 } 
    	 }   	 
    	 System.out.println(flag==true ? "YES " + start : "NO");
	 }   
}