package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1463_top {
    
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        System.out.println(topDown(N));
    }

    public static int topDown(int n) {
        if(n==1) return 0;

        if(dp[n]>0) return dp[n];
        
        dp[n] = topDown(n-1)+1;
        
        if (n % 2 == 0) {
            int temp = topDown(n/2) + 1;
            if (dp[n] > temp) {
                dp[n] = temp;
            }
        }
        if (n % 3 == 0) {
            int temp = topDown(n/3) + 1;
            if (dp[n] > temp) {
                dp[n] = temp;
            }
        }
 
        return dp[n];
    }
}
