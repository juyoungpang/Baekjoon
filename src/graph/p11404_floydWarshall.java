//floyd warshall

package graph;
import java.io.*;
import java.util.*;

public class p11404_floydWarshall { 
    static BufferedReader br;
    static BufferedWriter bw;

    static int N,M;
    static int a,b,c;
    static int costs[][];

    static final int INF = 20000000;
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //costs INF로 초기화
        costs = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                costs[i][j] = INF;
            }
        }

        //costs 갱신
        StringTokenizer st;
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            costs[a][b] = Math.min(c,costs[a][b]);
        }

        //플로이드 워샬 알고리즘 - 3중 for문
        //경유 - 출발 - 도착
        for(int k=1;k<N+1;k++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    costs[i][j] = Math.min(costs[i][j],costs[i][k]+costs[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i==j || costs[i][j]==INF) {
                    costs[i][j]=0;
                }
                sb.append(costs[i][j]+" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
