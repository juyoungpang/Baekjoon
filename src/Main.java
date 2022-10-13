import java.util.*;
import java.io.*;

public class Main {

	static int R, C, T;
	static int mTop = -1, mBottom = -1;

	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		R = Integer.parseInt(tok.nextToken());
		C = Integer.parseInt(tok.nextToken());
		T = Integer.parseInt(tok.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tok.nextToken());
				if (map[i][j] == -1) {
					if (mTop == -1)
						mTop = i;
					else
						mBottom = i;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			expand();
			circulateTop();
			circulateBottom();
		}
		
		System.out.println(count());
	}

	public static void expand() {
		int[][] temp = new int[R][];
		for (int i = 0; i < map.length; i++) {
			temp[i] = map[i].clone();
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] > 0) {
					int count = 0;
					for (int k = 0; k < 4; k++) {
						int newR = i + dr[k];
						int newC = j + dc[k];

						if (newR < 0 || newC < 0 || newR >= R || newC >= C || map[newR][newC] != 0)
							continue;

						temp[newR][newC] += map[i][j] / 5;
						count++;
					}
					temp[i][j] = temp[i][j]-(temp[i][j] / 5) * count;
				}
			}
		}
		map = temp;
	}

	
	public static void circulateTop() {
		int curR = mTop - 1;
		int curC = 0;
		int nextR = curR - 1;
		int nextC = 0;

		// 0 아래, 1 왼쪽, 2 위, 3 오른쪽
		int dir = 0;

		while (!(curR == mTop && curC == 0)) {
			if (nextR == -1) {
				nextR = 0;
				nextC = 1;
				dir = 1;
			} 
			if (nextC == C) {
				nextR = 1;
				nextC = C - 1;
				dir = 2;
			}
			if (nextR == mBottom) {
				nextR = mTop;
				nextC = C - 2;
				dir = 3;
			}

			map[curR][curC] = map[nextR][nextC];

			switch (dir) {
			case 0:
				nextR--;
				curR--;
				break;
			case 1:
				nextC++;
				curC++;
				break;
			case 2:
				nextR++;
				curR++;
				break;
			default:
				nextC--;
				curC--;
				break;
			}

			
		}
		map[mTop][1] = 0;
	}

	public static void circulateBottom() {
		int curR = mBottom + 1;
		int curC = 0;
		int nextR = curR + 1;
		int nextC = 0;

		// 0 아래, 1 왼쪽, 2 위, 3 오른쪽
		int dir = 2;

		while (!(curR == mBottom && curC == 0)) {
			if (nextR == R) {
				nextR = R - 1;
				nextC = 1;
				dir = 1;
			} 
			if (nextC == C) {
				nextR = R-2;
				nextC = C - 1;
				dir = 0;
			} 
			if (nextR == mTop) {
				nextR = mBottom;
				nextC = C - 2;
				dir = 3;
			}

			map[curR][curC] = map[nextR][nextC];

			switch (dir) {
			case 0:
				nextR--;
				curR--;
				break;
			case 1:
				nextC++;
				curC++;
				break;
			case 2:
				nextR++;
				curR++;
				break;
			default:
				nextC--;
				curC--;
				break;
			}

			
		}
		map[mBottom][1] = 0;
	}

	public static int count() {
		int ret = 0;
		for(int[] row:map) {
			for(int num:row) {
				if(num!=-1) ret+=num;
			}
		}
		return ret;
	}
}
