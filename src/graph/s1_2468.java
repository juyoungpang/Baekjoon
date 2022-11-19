package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_2468 {

    static int[][] map;
    static boolean[][] visited;
    static int maxHeigth = 0;
    static int maxCount = 1;
    static int N;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
                if(map[i][j]>maxHeigth) maxHeigth = map[i][j];
            }
        }

        for(int i=1;i<maxHeigth;i++) {
            for(boolean[] arr:visited) Arrays.fill(arr,false);

            drown(i);

            maxCount = Math.max(maxCount, dfs());
        }

        System.out.println(maxCount);
    }

    public static void drown(int height) {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]<=height) visited[i][j] = true;
            }
        }
    }

    public static int dfs() {
        int count = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!visited[i][j]) {
                    count++;
                    runDfs(i,j);
                }
            }
        }
        return count;
    }

    public static void runDfs(int r, int c) {
        visited[r][c] = true;
        for(int d=0;d<4;d++) {
            int newR = r+dr[d];
            int newC = c+dc[d];

            if(newR>=0 && newC>=0 && newR<N && newC<N && !visited[newR][newC]) runDfs(newR,newC);
        }
    }
}
