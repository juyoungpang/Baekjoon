package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2961_combi {
	
	static int answer = Integer.MAX_VALUE;
	static int N;
	static int[][] ingredients;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ingredients = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			ingredients[i][0] = Integer.parseInt(tok.nextToken());
			ingredients[i][1] = Integer.parseInt(tok.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			combi(1,0,0,0,i,new boolean[N]);
		}
		
		System.out.println(answer);
	}
	
	public static void combi(int sour, int bitter, int start, int curDeapth, int limDeapth, boolean[] visited) {
		if(curDeapth == limDeapth) {
			if(Math.abs(sour-bitter)<answer) {
				answer = Math.abs(sour-bitter);
			}
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			combi(sour*ingredients[i][0], bitter+ingredients[i][1], i+1, curDeapth+1, limDeapth, visited);
			visited[i] = false;
		}
	}
}