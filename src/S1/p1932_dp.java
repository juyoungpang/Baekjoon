package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1932_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];

        for(int n=0;n<N;n++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            for(int i=0;i<=n;i++) {
                map[n][i] = Integer.parseInt(tok.nextToken());
            }
        }

        dp[N-1] = map[N-1];

        for(int n=N-2;n>=0;n--) {
            for(int i=0;i<=n;i++) {
                dp[n][i] = Math.max(dp[n+1][i], dp[n+1][i+1])+map[n][i];
            }
        }

        System.out.println(dp[0][0]);

    }
}
