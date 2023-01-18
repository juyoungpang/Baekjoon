package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9465_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n+1];
            for(int i=0;i<2;i++) {
                StringTokenizer tok = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++) {
                    stickers[i][j] = Integer.parseInt(tok.nextToken());
                }
            }
            int[][] dp = new int[2][n+1];
            dp[0][0] = 0;
            dp[1][0] = 0;
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for(int i=2;i<=n;i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2])+stickers[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2])+stickers[1][i];
            }

            System.out.println(dp[0][n]>dp[1][n]?dp[0][n]:dp[1][n]);
        }
    }
}
