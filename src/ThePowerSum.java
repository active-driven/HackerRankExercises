import java.util.ArrayList;
import java.util.List;

public class ThePowerSum {

	public static void main(String[] args) {

		int number = 100;
//		int sqrt = (int)Math.sqrt(number);
//		System.out.println(sqrt);
		int power = 2;
		
		List<Integer> list = new ArrayList<>();
		int temp = 1;
		while(temp*temp <= number) {
			list.add(temp*temp);
			temp++;
		}
		System.out.println(list + " " + (temp-1));
		
		Integer[] array = list.toArray(new Integer[0]);
		findSum(array, number);
		;
	}
	
	public static void findSum(Integer[] squares, int number) {
		int total = 0;
		if(squares[squares.length-1] == number) {
			total=1;
		}
		
		for(int i = squares.length-1; i >=0; i--) {
			int sum = squares[i];
			for(int j = i-1; j >= 0; j--) {
				if(sum+squares[j] > number) {
					System.out.println("check 1");
					continue;
				} else if(sum+squares[j] == number) {
					System.out.println("check 2" + " " + sum + " " + squares[j]);
					total++;
					sum=0;
				} else if(sum+squares[j] < number) {
					System.out.println("check 3" + " " + sum + " " + squares[j]);
					sum+=squares[j];
				}
			}
		}
		System.out.println(total);	
	}
}
