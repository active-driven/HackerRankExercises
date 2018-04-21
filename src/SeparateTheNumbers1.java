/**
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 * 
 * @author dream-tree
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeparateTheNumbers1 {
	
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
    	 outer:
    	 for(int i = 1; i<s.length()/2+1; i++) {
    		 start = s.substring(0, i);
	    	 long a = Long.parseLong(start);
	    	 StringBuilder sb = new StringBuilder(start);
	    	 System.out.println("sb start:  " + sb);
	    	 for(int j = i; j < s.length(); j++) {
	    		 a+=1;
	    		 sb.append(a);  
	    		 System.out.println("sb inside: " + sb);
	    		 if(sb.toString().length()>=s.length()) {
	    			 break;
	    		 }    		 
	    	 }
	  //  	 System.out.println("sb: " + sb);
	    	 
	    	 if(s.equals(sb.toString())) {
	    		 flag = true;
	    		 break outer;
	    	 } 
    	 }   	 
    	 System.out.println(flag==true ? "YES " + start : "NO");
	 }   
}

