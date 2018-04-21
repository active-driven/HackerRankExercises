import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 * This class is  done as in editorial notes.
 * Editorial notes:
 * 	  Whenever an opening bracket appears, we push it onto the stack. OK
 *    If a closing bracket appears and if it matches the opening bracket at the top of the stack, it means that the brackets 
 *    are balanced and we pop the opening bracket out of the stack and continue analyzing the string.   OK
 *    If the closing bracket doesn't match the opening bracket at the top of the stack, we can infer that the string 
 *    is not balanced, and we print NO.   
 *    After processing the string completely and if the stack is empty, the string is balanced, and we print YES, 
 *    else, we print NO.
 * 
 * @author dream-tree
 */

public class BalancedBrackets2 {

	public static void main(String[] args) {
		
		String s = "{{[[(())]]}}";
		System.out.println(s);	
        String result = isBalanced(s);
        System.out.println(result);	
	}
	
	public static String isBalanced(String s) {
			
		if(s.length() % 2 != 0) {
			return "NO";
		}
		
		LinkedList<Character> brackets = new LinkedList<>();
		for(int i = 0; i < s.length(); i++) {
			if(brackets.size() == 0) {
				brackets.addLast(s.charAt(i));
			} else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
				if(!matchCharacters(brackets.peekLast(), s.charAt(i))) {
					return "NO";
				} else {
					brackets.pollLast();	
				}	
			} else {
				brackets.addLast(s.charAt(i));	
			}
			brackets
			.stream()
			.forEach(x -> System.out.print(x + " "));
			System.out.println();
		}
		return brackets.size() == 0 ? "YES" : "NO";
	}
	
	public static boolean matchCharacters(char a, char b) {
		if(a == '{' && b == '}') {
			return true;
		} else if (a == '[' && b == ']') {
			return true;
		} else if (a == '(' && b == ')') {
			return true;
		} else {
			return false;
		}
	}
}
