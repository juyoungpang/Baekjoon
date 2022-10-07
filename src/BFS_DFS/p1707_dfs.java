package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 와 진짜 화났던 문제, 이분트리
 * 우선 너무 vertex가 많아서 int[][]배열로하면 메모리 초과 --> ArrayList of ArrayList로 해결
 * 그리고 visited를 매번 0으로 만들어서 모든 곳에 대해서 탐색하게 했는더니 시간 초과 -->
 * 그냥 dfs로 쭉 하고, 그 다음에 하나씩 봐서 connected인데 group가 똑같으면 false가 되도록
 */

public class p1707_dfs {
    static int K,V,E;
    static ArrayList<ArrayList<Integer>> adjMap;
    static int[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++) {
            if(testCase()) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static boolean testCase() throws IOException {
        StringTokenizer tok = new StringTokenizer(br.readLine());
        V = Integer.parseInt(tok.nextToken());
        E = Integer.parseInt(tok.nextToken());

        visited = new int[V];

        adjMap = new ArrayList<>();
        for(int v=0;v<V;v++) adjMap.add(new ArrayList<>());

        for(int e=0;e<E;e++) {
            tok = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(tok.nextToken()) - 1;
            int v2 = Integer.parseInt(tok.nextToken()) - 1;

            adjMap.get(v1).add(v2);
            adjMap.get(v2).add(v1);
        }

        for(int i=0;i<V;i++) {
            if(visited[i]==0) dfs(i,1);
        }

        for(int i=0;i<V;i++) {
            for(int j:adjMap.get(i)) {
                if(visited[i]==visited[j]) return false;
            }
        }
        return true;
    }

    public static void dfs(int node, int group) {
        visited[node] = group;
        for(int i:adjMap.get(node)) {
            if(visited[i]==0) dfs(i,group*-1);
        }
    }
}
