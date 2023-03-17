package G4;

import java.util.*;
import java.io.*;

public class p1753_dijkstra {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;

	static int V, E, start;
	static int[] dist;
	static List<Edge>[] list;

	static class Edge implements Comparable<Edge> {
		int destinationNode;
		int weight;

		public Edge(int id, int weight) {
			this.destinationNode = id;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		V = nextInt(); // 정점 개수
		E = nextInt(); // 간선 개수
		start = nextInt(); // 시작 정점

		// 거리배열 INF로 초기화
		dist = new int[V + 1]; // 거리배열
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 리스트 초기화
		list = new ArrayList[V + 1]; // 인접 정점 리스트
		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < E + 1; i++) {
			int u = nextInt();
			int v = nextInt();
			int w = nextInt();
			list[u].add(new Edge(v, w));
		}

		dijkstra();

		// output
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			if (dist[i] < Integer.MAX_VALUE)
				sb.append(dist[i] + "\n");
			else
				sb.append("INF\n");
		}
		System.out.println(sb.toString());
	}

	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.weight > dist[cur.destinationNode])
				continue; // 현재 weight가 dist에 저장된 weight보다 크면 갱신할 필요가 없다.
			for (Edge next : list[cur.destinationNode]) {
				int nextW = next.weight + cur.weight;
				if (dist[next.destinationNode] > nextW) { // 만약 dist에 저장된 next의 weight가 cur에서 next로가는 weight보다 크다면 갱신.
					dist[next.destinationNode] = nextW;
					pq.add(new Edge(next.destinationNode, dist[next.destinationNode]));
				}
			}
		}
	}

	public static int nextInt() throws IOException {
		if (tok == null || !tok.hasMoreElements())
			tok = new StringTokenizer(br.readLine());
		return Integer.parseInt(tok.nextToken());
	}
}