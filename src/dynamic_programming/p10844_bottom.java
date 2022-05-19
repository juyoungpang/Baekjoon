package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10844_bottom {

    static BufferedReader br;

    static int N;
    static long dp[][];
    final static long mod = 1000000000;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];

        for(int i=1;i<10;i++) {
            dp[1][i] = 1;
        }

        for(int i=2;i<N+1;i++) {
            for(int j=0;j<10;j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][j+1] % mod;
                }
                else if(j==9) {
                    dp[i][j] = dp[i-1][j-1] % mod;
                }
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        long result = 0;

        for(long n : dp[N]) {
            result += n;
        }

        System.out.println(result % mod);
        
    }
}
