package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p13460 {
    static BufferedReader br;
    static StringTokenizer tok;

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int holeX, holeY;
    static Marble blue, red;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tok = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                board[i][j] = str.charAt(j);

                if(board[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                }
                else if(board[i][j] == 'R') {
                    red = new Marble(i,j,0,0,0);
                }
                else if(board[i][j] == 'B') {
                    blue = new Marble(0,0,i,j,0);
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        queue.offer(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;

        while(!queue.isEmpty()) {
            Marble marble = queue.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if(curCnt>10) return -1;

            for(int i=0;i<4;i++) {
                int nextRx = curRx;
                int nextRy = curRy;
                int nextBx = curBx;
                int nextBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while(board[nextRx + dx[i]][nextRy + dy[i]] != '#') {
                    nextRx += dx[i];
                    nextRy += dy[i];

                    if(board[nextRx][nextRy] == 'O') {
                        isRedHole = true;
                        break;
                    }
                }

                while(board[nextBx + dx[i]][nextBy + dy[i]] != '#') {
                    nextBx += dx[i];
                    nextBy += dy[i];

                    if(board[nextBx][nextBy] == 'O') {
                        isBlueHole = true;
                        break;
                    }
                }

                if(isBlueHole) continue;
                if(isRedHole) return curCnt;

                if(nextRx==nextBx && nextRy==nextBy) {
                    if(i==0) { //왼쪽
                        if(curRx<curBx) nextBx++;
                        else nextRx++;
                    }
                    else if(i==1) { //아래로
                        if(curRy<curBy) nextRy--;
                        else nextBy--;
                    }
                    else if(i==2) { //오른쪽
                        if(curRx<curBx) nextRx--;
                        else nextBx--;
                    }
                    else { //위쪽
                        if(curRy<curBy) nextBy++;
                        else nextRy++;
                    }
                }

                if(!visited[nextRx][nextRy][nextBx][nextBy]) {
                    queue.offer(new Marble(nextRx, nextRy, nextBx, nextBy, curCnt+1));
                }
            }
        }
        return -1;
    }


}

class Marble {
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    Marble(int rx, int ry, int bx, int by, int cnt) {
        this.rx=rx;
        this.ry=ry;
        this.bx=bx;
        this.by=by;
        this.cnt=cnt;
    }
}
