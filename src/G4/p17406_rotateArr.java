package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17406_rotateArr {
	static int N, M, K, ans = Integer.MAX_VALUE;
	static int[][] original, arr, rotates;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		K = Integer.parseInt(tok.nextToken());

		original = new int[N][M];
		rotates = new int[K][3];
		visited = new boolean[K];

		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				original[i][j] = Integer.parseInt(tok.nextToken());
			}
		}

		for (int k = 0; k < K; k++) {
			tok = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tok.nextToken()) - 1;
			int c = Integer.parseInt(tok.nextToken()) - 1;
			int s = Integer.parseInt(tok.nextToken());

			rotates[k][0] = r;
			rotates[k][1] = c;
			rotates[k][2] = s;
		}

		permu(0, new int[K]);

		System.out.println(ans);
	}

	public static void findMin() {
		for (int i = 0; i < N; i++) {
			int total = 0;
			for (int j = 0; j < M; j++) {
				total += arr[i][j];
			}
			ans = Math.min(ans, total);
		}
	}

	public static void permu(int depth, int[] chosen) {
		if (depth == chosen.length) {
			arr = new int[original.length][];
			for(int i=0;i<arr.length;i++) {
				arr[i] = original[i].clone();
			}
			for (int c : chosen) {
				rotate(rotates[c][0], rotates[c][1], rotates[c][2]);
			}

			findMin();
			return;
		}

		for (int i = 0; i < chosen.length; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			chosen[depth] = i;
			permu(depth + 1, chosen);
			visited[i] = false;
		}
	}

	public static void rotate(int r, int c, int s) {
		while (s > 0) {
			int curR = r - s;
			int curC = c - s;
			int bN = arr[curR][curC];
			int cN = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 2 * s; j++) {
					int nextR = curR + dr[i];
					int nextC = curC + dc[i];
					cN = arr[nextR][nextC];

					arr[nextR][nextC] = bN;

					curR = nextR;
					curC = nextC;
					bN = cN;
				}
			}
			s--;
		}
	}
}