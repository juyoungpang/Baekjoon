package G3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1005_topologySort {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int end;
	static List<Integer>[] graph;
	static int[] time, degree, cost;
	
	public static void main(String[] args) throws IOException {
		int TC = nextInt();
		while(TC-->0) {
			int N = nextInt();
			int K = nextInt();
			
			time = new int[N+1];
			for(int i=1;i<time.length;i++) {
				time[i] = nextInt();
			}
			
			graph = new List[N+1];
			for(int i=1;i<graph.length;i++) {
				graph[i] = new ArrayList<>();
			}
			degree = new int[N+1];
			while(K-->0) {
				int from = nextInt();
				int to = nextInt();
				
				graph[from].add(to);
				degree[to]++;
			}
			
			end = nextInt();
			
			sb.append(cost()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int cost() {
		cost = new int[time.length];
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<degree.length;i++) {
			if(degree[i]==0) {
				q.add(i);
				cost[i] = time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();

			if(node == end) {
				break;
			}
			
			for(int connNode : graph[node]) {
				cost[connNode] = Math.max(cost[connNode], cost[node]);
				if(--degree[connNode] == 0) {
					cost[connNode]+=time[connNode];
					q.add(connNode);
				}
			}
			
		}
		
		return cost[end];
	}
	
	public static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}