package B2;
import java.util.Scanner;

public class p16561_comb {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt()/3;
		
		System.out.println(comb(N-1,2));
	}
	
	public static int comb(int n, int k) {
		if(k==0 || n==k) {
			return 1;
		}
				
		return comb(n-1,k) + comb(n-1,k-1);
	}
}