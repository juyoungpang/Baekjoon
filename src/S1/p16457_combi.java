package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p16457_combi {
	static int n,m,k,answer;
	static int[][] quests;
	static boolean[] visited, chosen;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(tok.nextToken());
		m = Integer.parseInt(tok.nextToken());
		k = Integer.parseInt(tok.nextToken());
		
		if(n==0 || m==0) {
			System.out.println(0);
			return;
		}
		if(k==0) {
			System.out.println(m);
			return;
		}
		
		chosen = new boolean[2*n+1];
		visited = new boolean[2*n+1];
		quests = new int[m][k];
		Arrays.fill(visited,true);
		
		int canPick = 0;
		for(int i=0;i<m;i++) {
			tok = new StringTokenizer(br.readLine());
			for(int j=0;j<k;j++) {
				quests[i][j] = Integer.parseInt(tok.nextToken());
				if(visited[quests[i][j]]) {
					visited[quests[i][j]]= false;
					canPick++;
				}
			}
		}
		
		if(n>=canPick) {
			System.out.println(m);
			return;
		}
		
		combi(1,0);
		
		System.out.println(answer);
	}
	
	public static void combi(int start, int depth) {
		if(depth==n) {
			int num = 0;
			for(int[] quest:quests) {
				boolean flag = true;
				for(int skill:quest) {
					if(!chosen[skill]) {
						flag = false;
						break;
					}
				}
				if(flag) num++;
			}
			
			answer = Math.max(num, answer);
			
			return;
		}
		
		for(int i = start; i<visited.length;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			chosen[i] = true;
			combi(i+1, depth+1);
			chosen[i] = false;
			visited[i] = false;
		}
	}
}