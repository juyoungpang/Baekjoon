package BFS_DFS;

import java.util.*;
import java.io.*;

public class p2606_bfs {
    static BufferedReader br;
    static StringTokenizer tok;

    static int N;   //number of computers
    static int M;   //number of edges
    static int[][] map;
    static boolean[] visited; 

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        for(int[] m:map){
            Arrays.fill(m,0);
        }
        Arrays.fill(visited, false);       

        for(int i=0;i<M;i++){
            tok = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tok.nextToken())-1;
            int b = Integer.parseInt(tok.nextToken())-1;
            map[a][b] = 1;
            map[b][a] = 1;
        }

        System.out.println(bfs(0));
    }
    
    public static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        int count = 0;

        while(!queue.isEmpty()){
            int p = queue.poll();

            for(int i=0;i<N;i++){
                if(!visited[i] && map[p][i]==1){
                    queue.add(i);
                    count++;
                    visited[i]=true;
                }
            }
        }

        return count;
    }
}
