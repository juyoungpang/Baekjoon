package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4963_dfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    static int w,h,count;
    static int[][] map, visited;

    static final int[] dx = {-1,1,0,0,-1,1,1,-1};
    static final int[] dy = {0,0,-1,1,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        tok = new StringTokenizer(br.readLine()); 
        w = Integer.parseInt(tok.nextToken());
        h = Integer.parseInt(tok.nextToken());

        StringBuilder sb = new StringBuilder();
        while((w==0 && h!=0) || (w!=0 && h==0) || (w!=0 && h!=0)) {
            map = new int[w][h];
            visited = new int[w][h];
            for(int[] row:visited) {
                Arrays.fill(row,0);
            }
            for(int i=0;i<h;i++) {
                tok = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) {
                    map[j][i] = Integer.parseInt(tok.nextToken());
                }
            }
            DFS();
            sb.append(count).append("\n");
            count = 0;
            
            tok = new StringTokenizer(br.readLine());
            w = Integer.parseInt(tok.nextToken());
            h = Integer.parseInt(tok.nextToken());
        }

        System.out.println(sb.toString());
    }

    private static void DFS() {
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                if(map[i][j]==1 && visited[i][j]==0) {
                    count++;
                    runDFS(i,j);
                }
            }
        }
    }

    private static void runDFS(int i, int j) {
        visited[i][j]=1;
        for(int k=0;k<8;k++) {
            int x = i+dx[k];
            int y = j+dy[k];

            if(x>=0 && y>=0 && x<w && y<h && map[x][y]==1 && visited[x][y]==0) {
                runDFS(x,y);
            }
        }
    }
}
