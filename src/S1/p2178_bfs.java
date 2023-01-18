package S1;

import java.io.*;
import java.util.*;

public class p2178_bfs{
    static BufferedReader br;
    static StringTokenizer tok;

    static int N,M;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        tok = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++){
            tok = new StringTokenizer(br.readLine());
            String tmp = tok.nextToken();
            for(int j=0;j<M;j++){
                int val = tmp.charAt(j)-'0';
                map[i][j] = val;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,1));
        map[0][0]=0;
        int ret=0;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.col>0&&map[p.row][p.col-1]==1) {
                map[p.row][p.col-1]=0;
                queue.add(new Point(p.row,p.col-1,p.d+1));
            }
            if(p.col<M-1&&map[p.row][p.col+1]==1) {
                map[p.row][p.col+1]=0;
                queue.add(new Point(p.row,p.col+1,p.d+1));
            }
            if(p.row>0&&map[p.row-1][p.col]==1) {
                map[p.row-1][p.col]=0;
                queue.add(new Point(p.row-1,p.col,p.d+1));
            }
            if(p.row<N-1&&map[p.row+1][p.col]==1) {
                map[p.row+1][p.col]=0;
                queue.add(new Point(p.row+1,p.col,p.d+1));
            }

            if(p.row==N-1&&p.col==M-1) ret = p.d;
        }

        System.out.println(ret);
    }
    

    public static class Point{
        int row, col, d;

        public Point(int row, int col, int d){
            this.row = row;
            this.col = col;
            this.d = d;
        }
    }    
}