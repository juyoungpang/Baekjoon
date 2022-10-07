package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * greedy문제다
 * 즉 맨 위에서 내려간다고치면 무조건 최대한 위쪽으로 뻗게끔해주는게 좋다
 * 하.. greedy도 연습해야할듯
 */

public class p3109_dfs {
    static int R,C,count;
    static char[][] map;
    static final int[] dr = {-1,0,1};
    static final int[] dc = {1,1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        R = Integer.parseInt(tok.nextToken());
        C = Integer.parseInt(tok.nextToken());
        map = new char[R][C];

        for(int i=0;i<R;i++) {
            String input = br.readLine();
            for(int j=0;j<C;j++) {
                map[i][j] = input.charAt(j);
            }
        }

        count = 0;

        for(int i=0;i<R;i++) {
            dfs(i,0);
        }

        System.out.println(count);
    }

    public static boolean dfs(int row, int col) {
        for(int i=0;i<3;i++) {
            int nR = row+dr[i];
            int nC = col+dc[i];

            if(nR<0 || nC<0 || nR>=R || nC>=C) continue;

            if(map[nR][nC]=='.') {
                if(nC==C-1) {
                    count++;
                    return true;
                }

                map[nR][nC]='x';

                if(dfs(nR,nC)) return true;
            }
        }
        return false;
    }
}
