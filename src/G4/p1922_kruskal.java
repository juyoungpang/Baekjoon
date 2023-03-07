package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1922_kruskal {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int answer;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();
	
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int weight;

		public Edge(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int M = nextInt();
		
		parent = new int[N+1];
		for(int i=1;i<parent.length;i++) {
			parent[i] = i;
		}
		
		while(M-->0) {
			edges.offer(new Edge(nextInt(),nextInt(),nextInt()));
		}
		
		while(!edges.isEmpty()) {
			Edge edge = edges.poll();
			if(find(edge.a)==find(edge.b))
				continue;
			
			union(edge.a, edge.b);
			answer+=edge.weight;
		}
		
		System.out.println(answer);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
	
	public static int find(int a) {
		if(parent[a]==a) {
			return a;
		}
		
		return parent[a] = find(parent[a]);
	}
	
	public static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
		}
		
		return Integer.parseInt(st.nextToken());
	}
}