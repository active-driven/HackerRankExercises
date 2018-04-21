import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-stones-1/problem
 * Game theory challenge.
 * Recursive version.
 */

public class GameOfStones3 {
	
	public static void main(String[] args) throws FileNotFoundException {
 
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
		if(n == 0 || n == 1) {
			return 0;
		} else if (n == 2 || n == 3 || n == 4) {
			return 1;
		} else {
			if(solve(n-2) == 0 || solve(n-3) == 0 || solve(n-5) == 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}	
}
