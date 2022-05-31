package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1697_bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        
        int N, K;
        
        int[] visited = new int[100001];
        Arrays.fill(visited, 0);

        N = Integer.parseInt(tok.nextToken());
        K = Integer.parseInt(tok.nextToken());

        if(N==K) {
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 1;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int i=0;i<3;i++){
                int next;
                switch(i) {
                    case 0: next = current+1; break;
                    case 1: next = current-1; break;
                    default: next = current*2; break;
                }

                if(next==K)  {
                    System.out.println(visited[current]);
                    return;
                }

                if(next>0 && next<visited.length && visited[next]==0) {
                    queue.offer(next);
                    visited[next] = visited[current]+1;
                }
            }
        }
    }
}
