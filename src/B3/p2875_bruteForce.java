package B3;
import java.util.Scanner;

public class p2875_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int answer = 0;
		
		for(int i=0;i<=K;i++) {
			if(N-i<0 || M-(K-i)<0) continue;
			
			answer = Math.max(answer, Math.min((N-i)/2, M-(K-i)));
		}
		
		System.out.println(answer);
	}
}