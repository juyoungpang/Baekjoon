package S3;

import java.util.*;

public class p1904_dp {
	static int[] dp = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 3; i < N+1; i++)
			dp[i] = -1;

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		System.out.println(topDown(N));
	}

	public static int topDown(int n) {
		if (dp[n] == -1)
			dp[n] = (topDown(n - 1) + topDown(n - 2)) % 15746;

		return dp[n];
	}
}
