package S5;

import java.util.*;

public class p1010_dp {
	
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		dp = new int[31][31];
		for(int[] row:dp) Arrays.fill(row,-1);
		
		for(int t=0;t<T;t++) {
			int r = sc.nextInt();
			int n = sc.nextInt();
			
			System.out.println(combi(n,r));
		}
	}
	
	public static int combi(int n, int r) {
		if(dp[n][r]>0) return dp[n][r];
		
		if(r==0 || n==r) return dp[n][r] = 1;
		
		return dp[n][r] = combi(n-1,r-1)+combi(n-1,r);
	}
}
