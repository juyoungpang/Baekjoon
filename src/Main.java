import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//17406
public class Main {
	static int N,M,K;
	static int[][] arr;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		K = Integer.parseInt(tok.nextToken());

		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			tok = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		for(int k=0;k<K;k++) {
			tok = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tok.nextToken())-1;
			int c = Integer.parseInt(tok.nextToken())-1;
			int s = Integer.parseInt(tok.nextToken());
			
			rotate(r,c,s);
			
			System.out.println();
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			int total = 0;
			for(int j=0;j<M;j++) {
				total+= arr[i][j];
			}
			ans = Math.min(ans, total);
		}
		
		System.out.println(ans);
	}
	
	public static void rotate(int r, int c, int s) {
		while(s>0) {
			int curR = r-s;
			int curC = c-s;
			int bN = arr[curR][curC];
			int cN = 0;
			for(int i=0;i<4;i++) {
				for(int j=0;j<2*s;j++) {
					int nextR = curR+dr[i];
					int nextC = curC+dc[i];
					cN = arr[nextR][nextC];
					
					arr[nextR][nextC] = bN;
					
					curR = nextR;
					curC = nextC;
					bN = cN;
				}
			}
			s--;
		}
	}
}