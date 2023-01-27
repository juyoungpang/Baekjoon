package S5;
import java.util.Scanner;

public class p2508_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 0; test_case < T; test_case++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			char[][] map = new char[r][c];
			for (int i = 0; i < r; i++) {
				String temp = sc.next();
				for (int j = 0; j < c; j++) {
					map[i][j] = temp.charAt(j);
				}
			}

			int answer = 0;

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == '>') {
						if (j + 2 < c && map[i][j + 1] == 'o' && map[i][j + 2] == '<')
							answer++;
					} else if (map[i][j] == 'v') {
						if (i + 2 < r && map[i + 1][j] == 'o' && map[i + 2][j] == '^')
							answer++;
					}
				}
			}
			
			System.out.println(answer);
		}
	}
}