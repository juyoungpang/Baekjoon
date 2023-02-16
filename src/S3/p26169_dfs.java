package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p26169_dfs {
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static boolean[][] visited = new boolean[5][5];
	static int[][] board = new int[5][5];
	
	static boolean found;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		for(int i=0;i<5;i++) {
			tok = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				board[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		tok = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(tok.nextToken());
		int c = Integer.parseInt(tok.nextToken());
		visited[r][c] = true;
		
		dfs(0,r,c,0);
		
		System.out.println(found?1:0);
	}
	
	public static void dfs(int depth, int r, int c, int apples) {
		if(found) {
			return;
		}
		if(apples==2) {
			found = true;
			return;
		}
		if(depth==3) {
			return;
		}
		
		for(int d=0;d<4;d++) {
			int newR = r+dr[d];
			int newC = c+dc[d];
			
			if(newR<0 || newR>=5 || newC<0 || newC>=5 || visited[newR][newC] || board[newR][newC]==-1) 
				continue;
			
			visited[newR][newC] = true;
			dfs(depth+1, newR, newC, apples+board[newR][newC]);
			visited[newR][newC] = false;
		}
	}
}