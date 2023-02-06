package jenna.S3;
import java.util.Scanner;

public class p15651_repeatingPermu {
	static int N, R;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();

		permu(0, new int[R]);
		
		System.out.println(sb);
	}

	public static void permu(int depth, int[] chosen) {
		if (depth == R) {
			for (int c : chosen) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			chosen[depth] = i;
			permu(depth + 1, chosen);
		}
	}
}
