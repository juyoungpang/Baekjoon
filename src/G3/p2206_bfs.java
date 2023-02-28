package G3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2206_bfs {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[N][M];
		boolean[][][] visited = new boolean[2][N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) == '0' ? true : false;
			}
		}

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 1, 0));
		while (!q.isEmpty()) {
			Node node = q.poll(); // r, c, dist, wallBroken

			if (node.r == N - 1 && node.c == M - 1) {
				System.out.println(node.dist);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int newR = node.r + dr[i];
				int newC = node.c + dc[i];

				if (newR < 0 || newR >= N || newC < 0 || newC >= M) {
					continue;
				}

				if (!map[newR][newC]) { // 못가는 벽이라도 만약 부술수 있으면 넣음
					if (node.wallBroken == 0 && !visited[1][newR][newC]) {
						q.offer(new Node(newR, newC, node.dist + 1, 1));
						visited[1][newR][newC] = true;
					}
				} else {
					if (!visited[node.wallBroken][newR][newC]) {
						q.offer(new Node(newR, newC, node.dist + 1, node.wallBroken));
						visited[node.wallBroken][newR][newC] = true;
					}
				}
				
			}
		}
		System.out.println(-1);
	}

	static class Node {
		int r;
		int c;
		int dist;
		int wallBroken;

		public Node(int r, int c, int dist, int wallBroken) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.wallBroken = wallBroken;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", dist=" + dist + ", wallBroken=" + wallBroken + "]";
		}

	}
}