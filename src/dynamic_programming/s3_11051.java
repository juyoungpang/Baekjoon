package dynamic_programming;

import java.util.*;

public class s3_11051 {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		dp = new int[N+1][K+1];
		for(int[] row:dp) Arrays.fill(row,-1);
		
		System.out.println(combi(N,K));
	}
	
	public static int combi(int n, int k) {
		if(dp[n][k]!=-1) return dp[n][k];
		
		if(k==0 || n==k) return dp[n][k]=1;
		
		return dp[n][k] = (combi(n-1,k-1)+combi(n-1,k))%10007;
	}
}
