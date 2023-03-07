package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17281_permu {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][] scores;
	static int answer;

	public static void main(String[] args) throws IOException {
		int innings = nextInt();
		scores = new int[innings][9];
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[0].length; j++) {
				scores[i][j] = nextInt();
			}
		}

		permu(0, 0);

		System.out.println(answer);
	}

	static int[] chosen = new int[9];

	public static void permu(int depth, int flag) {
		if (depth == 9) { // 이미 다 뽑음, 즉, 마지막애까지 다 뽑았음
			int score = 0;
			int position = 0;
			for (int inning = 0; inning < scores.length; inning++) {
				int f1 = -1;
				int f2 = -1;
				int f3 = -1;
				int numOut = 0;

				while (numOut < 3) {
					switch (scores[inning][chosen[position]]) {
					case 0: // 아웃
						numOut++;
						break;
					case 1: // 안타
						if (f3 != -1) {
							score++;
						}
						f3 = f2;
						f2 = f1;
						f1 = chosen[position];
						break;
					case 2: // 2루타
						if (f3 != -1) {
							score++;
						}
						if (f2 != -1) {
							score++;
						}
						f3 = f1;
						f2 = chosen[position];
						f1 = -1;
						break;
					case 3: // 3루타
						if (f3 != -1) {
							score++;
						}
						if (f2 != -1) {
							score++;
						}
						if (f1 != -1) {
							score++;
						}
						f3 = chosen[position];
						f2 = f1 = -1;
						f1 = -1;
						break;
					case 4: // 4루타
						if (f1 != -1) {
							score++;
						}
						if (f2 != -1) {
							score++;
						}
						if (f3 != -1) {
							score++;
						}
						score++;
						f3 = f2 = f1 = -1;
						break;
					}
					position = (position + 1) % 9;
				}
			}
			
			answer = Math.max(answer, score);
			return;
		}

		if (depth == 3) {
			permu(depth + 1, flag | 1);
		} else {
			for (int i = 1; i < 9; i++) {
				if ((flag & 1 << i) != 0) {
					continue;
				}

				chosen[depth] = i;
				permu(depth + 1, flag | 1 << i);
			}
		}
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());

		return Integer.parseInt(st.nextToken());
	}
}