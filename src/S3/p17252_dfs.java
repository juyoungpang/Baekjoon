package S3;
import java.util.Scanner;

public class p17252_dfs {

	static boolean answer = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int max = (int) (Math.log10(N) / Math.log10(3)) + 1;

		dfs(N, max, 0, 0, 0);

		System.out.println(answer ? "YES" : "NO");
	}

	public static void dfs(int N, int max, int num, int depth, int start) {
		if (answer || depth == max || num>N) {
			return;
		}

		for (int i = start; i < max; i++) {
			int add = (int) Math.pow(3, i);
			if (num + add == N) {
				answer = true;
				return;
			}

			dfs(N, max, num + add, depth + 1, i + 1);
		}
	}
}