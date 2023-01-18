package S1;

import java.io.*;
import java.util.*;

public class p2667_dfs{
    static BufferedReader br;

    static int N;
    static int[][] map;

    static Stack<Point> points;
    static List<Integer> address;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = tmp.charAt(j)-'0'==1?1:0;
            }
        }

        address = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1){
                    address.add(dfs(i,j,1));
                }
            }
        }
    }

    public static int dfs(int row, int col, int num){
        if(col>0&&map[row][col-1]==1) {
            map[row][col-1]=0;
            num+=dfs(row,col-1,num);
        }
        if(col<N-1&&map[row][col+1]==1) {
            map[row][col+1]=0;
            num+=dfs(row,col+1,num);
        }
        if(row>0&&map[row-1][col]==1) {
            map[row-1][col]=0;
            num+=dfs(row-1,col,num);
        }
        if(row<N-1&&map[row+1][col]==1) {
            map[row+1][col]=0;
            num+=dfs(row+1,col,num);
        }
        return num;
    }

    public static class Point{
        int row,col;

        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}