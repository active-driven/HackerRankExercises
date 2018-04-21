import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * There is implemented array solutions here (no elements removals but with iterating day by day):
 * - 7 of 28 test cases are terminated due to timeout.
 * 
 * @author oVoISheRe
 */

public class PoisonousPlants2 {

	public static void main(String[] args) throws FileNotFoundException {

	//	Scanner in = new Scanner(System.in);
		

		Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/PoisonousPlants1.txt"));
		int entries = in.nextInt();
		int[] pesticides = new int[entries];
		in.nextLine();
		for(int i = 0; i < pesticides.length; i++) {
			pesticides[i] = in.nextInt();
		}
//		System.out.println(list);
        int result = poisonousPlants(pesticides);
        System.out.println(result);    
    }

	public static int poisonousPlants(int[] pesticides) {
		// variables count and flag are used for checking if any change was made in a given iteration (for loop)
		// if not, no more iterations are needed
		int count = 0;
		int flag = -2;
		while(flag!=count) {			
			flag = count;
			System.out.println(Arrays.toString(pesticides));
			int check = 0;
			for(int i = pesticides.length-1; i > 0; i--) {
				if(pesticides[i] == -1) {
					continue;
				}
				// checking if this 'if branch' was executed at least once
				if(pesticides[i] > pesticides[i-1] && pesticides[i-1] != -1) {					
					pesticides[i] = -1;	
					check++;
				} else if(pesticides[i] < pesticides[i-1] && pesticides[i-1] != -1) {					
					continue;
				} else if(pesticides[i-1] == -1) {
					int index = i;
					while(pesticides[index-1] == -1) {
						index--;
					}
					if(pesticides[i] > pesticides[index-1]) {					
						pesticides[i] = -1;	
						check++;
					} else {
						continue;
					}
				}
			}
			if(check!=0) {
			count++;						
			}
		}		
		return count;
	}
}