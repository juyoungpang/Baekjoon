package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p24484_dfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static PriorityQueue<Integer>[] graph;
	static boolean[] visited;
	static long ans, cnt;

	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int M = nextInt();
		int R = nextInt();

		visited = new boolean[N + 1];

		graph = new PriorityQueue[N + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new PriorityQueue<>(Collections.reverseOrder());
		}

		while (M-- > 0) {
			int a = nextInt();
			int b = nextInt();

			graph[a].add(b);
			graph[b].add(a);
		}

		visited[R] = true;
		dfs(R, 0);

		System.out.println(ans);
	}

	public static void dfs(int node, int d) {
		visited[node] = true;
		cnt++;
		ans += (cnt * d);
		while (!graph[node].isEmpty()) {
			int n = graph[node].poll();
			if (visited[n])
				continue;
			dfs(n, d + 1);
		}
	}

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}