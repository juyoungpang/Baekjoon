package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15655_combi {
	
	static int N,M;
	static int[] arr;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		
		arr = new int[N];
		tok = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}
		
		Arrays.sort(arr);
		
		combi(0,0,new int[M], new boolean[N]);
		
		System.out.println(sb.toString());
	}
	
	public static void combi(int start, int depth, int[] chosen, boolean[] visited) {
		if(depth==M) {
			for(int c:chosen) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			chosen[depth] = arr[i];
			combi(i+1, depth+1,chosen,visited);
			visited[i] = false;
		}
	}
}