import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This my own solution. I'm tracking all changes (additions and deletions) on the stack, so I can reverse all operations.
 * I'm tracking changes and only changes.
 * No editorial here available.
 * Most answers in Discussion sections gives lil different solution:
 * In every addition or deletion, they push on the stack not changes but full current sequence 
 * (since the beginning of making changes).
 * This might be done with String but it is ineffective IMO.
 * It's impossible to do it with StringBuilder (or I can't do that) coz StringBuilder is mutable and 
 * it mutes the original sequence every time:
 * 		sb.append(appendSequence);
 * 		deque.add(sb);
 * 			or:
 *		deque.add(sb.append(appendSequence));
 * mutates the sequence placed in the head of LinkedList and then adds the same sequence to the next node (same sequence) and so on.
 * 
 * @author dream-tree
 *
 */

public class SimpleTextEditor {

	private static StringBuilder sb;
	private static Deque<Operation> deque;    // Deque or LinkedList without other modifications
    
	public static void main(String[] args) throws FileNotFoundException {
		sb = new StringBuilder("");		
		deque = new LinkedList<>();
			
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
					sb.append(appendSequence);
					deque.add(new Operation(0, appendSequence));
	//				System.out.println(list);
				}
				if(command == 2) {
					int deleteSequence = Integer.parseInt(line[1]);
					String forDeletion = sb.toString().substring(sb.length()-deleteSequence, sb.length());
					sb.delete(sb.length()-deleteSequence, sb.length());
					deque.add(new Operation(1, forDeletion));
	//				System.out.println(list);
				}
				if(command == 3) {
					int printSequence = Integer.parseInt(line[1]);
					System.out.println(sb.toString().charAt(printSequence-1));
				}
			// command == 4
			} else {
				undo();
			}		
		}
	    System.out.println();
	}
	
	public static void undo() {
		// if 0 (String was added), then delete it
		// if 1 (String was deleted), then add it back
		if(deque.peekLast().getAddOrDelete() == 0) {
			String temp = deque.pollLast().getOperationSequence();
			sb.delete(sb.length()-temp.length(), sb.length());
		} else {
			String temp = deque.pollLast().getOperationSequence();
			sb.append(temp);
		}
	}	
}

	class Operation {
        // 0 - given sequence was added in this operation 
		// 1 - given sequence was deleted in this operation
		int addOrDelete;
		String operationSequence;

		public Operation(int addOrDelete, String operationSequence) {
			this.addOrDelete = addOrDelete;
			this.operationSequence = operationSequence;		
		}
		
		/**
		 * @return the addOrDelete
		 */
		public int getAddOrDelete() {
			return addOrDelete;
		}

		/**
		 * @return the operationSequence
		 */
		public String getOperationSequence() {
			return operationSequence;
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "addOrDelete = " + addOrDelete + ", operationSequence = " + operationSequence;
		}	
	}