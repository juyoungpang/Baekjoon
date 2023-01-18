package G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p2638_dfs {
    static int[][] board;
    static int N,M;
    static List<Point> cheeses = new ArrayList<>();
    static boolean[][] visited;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());
        board = new int[N][M];

        for(int i=0;i<N;i++) {
            tok = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(tok.nextToken());
                if(board[i][j]==1) cheeses.add(new Point(i,j));
            }
        }

        int time = 0;

        while(!cheeses.isEmpty()) {
            visited = new boolean[N][M];
            dfs(0,0);

            time++;
            for(int i=0;i<cheeses.size();i++) {
                int row = cheeses.get(i).row;
                int col = cheeses.get(i).col;

                int count = 0;
                for(int j=0;j<4;j++) {
                    if(board[row+dr[j]][col+dc[j]] == 2) count++;
                }

                if(count>=2) {
                    cheeses.remove(i);
                    board[row][col] = 0;
                    i--;
                }
            }
        }
        System.out.println(time);
    }

    public static void dfs(int row, int col) {
        visited[row][col] = true;
        board[row][col] = 2;
        for(int i=0;i<4;i++) {
            int nR = row+dr[i];
            int nC = col+dc[i];

            if(nR<0 || nC<0 || nR>=N || nC>=M) continue;
            if(board[nR][nC]==1 || visited[nR][nC]) continue;

            dfs(nR,nC);
        }
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
