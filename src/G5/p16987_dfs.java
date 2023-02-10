package G5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16987_dfs {
	static int N, answer;
	static int[][] eggSW; // 내구도, 무게

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		eggSW = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());

			eggSW[i][0] = Integer.parseInt(tok.nextToken());
			eggSW[i][1] = Integer.parseInt(tok.nextToken());
		}

		dfs(0, 0);

		System.out.println(answer);
	}

	// 새로 깨진게 몇개인지 셈
	public static int crack(int e1, int e2) {
		eggSW[e1][0] -= eggSW[e2][1];
		eggSW[e2][0] -= eggSW[e1][1];

		int numCracked = 0;

		if (eggSW[e1][0] <= 0) {
			numCracked++;
		}

		if (eggSW[e2][0] <= 0) {
			numCracked++;
		}

		return numCracked;
	}

	public static void unCrack(int e1, int e2) {
		eggSW[e1][0] += eggSW[e2][1];
		eggSW[e2][0] += eggSW[e1][1];
	}

	public static void dfs(int depth, int numCracked) {
		// 끝까지 도착했으면 cracked 갯수 세기
		if (depth == N) {
			answer = Math.max(answer, numCracked);
			return;
		}

		// 내가 깨졌으면 그냥 다음으로 내려가야하네
		// 아니면 더이상 깰게 없다면
		if (eggSW[depth][0] <= 0 || numCracked >= N - 1) {
			dfs(depth + 1, numCracked);
			return;
		}

		for (int i = 0; i < N; i++) {
			// 가장 왼쪽 계란 집음 (depth 위치)

			// 안깨는 경우
			// 깨려는 애가 깨졌거나
			// 내가 나를 깨려고 하는 경우
			if (depth == i || eggSW[i][0] <= 0) {
				continue;
			}

			// 왼쪽부터 하나씩 깨보기 -> crack
			int newlyCracked = crack(i, depth);
			// crack된 상태로 permu들어감
			dfs(depth + 1, numCracked + newlyCracked);
			// permu밑에선 uncrack해서 상태 복구
			unCrack(i, depth);
		}
	}
}