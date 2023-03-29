package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10971_bruteForce {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, answer = Integer.MAX_VALUE;
	static int[][] W;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		N = nextInt();

		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				W[i][j] = nextInt();
			}
		}

		visited = new boolean[N];
		dfs(0, 1, 0);
		
		System.out.println(answer);
	}

	public static void dfs(int curCity, int depth, int totalCost) {
		if (depth == N) {
			if(W[curCity][0]==0)
				return;
			totalCost+=W[curCity][0];
			answer = Math.min(answer, totalCost);
			return;
		}

		for (int i = 1; i < N; i++) {
			if (visited[i] || W[curCity][i]==0)
				continue;
			visited[i] = true;
			dfs(i, depth + 1, totalCost + W[curCity][i]);
			visited[i] = false;
		}
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}