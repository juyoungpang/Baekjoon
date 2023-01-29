package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14500_시간초과 {
	
	static int ROW, COL;
	static int[][] board;
	
	static int max = -1;
	
	// 하 좌 우
	static int[] dr = {1, 0, 0};
	static int[] dc = {0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		// input
		ROW = Integer.parseInt(tok.nextToken());
		COL = Integer.parseInt(tok.nextToken());
		board = new int[ROW][COL];
		
		for(int i=0;i<ROW;i++) {
			tok = new StringTokenizer(br.readLine());
			for(int j=0;j<COL;j++) {
				board[i][j] = Integer.parseInt(tok.nextToken());
			}
		} // end of input
		
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++) {
				move(i, j, 1, board[i][j], new boolean[ROW][COL]);
				move2(i,j);
			}
		}
		
		System.out.println(max);
	}
	
	public static void move(int row, int col, int depth, int num, boolean[][] visited) {
		if(depth == 1) {
			visited[row][col] = true;
		}
		
		if(depth == 4) {
			max = Math.max(num, max);
			return;
		}
		
		for(int i=0;i<dr.length;i++) {
			int newR = row+dr[i];
			int newC = col+dc[i];
			
			if(newR >= ROW || newC < 0 || newC >= COL || visited[newR][newC]) {
				continue;
			}
			visited[newR][newC] = true;
			move(newR, newC, depth+1, num+board[newR][newC], visited);
			visited[newR][newC] = false;
		}
	}
	
	public static void move2(int row, int col) {
		int up = row-1;
		int down = row+1;
		int left = col-1;
		int right = col+1;
		
		try {
			max = Math.max(board[row][col]+board[up][col]+board[row][left]+board[row][right], max);
		} catch (ArrayIndexOutOfBoundsException e) {}
		try {
			max = Math.max(board[row][col]+board[up][col]+board[down][col]+board[row][right], max);
		} catch (ArrayIndexOutOfBoundsException e) {}
		try {
			max = Math.max(board[row][col]+board[up][col]+board[row][left]+board[down][col], max);
		} catch (ArrayIndexOutOfBoundsException e) {}
		try {
			max = Math.max(board[row][col]+board[down][col]+board[row][left]+board[row][right], max);
		} catch (ArrayIndexOutOfBoundsException e) {}
		try {
			max = Math.max(board[row][col]+board[down][col]+board[down][right]+board[row][right], max);
		} catch (ArrayIndexOutOfBoundsException e) {}
	}
}