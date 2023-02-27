package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10451_dfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static boolean[] visited;
	static int[] graph;
	static int numCycle;
	
	public static void main(String[] args) throws IOException {
		int TTC = nextInt();
		while(TTC-->0) {
			int N = nextInt();
			numCycle = 0;
			visited = new boolean[N];
			graph = new int[N];
			for(int i=0;i<N;i++) {
				graph[i] = nextInt()-1;
			}
			
			for(int i=0;i<N;i++) {
				if(!visited[i]) {
					run(i);
				}
			}
			sb.append(numCycle).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void run(int idx) {
		visited[idx] = true;
		if(visited[graph[idx]]) { // 만약 연결되어있는게 이미 탐색한 점임 --> 싸이클
			numCycle++;
		} else {
			run(graph[idx]);
		}
	}
	
	public static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(st.nextToken());
	}
}