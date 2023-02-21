package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6987_backTracking {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;
	static StringBuilder sb = new StringBuilder();

	static int[][] score;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		for (int TC = 0; TC < 4; TC++) {
			score = new int[6][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					score[i][j] = nextInt();
				}
			}

			flag = false;
			rec(0, 1);

			if (flag) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append(" ");
		}

		System.out.println(sb.toString());
	}

	public static void rec(int checking, int current) {
		if (checking == 5) {
			for (int[] r : score)
				for (int n : r)
					if (n != 0)
						return;

			flag = true;
			return;
		}

		if (current == 6) {
			rec(checking + 1, checking + 2);
			return;
		}

		// 이겼거나
		if (score[checking][0] > 0 && score[current][2] > 0) {
			score[checking][0]--;
			score[current][2]--;
			rec(checking, current + 1);
			score[checking][0]++;
			score[current][2]++;
		}
		// 비겼거나
		if (score[checking][1] > 0 && score[current][1] > 0) {
			score[checking][1]--;
			score[current][1]--;
			rec(checking, current + 1);
			score[checking][1]++;
			score[current][1]++;
		}
		// 졌거나
		if (score[checking][2] > 0 && score[current][0] > 0) {
			score[checking][2]--;
			score[current][0]--;
			rec(checking, current + 1);
			score[checking][2]++;
			score[current][0]++;
		}
	}

	public static int nextInt() throws IOException {
		if (tok == null || !tok.hasMoreElements()) {
			tok = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(tok.nextToken());
	}
}