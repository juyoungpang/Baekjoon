package G3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15684_dfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static boolean[][] connected;
	
	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int M = nextInt();
		int H = nextInt();
		
		connected = new boolean[H][N-1];
		
		while(M-->0) {
			connected[nextInt()-1][nextInt()-1] = true;
		}
		
		dfs(0,0,0);
		
		System.out.println(answer==4?-1:answer);
	}
	
	static int answer = 4;
	
	public static void dfs(int r, int c, int depth) {
		if(check()) {
			answer = Math.min(answer, depth);
		}
		
		if(depth==3) 
			return;
		
		for(int i=r;i<connected.length;i++) {
			for(int j=c;j<connected[0].length;j++) {
				if(connected[i][j])
					continue;
				
				if(j-1>=0 && connected[i][j-1])
					continue;
				
				if(j+1<connected[0].length && connected[i][j+1])
					continue;
				
				connected[i][j] = true;
				dfs(r, c+1, depth+1);
				connected[i][j] = false;
			}
		}
	}
	
	public static boolean check() {
		for(int num=0; num<connected[0].length; num++) {
			int pointer = num;
			for(int row = 0; row<connected.length; row++) {
				// 왼쪽
				if(pointer-1>=0 && connected[row][pointer-1])
					pointer--;
				// 오른쪽
				else if(pointer<connected[0].length && connected[row][pointer])
					pointer++;
			}
			if(pointer!=num)
				return false;
		}
		
		return true;
	}
	
	public static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		
		return Integer.parseInt(st.nextToken());
	}
}