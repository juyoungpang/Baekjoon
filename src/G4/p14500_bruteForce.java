package G4;

import java.util.*;
import java.io.*;

public class p14500_bruteForce {

	static int[][] map;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static int N, M;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				combi(i, j, map[i][j], 1);
				visited[i][j] = false;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void combi(int row, int col, int sum, int depth) {
		if (depth == 4) {
			max = Math.max(sum, max);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int newR = row + dr[i];
			int newC = col + dc[i];

			if (newR < 0 || newC < 0 || newR >= N || newC >= M)
				continue;

			if (!visited[newR][newC]) {
				if (depth == 2) {
					visited[newR][newC] = true;
					combi(row, col, sum + map[newR][newC], depth + 1);
					visited[newR][newC] = false;
				}

				visited[newR][newC] = true;
				combi(newR, newC, sum + map[newR][newC], depth + 1);
				visited[newR][newC] = false;
			}
		}
	}

}
