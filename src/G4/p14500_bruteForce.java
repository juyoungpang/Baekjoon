package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14500_bruteForce {

	static int ROW, COL;
	static int[][] board;
	static boolean[][] visited;

	static int max = -1;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		// input
		ROW = Integer.parseInt(tok.nextToken());
		COL = Integer.parseInt(tok.nextToken());
		board = new int[ROW][COL];
		visited = new boolean[ROW][COL];

		for (int i = 0; i < ROW; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < COL; j++) {
				board[i][j] = Integer.parseInt(tok.nextToken());
			}
		} // end of input

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				visited[i][j] = true;
				move(i, j, 1, board[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	public static void move(int row, int col, int depth, int num) {
		for (int i = 0; i < dr.length; i++) {
			int newR = row + dr[i];
			int newC = col + dc[i];

			if (newR < 0 || newR >= ROW || newC < 0 || newC >= COL || visited[newR][newC]) {
				continue;
			}
			if (depth == 3) {
				max = Math.max(num + board[newR][newC], max);
				continue;
			}
			if (depth == 2) {
				visited[newR][newC] = true;
				move(row, col, depth+1, num + board[newR][newC]);
				visited[newR][newC] = false;
			}
			visited[newR][newC] = true;
			move(newR, newC, depth + 1, num + board[newR][newC]);
			visited[newR][newC] = false;
		}
	}

}