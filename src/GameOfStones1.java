import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-stones-1/problem
 * Game theory challenge.
 * Dynamic programming - tabulation (bottom up).
 */

public class GameOfStones1 {
    
    static int[] pos = new int[101];

    public static void main(String[] args) throws FileNotFoundException {
        pos[0] = 0;
    	pos[1] = 0;
    	pos[2] = 1;
    	pos[3] = 1;
    	pos[4] = 1;
    	
        solve(103);
        
        Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/GameOfStones3.txt"));
        int testCases = in.nextInt();
        for(int i = 0; i < testCases; i++) {
            int moves = in.nextInt();   
            System.out.print(moves + " "); 
            System.out.println(pos[moves] == 0 ? "Second" : "First"); 
            }  
        in.close();
        }
    
     public static void solve(int number) {
    	
    	for(int i = 5; i < 101; i++) {
    		if(pos[i-2] == 0 || pos[i-3] == 0 || pos[i-5] == 0) {   
    			pos[i] = 1;
    		} else {
    			pos[i] = 0;
    		}
    	}
    	System.out.println(Arrays.toString(pos));
    } 
}