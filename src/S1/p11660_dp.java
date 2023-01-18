package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11660_dp {
    static int[][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());

        map = new int[N][N];
        for(int i=0;i<N;i++) {
            tok = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
            }
        }

        dp = new int[N][N];
        dp[0][0] = map[0][0];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i==0&&j==0) continue;

                //맨 윗줄
                if(i==0) {
                    dp[i][j] = dp[i][j-1]+map[i][j];
                }
                //맨 왼쪽
                else if(j==0) {
                    dp[i][j] = dp[i-1][j]+map[i][j];
                }
                //안쪽
                else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i][j];
                }
            }
        }

        for(int m=0;m<M;m++) {
            tok = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(tok.nextToken())-1;
            int c1 = Integer.parseInt(tok.nextToken())-1;
            int r2 = Integer.parseInt(tok.nextToken())-1;
            int c2 = Integer.parseInt(tok.nextToken())-1;

            int left = c1-1;
            int up = r1-1;

            int answer = dp[r2][c2];

            if(left >= 0) {
                answer -= dp[r2][left];
            }
            if(up >= 0) {
                answer -= dp[up][c2];
            }
            if(left>=0 && up>=0) {
                answer += dp[up][left];
            }

            System.out.println(answer);

        }
    }
}
