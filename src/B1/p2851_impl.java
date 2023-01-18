package B1;
import java.util.Scanner;

public class p2851_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int total = 0;
		int smaller = 0;

		boolean stopEating = false;

		for (int m = 0; m < 10; m++) {
			if (!stopEating) {
				smaller = total;
				total += sc.nextInt();
				
				if(total>=100) stopEating = true;
			} else sc.nextInt();
		}
		
		System.out.println(100-smaller<total-100?smaller:total);
	}
}