package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//bottom up

public class p11052_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer tok = new StringTokenizer(br.readLine());
        int[] P = new int[N+1];
        for(int i=1;i<=N;i++) P[i] = Integer.parseInt(tok.nextToken());

        int[] dp = new int[N+1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=i;j++) {
                dp[i] = Math.max(dp[i], P[j]+dp[i-j]);
            }
        }

        System.out.println(dp[N]);
    }
}
