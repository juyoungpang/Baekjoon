package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 하 재귀 어려워..
 */

public class g3_9466 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int size;
    static int[] map;
    static boolean[] visited, checked;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            int n = Integer.parseInt(br.readLine());
            map = new int[n];
            visited = new boolean[n];
            checked = new boolean[n];
            size = n;

            StringTokenizer tok = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                map[i] = Integer.parseInt(tok.nextToken())-1;
            }

            for(int i=0;i<n;i++) {
                dfs(i);
            }
            System.out.println(size);
        }

    }

    public static void dfs(int now) {
        visited[now] = true;
        int next = map[now];

        if(!visited[next]) {
            dfs(next);
        } else {
            if(!checked[next]) {
                size--;
                while(now!=next) {
                    size--;
                    next = map[next];
                }
            }
        }
        checked[now] = true;
    }
}
