package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16955_bruteForce {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] board = new char[10][10];

		for (int i = 0; i < 10; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 10; j++) {
				board[i][j] = temp.charAt(j);
			}
		}

		// 오른쪽, 아래, 오른쪽 아래 대각선, 왼쪽 아래 대각선
		int[] dr = { 0, 1, 1, 1 };
		int[] dc = { 1, 0, 1, -1 };

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int d = 0; d < 4; d++) {
					int skipped = 0;

					int newI = i;
					int newJ = j;

					for (int count = 0; count < 5; count++) {

						if (newI < 0 || newI >= 10 || newJ < 0 || newJ >= 10)
							break;

						if (board[newI][newJ] == 'O')
							break;
						else if (board[newI][newJ] == '.')
							skipped++;

						if (skipped > 1)
							break;

						if (count == 4) {
							System.out.println(1);
							return;
						}
						newI += dr[d];
						newJ += dc[d];
					}

				}
			}
		}

		System.out.println(0);
	}
}