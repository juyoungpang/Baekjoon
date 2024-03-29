package S3;

import java.util.Scanner;

/*
 * bottom up
 */

public class p11727_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+2];
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3;i<=n;i++)
            dp[i] = (dp[i-1] + dp[i-2]*2)%10007;

        System.out.println(dp[n]);
    }
}
