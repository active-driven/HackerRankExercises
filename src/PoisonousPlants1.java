import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * There are implemented Collection solutions here (with elements removals and iterating day by day):
 * - ArrayList version works but 6 of 28 test cases are terminated due to timeout.
 *   - using: List<Integer> list = new ArrayList<>(entries) - works but 6/7 of 28 test cases are terminated due to timeout.
 * - LinkedList version works but 13 of 28 test cases are terminated due to timeout.
 * @author oVoISheRe
 */

public class PoisonousPlants1 {

	public static void main(String[] args) throws FileNotFoundException {

	//	Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();  // or: LinkedList<Integer> list = new LinkedList<>();

		Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/PoisonousPlants1.txt"));
		int entries = in.nextInt();
		in.nextLine();
		for(int i = 0; i < entries; i++) {
			list.add(in.nextInt());
		}
		System.out.println("L:" + list);
        int result = poisonousPlants(list);
        System.out.println(result);    
    }

	public static int poisonousPlants(List<Integer> list) {   // or: public static int poisonousPlants(LinkedList<Integer> list)
		// variables count and flag are used for checking if any change was made in a given iteration (for loop)
		// if not, no more iterations are needed
		int count = 0;
		int flag = -1;
		while(flag!=count) {			
			flag = count;
			System.out.println(list);
			int check = 0;
			for(int i = list.size()-1; i > 0; i--) {
				// checking if this 'if branch' was executed at least once
				if(list.get(i) > list.get(i-1)) {					
					list.remove(i);	
					check++;
				}
			}
			if(check!=0) {
			count++;						
			}
		}	
		return count;
	}
}
