package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2644_bfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;
	static boolean[][] adj;
	static boolean[] visited;
	static int A,B,N,M;
	public static void main(String[] args) throws IOException {
		N = nextInt();
		A = nextInt()-1;
		B = nextInt()-1;
		M = nextInt();
		
		adj = new boolean[N][N];
		visited = new boolean[N];
		
		for(int m=0;m<M;m++) {
			int i = nextInt()-1;
			int j = nextInt()-1;
			
			adj[i][j] = true;
			adj[j][i] = true;
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0,A});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			visited[cur[1]] = true;
			
			if(cur[1]==B) {
				System.out.println(cur[0]);
				return;
			}
			
			for(int i=0;i<N;i++) {
				if(visited[i] || !adj[cur[1]][i])
					continue;
				
				q.offer(new int[] {cur[0]+1,i});
			}
		}
		
		System.out.println(-1);
	}
	
	public static int nextInt() throws IOException {
		if(tok==null||!tok.hasMoreElements()) {
			tok = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(tok.nextToken());
	}
}