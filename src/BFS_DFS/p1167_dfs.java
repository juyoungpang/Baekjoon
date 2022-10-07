package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * dfs만을 사용하기는 하나 tree의 속성도 사용해서 풀어야했던 문제
 * tree는 cycle이 없기 때문에 가장 먼 node를 모두 한번은 거치게 된다
 * 즉 시작점이 다르더라도 예를들어 1번->5번이 제일 멀다면 어디서 시작을하던 1이나 5까지 가게된다
 * 그러면 1이나 5에서 다시 한번 dfs를 돌리면 되는것이다.
 */

public class p1167_dfs {
    static int V;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static int max = -1;
    static int maxNode = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());

        adj = new ArrayList[V+1];

        for(int i=1;i<V+1;i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(tok.nextToken());
            adj[s] = new ArrayList<>();
            while(true) {
                int idx = Integer.parseInt(tok.nextToken());
                if(idx==-1) break;
                int cost = Integer.parseInt(tok.nextToken());
                adj[s].add(new Node(idx,cost));
            }
        }

        visited = new boolean[V+1];
        dfs(1,0);

        visited = new boolean[V+1];
        dfs(maxNode,0);

        System.out.println(max);
    }

    static void dfs(int nodeIdx, int depth) {
        visited[nodeIdx] = true;
        if(depth > max) {
            maxNode = nodeIdx;
            max = depth;
        }

        for(Node node:adj[nodeIdx]) {
            if(!visited[node.idx]) dfs(node.idx,depth+node.cost);
        }
    }

    static class Node{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
