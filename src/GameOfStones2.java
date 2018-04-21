import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-stones-1/problem
 * Game theory challenge.
 * Dynamic programming - Memoization (top down).
 */

public class GameOfStones2 {
	
	static int[] results = new int[101];
	
	public static void main(String[] args) throws FileNotFoundException {
 
		for(int i = 0; i < 101; i++) {
			results[i] = -1;
		}
			
        Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/GameOfStones3.txt"));
        int testCases = in.nextInt();
        for(int i = 0; i < testCases; i++) {
            int moves = in.nextInt();   
            System.out.print(moves + " "); 
            System.out.println(solve(moves) == 0 ? "Second" : "First"); 
            }  
        in.close();
        }	
	
	public static int solve(int n) {
		if(results[n] == -1) {
			if(n == 0 || n == 1) {
				return 0;
			} else if (n == 2 || n == 3 || n == 4) {
				return 1;
			} else {
				if(solve(n-2) == 0 || solve(n-3) == 0 || solve(n-5) == 0) {
					results[n] = 1;    // nie return 1!
				} else {
					results[n] = 0;    // nie return 0!
				}
			}
		}	
		return results[n];		
	}
}