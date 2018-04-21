import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * There are implemented Collection solutions here (with elements removals and iterating day by day)
 * but first iteration omits addition of first-day-die-flowers. Some counting problems (+-1 day).
 * @author oVoISheRe
 */

public class PoisonousPlants3 {

	public static void main(String[] args) throws FileNotFoundException {

	//	Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/PoisonousPlants1.txt"));
		int entries = in.nextInt();

		List<Integer> list = new ArrayList<>();
		in.nextLine();
		for(int i = 0; i < entries; i+=2) {
	//		System.out.println("l0: "+ list + ", entries: " + entries + ", i: " + i);
			int number1 = in.nextInt();
			if(!in.hasNextInt()) {   // omitting comparing last incoming number if there is no pair
				list.add(number1);
	//			System.out.println("l1: "+ list);
			} else {
				int number2 = in.nextInt();		
				if(number2>number1) {
					list.add(number1);
	//				System.out.println("l2: "+ list);
					continue;
				} else {
					list.add(number1);
					list.add(number2);
	//				System.out.println("l3: "+ list);
				}
			}			
		}
        int result = poisonousPlants(list);
        System.out.println(result);    
    }

	public static int poisonousPlants(List<Integer> list) {  
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
		return count+1;
	}
}
