import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란깨기 {
	static int N, answer = 0;
	static int[] eggS, eggW; // 내구도, 무게
	static boolean[] cracked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		eggS = new int[N];
		eggW = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());

			eggS[i] = Integer.parseInt(tok.nextToken());
			eggW[i] = Integer.parseInt(tok.nextToken());
		}

		permu(0, new int[N]);

		System.out.println(answer);
	}
	
	public static void crack(int e1, int e2) {
		eggS[e1]-=eggW[e2];
		eggS[e2]-=eggW[e1];
	}
	
	public static void unCrack(int e1, int e2) {
		eggS[e1]+=eggW[e2];
		eggS[e2]+=eggW[e1];
	}

	public static void permu(int depth, int[] chosen) {
		cracked = new boolean[N];
		
		if (depth == N) {
			int num = 0;

			for (int i = 0; i < N; i++) {
				if (num >= N - 1) // 깰 계란이 없는 경우
					break;

				int toCrack = chosen[i];
				int cracking = i;
				
				if (cracked[toCrack]) // 깨려고 한 계란이 이미 깨진 경우
					return;

				if (cracked[cracking]) // 이미 계란이 깨진 경우
					continue;

				crack(toCrack, cracking);
				
				if(eggS[toCrack] <= 0) {
					num++;
					cracked[toCrack] = true;
				}
				
				if(eggS[cracking] <= 0) {
					num++;
					cracked[cracking] = true;
				}
				
				unCrack(toCrack, cracking);
			}

			answer = Math.max(answer, num);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (depth == i)
				continue;

			chosen[depth] = i;
			permu(depth + 1, chosen);
		}
	}
}