package G5;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12865_dp {
    static int N, K;
    static int[][] wv, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tok.nextToken());
        K = Integer.parseInt(tok.nextToken());
        wv = new int[N+1][2];
        dp = new int[N+1][K+1];

        for(int i=1;i<N+1;i++) {
            tok = new StringTokenizer(br.readLine());
            wv[i][0] = Integer.parseInt(tok.nextToken());
            wv[i][1] = Integer.parseInt(tok.nextToken());
        }

        for(int i=1;i<N+1;i++) {
            for(int j=1;j<K+1;j++) {
                if(j-wv[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], wv[i][1]+dp[i-1][j-wv[i][0]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
