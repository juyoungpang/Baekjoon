package G5;

import java.util.*;
import java.io.*;

public class p14503_impl {
    static BufferedReader br;
    static StringTokenizer tok;

    static final int[] moveLeft = {-1,-1,1,1}; //col,row,col,row
    static final int[] moveBack = {1,-1,-1,1}; //row,col,row,col

    static int N, M, r, c, d;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        tok = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        tok = new StringTokenizer(br.readLine());
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        d = Integer.parseInt(tok.nextToken());

        for(int i=0;i<N;i++){
            tok = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(tok.nextToken());
                if(map[i][j]==1) visited[i][j] = true;
                else visited[i][j] = false;
            }
        }

        int count = 1;
        while(true){
            boolean moved = false;
            for(int i=0;i<4;i++){
                moved = move(0);
                if(moved) {
                    count++;
                    break;
                }
            }
            if(!moved) {
                if(!move(1)) break;
                else count++;
            }
        }

        System.out.println(count);
        
    }

    public static boolean move(int leftOrBack){
        int[] moveArr = (leftOrBack==0)?moveLeft:moveBack;
        if(d%2==0){
            if(isValid(1, c+moveArr[d]) && !visited[r][c+moveArr[d]]){
                c = c+moveArr[d];
                return true;
            }
        }
        else{
            if(isValid(0, r+moveArr[d]) && !visited[r+moveArr[d]][c]){
                r = r+moveArr[d];
                return true;
            }
        }
        if(leftOrBack==0) d = (d!=0)?d-1:3;
        return false;
    }

    public static boolean isValid(int rowOrCol, int val){
        return val>0 && val<((rowOrCol==0)?N:M);
    }
}
