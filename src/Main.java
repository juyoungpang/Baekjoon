import java.util.Scanner;

public class Main {
	static boolean[] row, col;
	static boolean[][] leftUp, leftDown;
	static int N, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		row = new boolean[N];
		col = new boolean[N];
		leftUp = new boolean[N][N];
		leftDown = new boolean[N][N];
		
		run(0,-1,0);
		
		System.out.println(answer);
	}

	public static void run(int r, int c, int depth) {
		if (depth == N) {
			answer++;
			return;
		}

		for (int i = r; i < N; i++) {
			for (int j = c+1; j < N; j++) {
				if (row[i] || col[j] || leftUp[i - Math.min(i, j)][j - Math.min(i, j)] ||
						leftDown[i+Math.min(N-i-1, j)][j-Math.min(N-i-1, j)]) {
					continue;
				}
				row[i] = true;
				col[i] = true;
				leftUp[i - Math.min(i, j)][j - Math.min(i, j)] = true;
				leftDown[i+Math.min(N-i-1, j)][j-Math.min(N-i-1, j)] = true;
				run(i,j,depth+1);
				row[i] = false;
				col[i] = false;
				leftUp[i - Math.min(i, j)][j - Math.min(i, j)] = false;
				leftDown[i+Math.min(N-i-1, j)][j-Math.min(N-i-1, j)] = false;
				
				run(i,j,depth);
			}
		}
	}
}