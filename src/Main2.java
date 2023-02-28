import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//p1726 그냥 첨부터 해라.. 꼬임
public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int LEFT = -1;
	static final int RIGHT = 1;

	static int[][] map;
	static int R, C, startR, startC, startD, endR, endC, endD;

	// 동남서북 -> 주어지는건 동서남북
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		R = nextInt();
		C = nextInt();

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = nextInt() * -1;
				if (map[i][j] == 0) {
					map[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		startR = nextInt() - 1;
		startC = nextInt() - 1;
		startD = nextInt() - 1;
		if (startD == 1) { // 서 -> 남
			startD = 2;
		} else if (startD == 2) { // 남 -> 서
			startD = 1;
		}

		endR = nextInt() - 1;
		endC = nextInt() - 1;
		endD = nextInt() - 1;
		if (endD == 1) {
			endD = 2;
		} else if (endD == 2) {
			endD = 1;
		}

		simulate();

	}

	static Queue<int[]> q = new LinkedList<>(); // row, col, dir, numMethod

	public static void simulate() {
		q.offer(new int[] { startR, startC, startD, 0 });
		map[startR][startC] = -1;

		while (!q.isEmpty()) {
			int[] robot = q.poll();
			int r = robot[0];
			int c = robot[1];
			int d = robot[2];
			int num = robot[3];

			if (r == endR && c == endC && d == endD) {
				System.out.println(num);
				return;
			}

			// 제자리에서 앞으로
			simulMove(r, c, d, num);

			// 오른쪽으로 한번
			q.offer(new int[] { r, c, turn(d, RIGHT), num + 1 });
			// 왼쪽으로 한번
			q.offer(new int[] { r, c, turn(d, LEFT), num + 1 });
			// 오른쪽으로 두번
			q.offer(new int[] { r, c, turn(d, RIGHT * 2), num + 2 });
		}
	}

	public static void simulMove(int r, int c, int d, int num) {
		for (int k = 1; k <= 3; k++) {
			int newR = goR(r, d, k);
			int newC = goC(c, d, k);
			if (!isValid(newR, newC) || map[newR][newC] == -1)
				continue;
			if (map[newR][newC] > num + 1) {
				q.offer(new int[] { newR, newC, d, num + 1 });
				map[newR][newC] = num + 1;

				// 오른쪽으로 한번
				q.offer(new int[] { r, c, turn(d, RIGHT), num + 2 });
				// 왼쪽으로 한번
				q.offer(new int[] { r, c, turn(d, LEFT), num + 2 });
				// 오른쪽으로 두번
				q.offer(new int[] { r, c, turn(d, RIGHT * 2), num + 3 });
			}
		}
	}

	// 왼쪽이면 +1, 오른쪽이면 -1
	public static int turn(int d, int dir) {
		int newD = ((d + dir) % 4);
		if (newD < 0) {
			newD = 4 + newD;
		}
		return newD;
	}

	public static int[] go(int r, int c, int d, int k) {
		int newR = r + dr[d] * k;
		int newC = c + dc[d] * k;
		if (!isValid(newR, newC)) {
			return null;
		}
		return new int[] { newR, newC };
	}

	public static int goR(int r, int d, int k) {
		int newR = r + dr[d] * k;
		if (!isValid(newR, true))
			return -1;
		return newR;
	}

	public static int goC(int c, int d, int k) {
		int newC = c + dc[d] * k;
		if (!isValid(newC, false))
			return -1;
		return newC;
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	public static boolean isValid(int x, boolean isR) {
		if (x < 0)
			return false;
		if (isR)
			return x < R;
		else
			return x < C;
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(st.nextToken());
	}
}