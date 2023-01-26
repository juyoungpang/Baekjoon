package B3;
import java.util.Scanner;

public class p17945_Math {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt() * 2;
		int c = sc.nextInt();

		int res1 = ((b * -1) - (int) Math.sqrt(Math.pow(b, 2) - (4 * c)))/2;
		int res2 = ((b * -1) + (int) Math.sqrt(Math.pow(b, 2) - (4 * c)))/2;

		if (res1 == res2) {
			System.out.println(res1);
		} else {
			System.out.println(res1 + " " + res2);
		}
	}
}