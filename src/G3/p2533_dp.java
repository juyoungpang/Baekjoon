package G3;

import java.util.*;

public class p2533_dp {
	static int N;
	static List<Integer>[] map;
	static int[][] dp;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new ArrayList[N+1];
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		
		for(int i=1;i<N+1;i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=1;i<N;i++) {
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			
			map[p1].add(p2);
			map[p2].add(p1);
		}
		
		dfs(1);
		
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	public static void dfs(int level) {
		
		visited[level] = true;
		dp[level][0] = 0;
		dp[level][1] = 1;
		
		for(int nextLevel:map[level]) {
			if(!visited[nextLevel]) {
				dfs(nextLevel);
				dp[level][0] += dp[nextLevel][1];
				dp[level][1] += Math.min(dp[nextLevel][0], dp[nextLevel][1]);
			}
		}
	}
}
