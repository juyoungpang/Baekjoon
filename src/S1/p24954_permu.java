package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p24954_permu {
	static int N;
	static int[][][] dcs; // item [ [discountedItems(index),discountedPrice] ]
	static int[] costs;

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		costs = new int[N];
		StringTokenizer tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(tok.nextToken());
		}

		dcs = new int[N][][];
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(br.readLine());
			if (p == 0)
				continue;

			dcs[i] = new int[p][2];

			for (int j = 0; j < p; j++) {
				tok = new StringTokenizer(br.readLine());
				dcs[i][j][0] = Integer.parseInt(tok.nextToken()) - 1; // index
				dcs[i][j][1] = Integer.parseInt(tok.nextToken());
			}
		}

		permu(0, new int[N], new boolean[N]);

		System.out.println(answer);
	}

	public static void permu(int depth, int[] chosen, boolean[] visited) {
		if (depth == N) {
			int cost = 0;
			
			int[] cs = costs.clone();

			for (int c : chosen) {
				cost += cs[c];
				if (dcs[c] == null)
					continue;
				for (int[] dc : dcs[c]) {
					cs[dc[0]] -= dc[1];
					if (cs[dc[0]] < 1)
						cs[dc[0]] = 1;
				}
			}

			answer = Math.min(answer, cost);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			chosen[depth] = i;
			permu(depth + 1, chosen, visited);
			visited[i] = false;
		}
	}
}