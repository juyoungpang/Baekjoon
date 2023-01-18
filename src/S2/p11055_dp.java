package S2;

import java.util.*;

public class p11055_dp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		int dp[] = new int[N];
		dp[0] = arr[0];
		int max = dp[0];
		for(int i=1;i<N;i++) {
			dp[i] = arr[i];
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], arr[i]+dp[j]);
				}
			}
			max = Math.max(max, dp[i]);
		}
//		
//		for(int i=0;i<N;i++) {
//			System.out.print(dp[i]+" ");
//		}
		
		System.out.println("\n"+max);
	}
}
