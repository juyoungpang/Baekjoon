package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11724_dfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N,M,count;
    static int[][] map;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer tok = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());
        map = new int[N][N];
        visited = new int[N];
        Arrays.fill(visited, 0);
        for(int[] row:map){
            Arrays.fill(row, 0);
        }
        count = 0;

        for(int i=0;i<M;i++) {
            tok = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tok.nextToken())-1;
            int b = Integer.parseInt(tok.nextToken())-1;

            map[a][b] = map[b][a] = 1;
        }

        for(int i=0;i<N;i++) {
            if(visited[i]==0) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = 1;
        for(int i=0;i<N;i++) {
            if(map[node][i]==1 && visited[i]==0) {
                dfs(i);
            }
        }
    }
}
