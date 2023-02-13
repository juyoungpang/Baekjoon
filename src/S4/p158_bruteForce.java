package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p158_bruteForce {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tok.nextToken());
		int K = Integer.parseInt(tok.nextToken());

		StringBuilder sb = new StringBuilder("<");

		boolean[] taken = new boolean[N];

		int idx = K - 1;
		for (int i = 0; i < N; i++) {
			taken[idx] = true;
			sb.append(idx + 1).append(", ");

			if (i != N - 1) {
				for (int j = 0; j < K; j++) {
					idx++;
					if (idx == N)
						idx %= N;
					if (taken[idx])
						j--;
				}
			}
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");

		System.out.println(sb);
	}
}