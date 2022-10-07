package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p12100 {
    static int N;
    static int ans = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        bfs(board);
        System.out.println(ans);
    }

    public static void bfs(int[][] board) {
        Queue<Board> queue = new LinkedList<>();
        queue.offer(new Board(board,0));

        while(!queue.isEmpty()) {
            Board curBoard = queue.poll();
            int[][] initBoard = curBoard.board;
            int initCount = curBoard.count;

            if(initCount>5) continue;
            ans = Math.max(ans, findMax(initBoard));

            for(int d=0;d<4;d++) {
                int[][] newBoard = new int[N][N];
                int newCount = initCount+1;

                for(int i=0;i<N;i++) {
                    for(int j=0;j<N;j++) {
                        newBoard[i][j] = initBoard[i][j];
                    }
                }

                move(newBoard, d);

                queue.offer(new Board(newBoard, newCount));
            }
        }
    }

    public static void move(int[][] board, int dir) {
        boolean[][] visited = new boolean[N][N];
        for(boolean[] row:visited) {
            Arrays.fill(row,false);
        }

        if(dir==0||dir==2) { //dx
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int x = j;
                    int y = i;
                    int newX = x + dx[dir];
                    int temp = board[x][y];
                    board[x][y] = 0;

                    while (true) {
                        if (newX < 0 || newX >= N ) {
                            break;
                        }

                        if (board[newX][y] == 0) {
                            x = newX;
                            newX = x + dx[dir];
                        }
                        else if(!visited[newX][y] && temp==board[newX][y]) {
                            x = newX;
                            visited[newX][y] = true;
                            break;
                        }
                        else break;
                    }

                    board[x][y]+=temp;
                }
            }
        }
        else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int x = i;
                    int y = j;
                    int newY = y + dy[dir];
                    int temp = board[x][y];
                    board[x][y] = 0;

                    while (true) {
                        if (newY < 0 || newY >= N) {
                            break;
                        }

                        if (board[x][newY] == 0) {
                            y = newY;
                            newY = y + dy[dir];
                        } else if (!visited[x][newY] && temp == board[x][newY]) {
                            y = newY;
                            visited[x][newY] = true;
                            break;
                        } else break;
                    }

                    board[x][y] += temp;
                }
            }
        }
    }

    public static int findMax(int[][] arr) {
        int ret=0;
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                ret = Math.max(ret,arr[i][j]);
            }
        }
        return ret;
    }

}

class Board {
    int[][] board;
    int count;

    public Board(int[][] board, int count) {
        this.board = board;
        this.count = count;
    }
}
