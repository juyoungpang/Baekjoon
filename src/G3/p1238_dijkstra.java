package G3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1238_dijkstra {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] dist;
	static List<Edge>[] graph;

	static class Edge implements Comparable<Edge> {
		int dest;
		int cost;

		public Edge(int dest, int cost) {
			super();
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		N = nextInt();
		int M = nextInt();
		int X = nextInt();

		graph = new List[N + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		while (M-- > 0) {
			int from = nextInt();
			int to = nextInt();
			int cost = nextInt();
			graph[from].add(new Edge(to, cost));
		}

		int[] totalDist = new int[N+1];
		
		for(int i=1;i<N+1;i++) {
			dijkstra(i);
			
			if(i==X) {
				for(int j=1;j<N+1;j++) {
					totalDist[j]+=dist[j];
				}
			} else {
				totalDist[i]+=dist[X];
			}
		}
		
		Arrays.sort(totalDist);
		
		System.out.println(totalDist[N]);
	}
	
	public static void dijkstra(int start) {
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		boolean[] visited = new boolean[N + 1];
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visited[now.dest])
				continue;

			visited[now.dest] = true;
			for (Edge e : graph[now.dest]) {
				if(dist[e.dest] > dist[now.dest]+e.cost) {
					dist[e.dest] = dist[now.dest]+e.cost; 
					pq.offer(new Edge(e.dest, dist[e.dest]));
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