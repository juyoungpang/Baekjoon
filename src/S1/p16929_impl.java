package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16929_impl {

	static int[][] drdc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tok.nextToken());
		int M = Integer.parseInt(tok.nextToken());
		int R = Integer.parseInt(tok.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(tok.nextToken());
			}
		}

		for (int r = 0; r < R; r++) {
			rotate();
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void rotate() {
		for (int s = 0; s < Math.min(board.length, board[0].length) / 2; s++) {
			int dir = 0;
			int r = s;
			int c = s;
			int startTemp = board[s][s];
			while(true) {				
				int nextR = r + drdc[dir][0];
				int nextC = c + drdc[dir][1];
				
				while(nextR<s || nextR>=board.length-s || nextC<s || nextC>=board[0].length-s) {
					dir = (dir+1)%4;
					nextR = r+drdc[dir][0];
					nextC = c+drdc[dir][1];
				}
				
				if(nextR==s && nextC==s) {
					board[r][c] = startTemp;
					break;
				}
				
				board[r][c] = board[nextR][nextC];
				r = nextR;
				c = nextC;
			}
		}
	}
}