package G3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1600_bruteForce {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] horseMove = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 2, -1 }, { 2, 1 },
			{ 1, 2 } }; // drdc
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // drdc

	static int W, H, K;
	static int[][] board;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		K = nextInt();
		W = nextInt();
		H = nextInt();
		board = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				board[i][j] = nextInt();
			}
		}
		visited = new boolean[H][W][K+1];

		Queue<int[]> movements = new LinkedList<>();
		movements.offer(new int[] { 0, 0, 0, 0 }); // row, col, dist, K
		visited[0][0][0] = true;
		while (!movements.isEmpty()) {
			int[] m = movements.poll();
			int row = m[0];
			int col = m[1];
			int dist = m[2];
			int k = m[3];

			if (row == H - 1 && col == W - 1) {
				System.out.println(dist);
				return;
			}

			if (k < K) {
				for (int i = 0; i < horseMove.length; i++) {
					int newRow = row + horseMove[i][0];
					int newCol = col + horseMove[i][1];					
					if (isValid(newRow, newCol) && !visited[newRow][newCol][k+1] && board[newRow][newCol] != 1) {
						visited[newRow][newCol][k+1] = true;
						movements.offer(new int[] { newRow, newCol, dist + 1, k + 1 });
					}
				}
			}
			for (int i = 0; i < move.length; i++) {
				int newRow = row + move[i][0];
				int newCol = col + move[i][1];
				if (isValid(newRow, newCol) && !visited[newRow][newCol][k] && board[newRow][newCol] != 1) {
					visited[newRow][newCol][k] = true;
					movements.offer(new int[] { newRow, newCol, dist + 1, k });
				}
			}
		}

		System.out.println(-1);
	}

	public static boolean isValid(int row, int col) {
		return row >= 0 && col >= 0 && row < H && col < W;
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}