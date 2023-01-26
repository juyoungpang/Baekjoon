package B3;
import java.util.Scanner;

public class p6131_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		for(int i=1;i<=500;i++) {
			double temp = Math.sqrt(Math.pow(i, 2)+N);
			if(temp == (int)temp) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}