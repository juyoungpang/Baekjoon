package B3;
import java.util.Scanner;

public class p14568_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		
		for(int A=2;A+4<=N;A+=2) {
			for(int B=1;B*2+2<=N-A;B++) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}