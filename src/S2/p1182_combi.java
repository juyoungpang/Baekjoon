package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1182_combi {
	static int N, S, R, answer;
	static int[] input;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		S = Integer.parseInt(tok.nextToken());
		
		visited = new boolean[N];
		input = new int[N];
		tok = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(tok.nextToken());
		}

		for (R = 1; R <= N; R++) {
			combi(0,0,0);
		}
		
		System.out.println(answer);
	}

	public static void combi(int start, int depth, int total) {
		if (depth == R) {
			if (total == S) {
				answer++;
			}
			return;
		}
		
		for(int i=start;i<input.length;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			combi(i+1, depth+1, total+input[i]);
			visited[i] = false;
		}
		
	}
}