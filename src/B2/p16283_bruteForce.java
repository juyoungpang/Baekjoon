package B2;
import java.util.Scanner;

public class p16283_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();

		int sheep = 1;
		int goat = n - 1;
		int count = 0;
 
		int ansS = 0;
		int ansG = 0;

		while (true) {
			if (goat == 0) {
				if (count == 0) {
					System.out.println(-1);
					break;
				} else {
					System.out.println(ansS + " " + ansG);
					break;
				}
			}
			
			if (sheep * a + goat * b == w) {
				if (count == 1) {
					System.out.println(-1);
					break;
				} else {
					ansS = sheep;
					ansG = goat;
					count++;
				}
			}

			sheep++;
			goat--;
		}
	}
}