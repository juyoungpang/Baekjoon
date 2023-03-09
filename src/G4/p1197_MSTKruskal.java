package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1197_MSTKruskal {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int V, E;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();
	static int[] p;

	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		long c;

		public Edge(int a, int b, long c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return (int) (this.c - o.c);
		}
	}

	public static void main(String[] args) throws IOException {
		V = nextInt();
		E = nextInt();
		
		p = new int[V+1];
		for(int i=1;i<p.length;i++) {
			p[i] = i;
		}

		for (int e = 0; e < E; e++) {
			edges.offer(new Edge(nextInt(),nextInt(),nextInt()));
		}
		
		long answer = 0;
		while(!edges.isEmpty()) {
			Edge e = edges.poll();
			
			if(find(e.a)==find(e.b))
				continue;
			
			union(e.a, e.b);
			answer+=e.c;
		}
		
		System.out.println(answer);
	}
	
	public static int find(int x) {
		if(x==p[x])
			return x;
		
		return p[x] = find(p[x]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b)
			return;
		
		if(a>=b) 
			p[a] = b;
		else
			p[b] = a;
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}