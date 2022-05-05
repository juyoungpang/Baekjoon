package BFS_DFS;

import java.io.*;
import java.util.*;

public class p1260_bfsdfs {
    static BufferedReader br;

    static Queue<Integer> bfs;

    static int n,m,v;
    static int[][] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tok = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        v = Integer.parseInt(tok.nextToken());

        graph = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(graph[i],0);
        }
        visited = new int[n+1];
        Arrays.fill(visited,0);
        visited[v] = 1;

        for(int i=0;i<m;i++){
            tok = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(v);
        System.out.println();

        Arrays.fill(visited,0);
        visited[v] = 1;

        bfs();
    }

    public static void dfs(int current){
        System.out.print(current+" ");

        for(int j=1;j<n+1;j++){
            if(current!=j && graph[current][j]==1 && visited[j]==0){
                visited[j]=1;
                dfs(j);
            }
        }
    }

    public static void bfs(){
        bfs = new LinkedList<Integer>();
        bfs.offer(v);

        while(!bfs.isEmpty()){
            int current = bfs.poll();
            System.out.print(current+" ");

            for(int j=1;j<n+1;j++){
                if(current!=j && graph[current][j]==1 && visited[j]==0){
                    visited[j]=1;
                    bfs.offer(j);
                }
            }
        }
    }
}
