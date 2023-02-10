import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int N, K, answer;
	static int[] A, P;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		K = Integer.parseInt(tok.nextToken());

		A = new int[N];
		P = new int[N];
		visited = new boolean[N];

		tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tok.nextToken());
		}

		tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(tok.nextToken());
		}

		permu(0, 0, K);

		System.out.println(answer);

	}

	public static void permu(int depth, int p, int k) {
		if (k == 0 || depth == N) {
			answer = Math.max(answer, p);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			int newK = k - (K - k) - A[i];
			if(newK<0) continue;
			
			visited[i] = true;
			permu(depth+1, p+P[i], newK);
			visited[i] = false;
		}
	}
}