package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p10026_dfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, count;
    static int[][] map, visited;

    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];
        for(int[] row:visited) Arrays.fill(row,0);

        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<N;j++) {
                if(row.charAt(j)=='B') map[i][j] = 0;
                else if(row.charAt(j)=='R') map[i][j] = 1;
                else map[i][j] = 2;
            }
        }

        count = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visited[i][j]==0) {
                    count++;
                    DFS(i,j,map[i][j],0);
                }
            }
        }
        System.out.print(count+" ");

        count = 0;
        for(int[] row:visited) Arrays.fill(row,0);
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visited[i][j]==0) {
                    count++;
                    DFS(i,j,map[i][j],1);
                }
            }
        }
        System.out.println(count);
    }

    private static void DFS(int i, int j, int val,int flag) {
        visited[i][j]=1;

        if(flag==1) val=val==0?0:1;

        for(int k=0;k<4;k++) {
            int a = i+dx[k];
            int b = j+dy[k];

            if(flag==0 && a>=0 && b>=0 && a<N && b<N && map[a][b]==val && visited[a][b]==0) {
                DFS(a,b,val,flag);
            }

            if(flag==1 && a>=0 && b>=0 && a<N && b<N && (map[a][b]==0?0:1)==val && visited[a][b]==0) {
                DFS(a,b,val,flag);
            }
        }
    }
}
