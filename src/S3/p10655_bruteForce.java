package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10655_bruteForce {
	static int[][] ns;
	static int[] manhattan;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ns = new int[N][2];
		manhattan = new int[N];
		int total = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			ns[i][0] = Integer.parseInt(tok.nextToken());
			ns[i][1] = Integer.parseInt(tok.nextToken());

			if (i == 0)
				continue;

			int diff = manhattan(ns[i - 1][0], ns[i - 1][1], ns[i][0], ns[i][1]);
			total += diff;
			manhattan[i - 1] = diff;
		}

		int min = total;

		for (int i = 1; i < N - 1; i++) {
			min = Math.min(min, total - manhattan[i - 1] - manhattan[i]
					+ manhattan(ns[i - 1][0], ns[i - 1][1], ns[i + 1][0], ns[i + 1][1]));
		}
		
		System.out.println(min);

	}

	public static int manhattan(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}