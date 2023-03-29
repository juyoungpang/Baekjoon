import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		System.out.println(method1(N));
	}

	public static int method1(int N) {
		int[] dp = new int[N + 1];
		dp[1] = 2;
		dp[2] = 5;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] * 2 + dp[i - 2] + dp[i - 3];
		}
		return dp[N];
	}
}
