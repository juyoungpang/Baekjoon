package B1;
import java.util.Scanner;

public class p1816_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int n=0;n<N;n++) {
			long S = sc.nextLong();
			boolean possible = true;
			for(int i=2;i<1000000;i++) {
				if(S%i==0) {
					possible = false;
					break;
				}
			}
			if(possible) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}