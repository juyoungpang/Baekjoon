package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14499_impl_wrong {
    static int N,M,x,y,K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());
        x = Integer.parseInt(tok.nextToken());
        y = Integer.parseInt(tok.nextToken());
        K = Integer.parseInt(tok.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++) {
            tok = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
    }
}
