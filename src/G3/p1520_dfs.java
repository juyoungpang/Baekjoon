package G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * dfs와 dp를 같이 사용해서 만든것
 * 그렇지 않으면 시간초과가 난다, 너무 경우의 수가 많기 때문에
 * 이미 탐색해서 가능하다고 판정이 난 곳에 도달하면 그냥 바로 가능하다고 하게끔 bottom up design0
 */

public class p1520_dfs {
    static int[][] map, dp;
    static int M,N;
    static final int[] dr = {-1,0,1,0};
    static final int[] dc = {0,-1,0,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        M = Integer.parseInt(tok.nextToken());
        N = Integer.parseInt(tok.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for(int i=0;i<map.length;i++) {
            tok = new StringTokenizer(br.readLine());
            for(int j=0;j<map[0].length;j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }

    public static int dfs(int r, int c) {
        if (r == M - 1 && c == N - 1) return 1;

        if (dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];

            if (newR >= 0 && newC >= 0 && newR < M && newC < N) {
                if (map[r][c] > map[newR][newC]) dp[r][c] += dfs(newR, newC);
            }
        }

        return dp[r][c];
    }
}


