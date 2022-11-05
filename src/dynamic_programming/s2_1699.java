package dynamic_programming;

import java.util.*;

public class s2_1699 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			if(Math.sqrt(i) - (int)Math.sqrt(i)==0) {
				dp[i] = 1;
				continue;
			}
			dp[i] = dp[i-1]+1;
			for(int j=2;j*j<i;j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		System.out.println(dp[n]);
	}
}
