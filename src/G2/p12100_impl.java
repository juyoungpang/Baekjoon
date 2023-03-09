package G2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p12100_impl {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, max;

	public static void main(String[] args) throws IOException {
		N = nextInt();
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = nextInt();
				max = Math.max(board[i][j], max);
			}
		}

		run(0, board);

		System.out.println(max);
	}

	public static void run(int depth, int[][] board) {
		if (depth == 5) {
			return;
		}

		run(depth + 1, up(copyArr(board)));
		run(depth + 1, down(copyArr(board)));
		run(depth + 1, left(copyArr(board)));
		run(depth + 1, right(copyArr(board)));
	}

	static Queue<Integer> inQ, outQ;

	public static void queueing() {
		outQ = new LinkedList<>();

		while (!inQ.isEmpty()) {
			int curNum = inQ.poll();
			if (!inQ.isEmpty() && inQ.peek() == curNum) {
				int newNum = curNum+inQ.poll();
				outQ.offer(newNum);
				max = Math.max(max, newNum);
			} else {
				outQ.offer(curNum);
			}
		}
	}

	public static int[][] up(int[][] board) {
		inQ = new LinkedList<>();

		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {
				if (board[r][c] != 0) {
					inQ.offer(board[r][c]);
					board[r][c] = 0;
				}
			}

			queueing();

			for (int r = 0; r < N; r++) {
				if (outQ.isEmpty())
					break;

				board[r][c] = outQ.poll();
			}
		}

		return board;
	}

	public static int[][] down(int[][] board) {
		inQ = new LinkedList<>();

		for (int c = 0; c < N; c++) {
			for (int r = N - 1; r >= 0; r--) {
				if (board[r][c] != 0) {
					inQ.offer(board[r][c]);
					board[r][c] = 0;
				}
			}

			queueing();

			for (int r = N - 1; r >= 0; r--) {
				if (outQ.isEmpty())
					break;

				board[r][c] = outQ.poll();
			}
		}

		return board;
	}

	public static int[][] left(int[][] board) {
		inQ = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] != 0) {
					inQ.offer(board[r][c]);
					board[r][c] = 0;
				}
			}

			queueing();

			for (int c = 0; c < N; c++) {
				if (outQ.isEmpty())
					break;

				board[r][c] = outQ.poll();
			}
		}

		return board;
	}

	public static int[][] right(int[][] board) {
		inQ = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			for (int c = N - 1; c >= 0; c--) {
				if (board[r][c] != 0) {
					inQ.offer(board[r][c]);
					board[r][c] = 0;
				}
			}

			queueing();

			for (int c = N - 1; c >= 0; c--) {
				if (outQ.isEmpty())
					break;

				board[r][c] = outQ.poll();
			}
		}

		return board;
	}

	public static int[][] copyArr(int[][] arr) {
		int[][] newArr = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i].clone();
		}
		return newArr;
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

}