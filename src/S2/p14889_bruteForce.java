package S2;

import java.io.*;
import java.util.*;

public class p14889_bruteForce {
	
	static int N;
	static int[][] S;
	static int[] visited;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		visited = new int[N];
		for(int i=0;i<N;i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				S[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		combi(0,0);
		
		System.out.println(min);
	}
	
	public static void combi(int idx, int count) {
		if(count==N/2) {
			calc();
			return;
		}
		
		for(int i=idx;i<N;i++) {
			visited[i] = 1;
			combi(i+1, count+1);
			visited[i] = 0;
		}
	}
	
	public static void calc() {
		int star = 0;
		int link = 0;
		for(int i=0;i<visited.length-1;i++) {
			for(int j=i+1;j<visited.length;j++) {
				if(visited[i]==0&&visited[j]==0) {
					star += S[i][j]+S[j][i];
				} else if (visited[i]==1&&visited[j]==1) {
					link += S[i][j]+S[j][i];
				}
			}
		}
		
		int diff = Math.abs(star-link);
		
		min = Math.min(min,diff);
	}
}
