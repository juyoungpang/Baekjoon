package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1149_bottom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        for(int i=0;i<arr.length;i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            for(int j=0;j<arr[0].length;j++) {
                arr[i][j] = Integer.parseInt(tok.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int i=1;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                dp[i][j] = arr[i][j] + Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
            }
        }

        System.out.printf("%d\n", Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
    
}
