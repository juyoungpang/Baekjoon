package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1647_kruskal {
	
	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int cost;

		public Edge(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int answer;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();
	static int[] p;

	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int M = nextInt();

		p = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			p[i] = i;
		}

		while (M-- > 0) {
			int a = nextInt();
			int b = nextInt();
			int cost = nextInt();
			edges.offer(new Edge(a, b, cost));
		}

		int max = 0;

		while (!edges.isEmpty()) {
			Edge edge = edges.poll();
			if (find(edge.a) == find(edge.b))
				continue;
			union(edge.a, edge.b);
			max = Math.max(edge.cost, max);
			answer += edge.cost;
		}

		System.out.println(answer-max);
	}

	public static int find(int a) {
		if (a == p[a])
			return a;

		return p[a] = find(p[a]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			if (a > b)
				p[a] = b;
			else
				p[b] = a;
		}
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}