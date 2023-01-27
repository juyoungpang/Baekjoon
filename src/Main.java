import java.util.Scanner;

public class Main {
	static int n = 0;
	static int number;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		while (number != 0) {
			n = 0;
			int depth = 1;
			while (n != number) {
				dfs(0, 0, depth++, new boolean[10]);
			}

			number = sc.nextInt();
		}
	}

	public static void dfs(int num, int curDepth, int depth, boolean[] visited) {
		if (n == number) {
			return;
		}
		if (curDepth == depth) {
			n++;
			if (n == number) {
				System.out.println(num);
				return;
			}
		}

		for (int i = curDepth == 0 ? 1 : 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(num*10 + i, curDepth + 1, depth, visited);
				visited[i] = false;
			}
		}
	}
}