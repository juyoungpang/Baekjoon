package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14502_bfsdfs {
    static int N,M,answer = 0;
    static int[][] originalMap;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());

        originalMap = new int[N][M];
        for(int i=0;i<N;i++){
            tok = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                originalMap[i][j] = Integer.parseInt(tok.nextToken());
            }
        }

        DFS(0);

        System.out.println(answer);
    }

    private static void DFS(int depth) {
        if(depth==3) {
            BFS();
            return;
        }

        else{
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(originalMap[i][j]==0){
                        originalMap[i][j]=1;
                        DFS(depth+1);
                        originalMap[i][j]=0;
                    }
                }
            }
        }
    }

    private static void BFS() {
        Queue<Virus> q = new LinkedList<>();
        int[][] virusMap = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                virusMap[i][j] = originalMap[i][j];
                if(virusMap[i][j]==2) q.offer(new Virus(i, j));
            }
        }

        while(!q.isEmpty()) {
            Virus v = q.poll();
            for(int i=0;i<4;i++) {
                int nextRow = v.row+dr[i];
                int nextCol = v.col+dc[i];

                if(nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<M && virusMap[nextRow][nextCol]==0) {
                    virusMap[nextRow][nextCol] = 2;
                    q.offer(new Virus(nextRow, nextCol));
                } 
            }
        }

        checkSafe(virusMap);
    }

    private static void checkSafe(int[][] map) {
        int ans=0;
        for(int[] row : map) {
            for(int num:row) {
                if(num==0) ans++;
            }
        }
        answer = Math.max(ans, answer);
    }

    static class Virus{
        int row,col;
        public Virus(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
