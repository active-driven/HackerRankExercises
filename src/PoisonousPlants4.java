import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * OUT-BAD
 * @author oVoISheRe
 */

public class PoisonousPlants4 {

	public static void main(String[] args) throws FileNotFoundException {

		//	Scanner in = new Scanner(System.in);
			List<Integer> list = new ArrayList<>();  // or: LinkedList<Integer> list = new LinkedList<>();

			Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/PoisonousPlants4.txt"));
			int entries = in.nextInt();
			in.nextLine();
			for(int i = 0; i < entries; i++) {
				list.add(in.nextInt());
			}
	        int result = poisonousPlants(list);
	        System.out.println(result);    
	    }

	public static int poisonousPlants(List<Integer> list) {   
		int count = 0;
		int total = 0;
		int middle = 0;
		
		for(int i = list.size()-1; i > 0; i--) {	
			System.out.println("list0 " + list + " " + "i0: " + i);
			while(list.get(i) > list.get(i-1)) {
				list.remove(i);
				if(i>1) {
					i--;	
				} else {
					break;
				}			
				System.out.println("list1 " + list + " " + "i1: " + i);
			}

			if(i < list.size()-1 && list.get(i+1) > list.get(i)) {
				list.remove(i+1);
				count++;
				System.out.println("list3 " + list + " " + "i3: " + i);
			}
			i--;
		}		
		return count;
	}
}