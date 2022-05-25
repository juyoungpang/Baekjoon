package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.awt.Point;

public class p2667_bfs {
    static int N;
    static int[][] map;
    static int[][] visited;
    static List<Integer> local_cnt = new ArrayList<>();
    static Queue<Point> q = new LinkedList<>();

    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];

        for(int[] row:map) {
            String r = br.readLine();
            for(int i=0;i<N;i++) {
                row[i] = r.charAt(i)-'0';
            }
        }

        for(int[] row:visited) {
            Arrays.fill(row,0);
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]==1 && visited[i][j]==0) {
                    BFS(i,j);
                }
            }
        }

        Collections.sort(local_cnt);

        StringBuilder sb = new StringBuilder();
        sb.append(local_cnt.size()).append("\n");
        for(int n:local_cnt) sb.append(n).append("\n");

        System.out.println(sb.toString());
    }

    private static void BFS(int i, int j) {
        int x,y;
        int count = 1;
        
        q.offer(new Point(i,j));
        visited[i][j] = 1;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int k=0;k<4;k++){
                x = cur.x + dx[k];
                y = cur.y + dy[k]; 

                if(x>=0 && y>=0 && x<N && y<N && map[x][y]==1 && visited[x][y]==0) {
                    q.offer(new Point(x,y));
                    visited[x][y] = 1;
                    count++;
                }
            }
        }
        local_cnt.add(count);
    }
}
