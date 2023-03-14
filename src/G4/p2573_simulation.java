package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2573_simulation {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] board;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	static boolean allMelted = false;

	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int M = nextInt();

		board = new int[N][M];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = nextInt();
			}
		}

		int year = 1;
		while (!allMelted) {
			melt();
			if (isSplit()) {
				System.out.println(year);
				return;
			}
			year++;
		}

		System.out.println(0);
	}

	public static int[][] copyArr() {
		int[][] newArr = new int[board.length][board[0].length];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = board[i].clone();
		}
		return newArr;
	}

	public static void melt() {
		int[][] tempArr = copyArr();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int count = 0;
				for (int d = 0; d < dr.length; d++) {
					int newR = i + dr[d];
					int newC = j + dc[d];
					if (!isValid(newR, newC) || board[newR][newC] != 0)
						continue;

					count++;
				}
				tempArr[i][j] -= count;
				if (tempArr[i][j] < 0)
					tempArr[i][j] = 0;
			}
		}

		board = tempArr;
	}

	public static boolean isSplit() {
		visited = new boolean[board.length][board[0].length];
		boolean flag = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!flag) {
					if (board[i][j] > 0) {
						flag = true;
						visited[i][j] = true;
						dfs(i, j);
					}
				} else {
					if (board[i][j] > 0 && !visited[i][j])
						return true;
				}
			}
		}

		if (!flag) {
			allMelted = true;
		}

		return false;
	}

	public static void dfs(int r, int c) {
		for (int d = 0; d < dr.length; d++) {
			int newR = r + dr[d];
			int newC = c + dc[d];
			if (!isValid(newR, newC) || visited[newR][newC] || board[newR][newC] == 0)
				continue;
			visited[newR][newC] = true;
			dfs(newR, newC);
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}