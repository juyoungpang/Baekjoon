import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//25330
public class Main3 {
	static int N, K, R,answer;
	static int[] A,P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tok.nextToken());
		K = Integer.parseInt(tok.nextToken());

		A = new int[N];
		tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tok.nextToken());
		}

		P = new int[N];
		tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(tok.nextToken());
		}

		for(R=1;R<=N;R++) {
			permutation(0,0,0,0);
		}
		
		System.out.println(answer);
	}
	
	public static void permutation(int depth, int flag, int damage, int people) {
		if(depth==R) {
			answer = Math.max(answer, people);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if((flag & i<<i) != 0) continue;
			
			int newdamage = damage*2+A[i];
			if(newdamage>K) {
				continue;
			}
			permutation(depth+1, flag|1<<i, newdamage, people+P[i]);
		}
	}
}