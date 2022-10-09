package dynamic_programming;

import java.util.Scanner;

public class s1_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int map[] = new int[N+2];

        for(int i=1;i<=N;i++) {
            map[i] = sc.nextInt();
        }

        int dp[] = new int[N+2];
        dp[1] = map[1];
        dp[2] = dp[1]+map[2];

        for(int i=3;i<N+1;i++) {
            dp[i] = Math.max(Math.max(dp[i-1],dp[i-2]+map[i]),dp[i-3]+map[i-1]+map[i]);
        }

        System.out.println(dp[N]);
    }
}
