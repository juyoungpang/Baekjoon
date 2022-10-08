package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 얘도 dp사용해서 dfs
 */

public class p1937_dfs {
    static int N, max;
    static int[][] map,dp;
    static final int[] dr = {-1,0,1,0};
    static final int[] dc = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
                dp[i][j] = -1;
            }
        }

        max = -1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(dp[i][j]==-1) {
                    dfs(i,j);
                }
            }
        }

        System.out.println(max+1);
    }

    public static int dfs(int r, int c) {
        if(dp[r][c]!=-1)
            return dp[r][c];

        dp[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int nR = r + dr[i];
            int nC = c + dc[i];

            if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue;

            if (map[nR][nC] > map[r][c]) {
                dp[r][c] = Math.max(dp[r][c],dfs(nR,nC)+1);
            }
        }
        if(dp[r][c]>max) max = dp[r][c];
        return dp[r][c];
    }
}
