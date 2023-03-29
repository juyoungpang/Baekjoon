package B1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2775_dp {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[15][15];
		for(int i=0;i<15;i++) {
			dp[0][i] = i;
		}
		for(int i=1;i<15;i++) {
			for(int j=1;j<15;j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1];
			}
		}
		
		while(testcase-->0) {
			sb.append(dp[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb);
	}
}