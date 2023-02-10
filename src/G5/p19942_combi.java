package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p19942_combi {

	static int N, minCost = Integer.MAX_VALUE, r;
	static int[] limpfsv, chosen;
	static int[][] ingredients;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		chosen = new int[N];
		limpfsv = new int[4];
		ingredients = new int[N][5];

		StringTokenizer tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			limpfsv[i] = Integer.parseInt(tok.nextToken());
		}

		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				ingredients[i][j] = Integer.parseInt(tok.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			dfs(0, 0, new boolean[N], new int[i]);
		}

		if (minCost != Integer.MAX_VALUE) {
			StringBuilder sb = new StringBuilder();
			sb.append(minCost).append("\n");
			for (int c : chosen) {
				sb.append(c).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	public static void dfs(int depth, int start, boolean[] visited, int[] c) {
		if (depth == c.length) {
			int cost = 0;
			int[] chosenpfsv = new int[4];
			for (int i = 0; i < c.length; i++) {
				cost += ingredients[c[i] - 1][4];
				for (int j = 0; j < 4; j++) {
					chosenpfsv[j] += ingredients[c[i] - 1][j];
				}
			}

			if (cost > minCost) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				if (chosenpfsv[i] < limpfsv[i]) {
					return;
				}
			}

			if (cost == minCost) {
				int numEquals = 0;
				for (int i = 0; i < chosen.length; i++) {
					if (chosen[i] < c[i]) {
						return;
					} else if(chosen[i]==c[i]) {
						numEquals++;
					}
				}
				
				if(numEquals==chosen.length) 
					return;
			}
			minCost = cost;
			chosen = c.clone();
			return;
		}

		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			c[depth] = i + 1;
			dfs(depth + 1, i + 1, visited, c);
			visited[i] = false;
		}
	}
}