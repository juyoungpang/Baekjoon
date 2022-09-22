package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11053_top {
    static int[] dp, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];
        StringTokenizer tok = new StringTokenizer(br.readLine());
        for(int i=0;i<dp.length;i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        Arrays.fill(dp, -1);
        
        for(int i=0;i<N;i++) {
            getSolution(i);
        }

        int max = dp[0];
        for(int i=1;i<N;i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static int getSolution(int pos) {
        if(dp[pos] == -1) {
            dp[pos] = 1;

            for(int i=pos-1;i>=0;i--) {
                if(arr[i]<arr[pos]) {
                    dp[pos] = Math.max(dp[pos], dp[i]+1);
                }
            }
        }

        return dp[pos];

    }
}
