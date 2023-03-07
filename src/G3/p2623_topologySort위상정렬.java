package G3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2623_topologySort위상정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int M = nextInt();
		
		List<Integer>[] graph = new List[N+1];
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		int[] incoming = new int[N+1];
		while(M-->0) {
			int count = nextInt()-1;
			int from = nextInt();
			while(count-->0) {
				int to = nextInt();
				incoming[to]++;
				graph[from].add(to);
				from = to;
			}
		}
		
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<N+1;i++) {
			if(incoming[i]==0) {
				q.offer(i);
			}
		}
		
		List<Integer> answer = new ArrayList<>();
		while(!q.isEmpty()) {
			int node = q.poll();
			answer.add(node);
			for(int connectedNode:graph[node]) {
				incoming[connectedNode]--;
				if(incoming[connectedNode]==0) {
					q.offer(connectedNode);
				}
			}
		}
		
		if(answer.size()!=N) {
			System.out.println(0);
		} else {
			for(int n:answer) {
				sb.append(n).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements()) 
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}