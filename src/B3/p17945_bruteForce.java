package B3;
import java.util.Scanner;

public class p17945_bruteForce {
	static int A, B;
	static boolean found;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		
		for(int x=-2001;x<2002;x++) {
			if(calc(x)==0) {
				System.out.print(x+" ");
			}
		}

	}

	public static int calc(int x) {
		return x * x + 2 * A * x + B;
	}
}