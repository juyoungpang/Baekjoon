package B2;
import java.util.Scanner;

public class p14697_dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] n = new int[3];
		for(int i=0;i<3;i++) {
			n[i] = sc.nextInt();
		}
		int N = sc.nextInt();
		
		boolean[] dp = new boolean[301];
		
		dp[n[0]] = dp[n[1]] = dp[n[2]] = true;
		
		for(int i=n[0];i<=N;i++) {
			for(int j=0;j<3;j++) {
				if(i%n[j]==0 || i-n[j]>=0 && dp[i-n[j]]) {
					dp[i] = true;
					break;
				}
			}
		}
		
		System.out.println(dp[N]?1:0);
	}
}