package G3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2252_topologySort {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] degree;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		N = nextInt();
		M = nextInt();
		
		degree = new int[N+1];
		graph = new List[N+1];
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int m=0;m<M;m++) {
			int front = nextInt();
			int back = nextInt();
			
			graph[front].add(back);
			degree[back]++;
		}
		
		topologySort();
		
		System.out.println(sb.toString());
	}
	
	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<degree.length;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			sb.append(node).append(" ");
			
			for (int connNodes:graph[node]) {
				if(--degree[connNodes]==0) {
					q.offer(connNodes);
				}
			}
		}
	}
	
	public static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}