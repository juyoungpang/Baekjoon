package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class p1012_bfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int T,N,M,K;
    static int[][] map, visited;
    static Point[] points;
    
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            sb.append(BFS()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int BFS() throws IOException {
        int count = 0;

        StringTokenizer tok = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());
        K = Integer.parseInt(tok.nextToken());

        map = new int[N][M];
        visited = new int[N][M];
        points = new Point[K];

        for(int i=0;i<N;i++){
            Arrays.fill(map[i],0);
            Arrays.fill(visited[i],0);
        }

        for(int i=0;i<K;i++) {
            tok = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(tok.nextToken());
            int col = Integer.parseInt(tok.nextToken());

            map[row][col] = 1;
            points[i] = new Point(row,col);
        }

        for(Point p:points) {
            if(visited[p.x][p.y] == 0){
                count++;
                runBFS(p);
            }
        }

        return count;
    }

    private static void runBFS(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x][p.y] = 1;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int k=0;k<4;k++) {
                int x = cur.x+dx[k];
                int y = cur.y+dy[k];

                if(x>=0 && y>=0 && x<N && y<M && map[x][y]==1 && visited[x][y]==0) {
                    q.offer(new Point(x,y));
                    visited[x][y] = 1;
                }
            }
        }
    }
}
