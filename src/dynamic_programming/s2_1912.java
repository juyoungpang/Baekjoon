package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        int dp[] = new int[N];

        StringTokenizer tok = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }

        dp[0] = arr[0];

        int max = Integer.MIN_VALUE;

        for(int i=1;i<N;i++) {
            dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
            if(dp[i]>max) max = dp[i];
        }

        System.out.println(Math.max(max,dp[0]));
    }
}
