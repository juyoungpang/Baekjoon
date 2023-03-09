package G2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17835_reverseDijkstra {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;
	static long[] dist;
	static List<Edge>[] graph; // graph of reverse edges

	static class Edge {
		int node;
		int cost;

		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [node=" + node + ", cost=" + cost + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		N = nextInt();
		int M = nextInt();
		int K = nextInt();

		dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		graph = new List[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		while (M-- > 0) {
			int from = nextInt();
			int to = nextInt();
			int cost = nextInt();

			graph[to].add(new Edge(from, cost));
		}

		while (K-- > 0) {
			dijkstra(nextInt());
		}

		int maxIdx = -1;
		long maxVal = -1;
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] > maxVal) {
				maxIdx = i;
				maxVal = dist[i];
			}
		}
		System.out.println(maxIdx);
		System.out.println(maxVal);
	}

	public static void dijkstra(int start) {
		Queue<Edge> q = new ArrayDeque<>();
		q.add(new Edge(start, 0));
		dist[start] = 0;

		while (!q.isEmpty()) {
			Edge curEdge = q.poll();

			for (Edge conEdge : graph[curEdge.node]) {
				if (dist[conEdge.node] > dist[curEdge.node] + conEdge.cost) {
					dist[conEdge.node] = dist[curEdge.node] + conEdge.cost;
					q.offer(conEdge);
				}
			}
		}
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}