package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10972_wrong_bruteForce {
	static int N;
	static int[] input, before;
	static boolean found;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		before = new int[N];
		StringTokenizer tok = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i]=Integer.parseInt(tok.nextToken());
		}
		
		permu(new boolean[N+1], 0, new int[N]);
		
		if(!found) {
			System.out.println(-1);
		}
	}
	
	public static void permu(boolean[] visited, int depth, int[] current) {
		if(found)
			return;
		
		if(depth==N) {
			for(int i=0;i<N;i++) {
				if(input[i]!=before[i]) {
					before = current.clone();
					return;
				}
			}
			for(int c:current) {
				System.out.print(c+" ");
			}
			found = true;
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			current[depth] = i;
			permu(visited, depth+1, current);
			visited[i] = false;
		}
	}
}