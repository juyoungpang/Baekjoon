package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11724_dfs {
	static int N, M;
	static boolean[][] adj;
	static boolean[] visited;
	static StringTokenizer tok;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		N = nextInt();
		M = nextInt();

		adj = new boolean[N][N];
		visited = new boolean[N];
		for (int m = 0; m < M; m++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;
			adj[a][b] = true;
			adj[b][a] = true;
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}

	public static void dfs(int row) {
		visited[row] = true;

		for (int i = 0; i < N; i++) {
			if (visited[i] || !adj[row][i])
				continue;
			dfs(i);
		}
	}

	public static int nextInt() throws IOException {
		if (tok == null || !tok.hasMoreElements())
			tok = new StringTokenizer(br.readLine());
		return Integer.parseInt(tok.nextToken());
	}
}