package G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1256_top {

    static BufferedReader br;
    static StringTokenizer tok;
    static StringBuilder ret = new StringBuilder();

    static double dp[][];
    static final double maxK = 1000000000;

    public static void main(String[] args) throws IOException {
        int N,M;
        double K;
    
        br = new BufferedReader(new InputStreamReader(System.in));
        tok = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());
        K = Double.parseDouble(tok.nextToken());
        dp = new double[N+1][M+1];

        if(check(N, M)<K) {
			System.out.println("-1");
		}
        else {
			getSolution(N, M, K);
			System.out.println(ret.toString());
		}
    }

    private static double check(int a, int z) {
        if(a==0||z==0) return 1;
        if(dp[a][z]!=0) return dp[a][z];

        return dp[a][z] = Double.min(check(a,z-1)+check(a-1,z), maxK+1);
    }

    private static void getSolution(int a, int z, double k) {
        if(a==0) {
            for(int i=0;i<z;i++) ret.append("z");
            return;
        }
        if(z==0) {
            for(int i=0;i<a;i++) ret.append("a");
            return;
        }
        if(check(a-1,z)<k) {
            ret.append("z");
            getSolution(a, z-1, k-check(a-1,z));
        }
        else {
            ret.append("a");
            getSolution(a-1, z, k);
        }
    }
}
