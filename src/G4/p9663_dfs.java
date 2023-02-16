package G4;
import java.util.Scanner;

public class p9663_dfs {
	static boolean[] row, col;
	static boolean[][] leftUp, leftDown;
	static int N, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		row = new boolean[N];
		col = new boolean[N];
		leftUp = new boolean[N][N];
		leftDown = new boolean[N][N];

		run(0, 0);

		System.out.println(answer);
	}

	public static void run(int r, int depth) {
		if (depth == N) {
			answer++;
			return;
		}

		for (int j = 0; j < N; j++) {
			int lUi = r - Math.min(r, j);
			int lUj = j - Math.min(r, j);
			int lDi = r + Math.min(N - r - 1, j);
			int lDj = j - Math.min(N - r - 1, j);

			if (row[r] || col[j] || leftUp[lUi][lUj] || leftDown[lDi][lDj]) {
				continue;
			}
			row[r] = true;
			col[j] = true;
			leftUp[lUi][lUj] = true;
			leftDown[lDi][lDj] = true;
			run(r+1, depth + 1);
			row[r] = false;
			col[j] = false;
			leftUp[lUi][lUj] = false;
			leftDown[lDi][lDj] = false;
		}
	}
}