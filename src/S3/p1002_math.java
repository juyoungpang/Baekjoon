package S3;
import java.util.Scanner;

public class p1002_math {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 0; test_case < T; test_case++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();

			double dist = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));

			if (dist == 0) {
				if (r1 == r2) {
					System.out.println(-1);
				} else {
					System.out.println(0);
				}
			} else {
				if (dist > r1 + r2) {
					System.out.println(0);
				} else if (dist == r1 + r2) {
					System.out.println(1);
				} else {
					if (dist + r1 == r2 || dist + r2 == r1) {
						System.out.println(1);
					} else if (dist + r1 < r2 || dist + r2 < r1) {
						System.out.println(0);
					} else {
						System.out.println(2);
					}
				}
			}
		}
	}
}