package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1497_combi {

	static String[] arr;
	static int N,M;
	static boolean[] visited, chosen;
	static int R, answer, answerNum = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		
		arr = new String[N];
		for(int i=0;i<N;i++) {
			tok = new StringTokenizer(br.readLine());
			tok.nextToken();
			arr[i] = tok.nextToken();
		}
		
		visited = new boolean[N];
		chosen = new boolean[N];
		
		for(R=N;R>0;R--) {
			combi(0,0);
		}
		
		if(answer==0) System.out.println(-1);
		else System.out.println(answer);
	}
	
	public static void combi(int start, int depth) {
		if(depth==R) {
			int num = 0;
			for(int i=0;i<M;i++) {
				for(int j=0;j<arr.length;j++) {
					if(!chosen[j]) continue;
					
					if(arr[j].charAt(i)=='Y') {
						num++;
						break;
					}
				}
			}
			
			if(num!=0 && answerNum <= num) {
				answer = R;
				answerNum = num;
			}
			
			return;
		}
		
		for(int i=start;i<visited.length;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			chosen[i] = true;
			combi(i+1,depth+1);
			chosen[i] = false;
			visited[i] = false;
		}
	}
}