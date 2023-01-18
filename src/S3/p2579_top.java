package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2579_top {

    static int[] dp, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        Arrays.fill(dp,-1);

        dp[0] = 0;
        dp[1] = arr[1];

        if(N>=2) dp[2] = arr[1] + arr[2];

        System.out.println(find(N));
    }

    private static int find(int N) {
        if(dp[N]==-1)
            dp[N] = Math.max(find(N-2), find(N-3)+arr[N-1]) + arr[N];
        
        return dp[N];
    }
    
}
