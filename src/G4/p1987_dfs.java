package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1987_dfs {
    static int R, C;
    static char[][] map;
    static Set<Character> alphabets;
    static boolean[][] visited;
    static int max=1;
    static final int[] dr = {-1,0,1,0};
    static final int[] dc = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        R = Integer.parseInt(tok.nextToken());
        C = Integer.parseInt(tok.nextToken());

        map = new char[R][C];
        for(int i=0;i<map.length;i++) {
            String str = br.readLine();
            for(int j=0;j<map[0].length;j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[R][C];
        for(boolean[] row:visited) Arrays.fill(row,false);

        alphabets = new HashSet<>();

        dfs(new Node(0,0,1));

        System.out.println(max);
    }

    static void dfs(Node curNode) {
        visited[curNode.r][curNode.c] = true;
        alphabets.add(map[curNode.r][curNode.c]);

        if(curNode.depth>max) max = curNode.depth;

        for(int i=0;i<dr.length;i++) {
            int newRow = curNode.r+dr[i];
            int newCol = curNode.c+dc[i];

            if(newRow>=0 && newCol>=0 && newRow<R && newCol<C) {
                if(!visited[newRow][newCol] && !alphabets.contains(map[newRow][newCol])) {
                    alphabets.add(map[newRow][newCol]);
                    visited[newRow][newCol] = true;
                    dfs(new Node(newRow, newCol, curNode.depth+1));
                    alphabets.remove(map[newRow][newCol]);
                    visited[newRow][newCol] = false;
                }
            }
        }
    }

    static class Node {
        int r, c, depth;

        public Node(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}
