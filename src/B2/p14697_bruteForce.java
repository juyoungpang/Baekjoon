package B2;
import java.util.Scanner;

public class p14697_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i=0;i<=N/A;i++) {
			for(int j=0;j<=N/B;j++) {
				for(int k=0;k<=N/C;k++) { 
					if(A*i+B*j+C*k==N) {
						System.out.println(1);
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}
}