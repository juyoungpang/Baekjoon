package B2;
import java.util.Scanner;

public class p16561_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		for(int i=3;i<=N-6;i+=3) {
			for(int j=3;j<=N-3;j+=3) {
				for(int k=3;k<=N;k+=3) {
					if(i+j+k==N) count++;
					else if(i+j+k>N) break;
				}
			}
		}
		
		System.out.println(count);
	}
	
}