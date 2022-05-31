package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576_bfs {
    
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok;

        int M,N,tomatoNum,oneNum=0,days=0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int[][] map;
        Queue<Point> queue;

        tok = new StringTokenizer(br.readLine());
        M = stoi(tok.nextToken());
        N = stoi(tok.nextToken());
        tomatoNum = M*N;

        map = new int[N][M];
        queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            tok = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int num = stoi(tok.nextToken());
                map[i][j] = num;
                if(num==-1) tomatoNum--;
                else if(num==1) {
                    queue.offer(new Point(i,j));
                    oneNum++;
                }
            }
        }

        while(oneNum!=tomatoNum) {
            days++;
            int qSize = queue.size();
            if(queue.isEmpty()) {
                days=-1;
                break;
            }
            for(int q=0;q<qSize;q++) {
                Point curPoint = queue.poll();
                for(int i=0;i<4;i++) {
                    int x = curPoint.x+dx[i];
                    int y = curPoint.y+dy[i];
                    if(x>=0 && y>=0 && x<N && y<M && map[x][y]==0) {
                        queue.offer(new Point(x,y));
                        map[x][y] = 1;
                        oneNum++;
                    }
                }
            }
        }
        System.out.println(days);
    }

}
