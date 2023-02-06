package jenna.S3;
import java.util.Scanner;

public class p15652_repeatingCombi {
	static int N, R;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();

		combi(0, 1, new int[R]);

		System.out.println(sb);
	}

	public static void combi(int depth, int start, int[] chosen) {
		if (depth == R) {
			for (int c : chosen) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			chosen[depth] = i;
			combi(depth + 1, i, chosen);
		}
	}
}
