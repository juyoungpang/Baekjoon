package S1;
import java.util.Scanner;

public class p1074_divConq {
	static int num, N, R, C, answer = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int) (Math.pow(2, sc.nextInt()));
		R = sc.nextInt();
		C = sc.nextInt();

		run(N, 0, 0);

		System.out.println(answer);
	}

	public static void run(int n, int r, int c) {
		if (answer != -1)
			return;

		if (r == R && c == C) {
			answer = num;
			return;
		}

		if (n == 1) {
			num++;
			return;
		}

		boolean rRight = R >= r + n / 2;
		boolean cDown = C >= c + n / 2;

		if (!rRight && !cDown) {
			run(n / 2, r, c);
		} else {
			num += ((n * n) / 4);
		}
		if (!rRight && cDown) {
			run(n / 2, r, c + n / 2);
		} else {
			num += ((n * n) / 4);
		}
		if (rRight && !cDown) {
			run(n / 2, r + n / 2, c);
		} else {
			num += ((n * n) / 4);
		}
		if (rRight && cDown) {
			run(n / 2, r + n / 2, c + n / 2);
		} else {
			num += ((n * n) / 4);
		}
	}
}