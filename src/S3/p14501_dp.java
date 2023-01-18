package S3;

import java.io.*;
import java.util.*;

public class p14501_dp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int t[] = new int[N];
		int p[] = new int[N];
		int dp[] = new int[N+1];
		
		for(int i=0;i<N;i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(tok.nextToken());
			p[i] = Integer.parseInt(tok.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			if(i+t[i]<=N) {
				dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i]+p[i]);
			}
			if(i>0) dp[i] = Math.max(dp[i], dp[i-1]);
		}
		
		System.out.println(Math.max(dp[N-1], dp[N]));
		br.close();
	}
}
