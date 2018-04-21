import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *  My version with String. It pushes on the stack full current sequence, not only changes.
 *  
 * @author dream-tree
 */

public class SimpleTextEditor2 {

	private static LinkedList<String> list;    // Deque or LinkedList without other modifications
    
	public static void main(String[] args) throws FileNotFoundException {
		String s = "";
		list = new LinkedList<>();
		list.add(s);
//		System.out.println(list);
//		Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("C:/Users/oVoISheRe/OneDrive/test files/hacker/SimpleTextEditor.txt"));
		int entries = in.nextInt();
		in.nextLine();
		for(int i = 0; i < entries; i++) {
			String[] line = in.nextLine().split(" ");
			int command = Integer.parseInt(line[0]);
			if(command != 4) {   
				if(command == 1) {
					String appendSequence = line[1];
					list.add(list.peekLast()+appendSequence);
	//				System.out.println("1: " + list);
				}
				if(command == 2) {
					int deleteSequence = Integer.parseInt(line[1]);
					list.add(list.peekLast().substring(0, list.peekLast().length()-deleteSequence));
	//				System.out.println("2: " + list);
				}
				if(command == 3) {
					int printSequence = Integer.parseInt(line[1]);
					System.out.println(list.peekLast().charAt(printSequence-1));
	//				System.out.println("3: " + list);
				}
			// command == 4
			} else {
				list.pollLast();
			}		
		}
	    System.out.println();
	}	
}