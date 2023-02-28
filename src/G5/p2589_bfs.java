package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2589_bfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	// 상 하 좌 우
	static int[][] drdc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int answer, N, M;
	static boolean[][] map, visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) == 'L';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i][j])
					continue;
				visited = new boolean[N][M];
				bfs(i, j);
			}
		}

		System.out.println(answer);
	}

	public static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { row, col, 0 });

		while (!q.isEmpty()) {
			int[] point = q.poll();
			visited[point[0]][point[1]] = true;
			answer = Math.max(answer, point[2]);
			for (int d = 0; d < drdc.length; d++) {
				int newR = point[0] + drdc[d][0];
				int newC = point[1] + drdc[d][1];

				if (!isValid(newR, newC))
					continue;

				q.offer(new int[] { newR, newC, point[2] + 1 });
				visited[newR][newC] = true;
			}
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && map[r][c] && !visited[r][c];
	}
}