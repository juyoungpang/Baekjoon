import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyMain {
	static int N, answer = 0;
	static int[] eggS, eggW; // 내구도, 무게

//	public static void main(String[] args) throws IOException {
	public static int main() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test_case.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		eggS = new int[N];
		eggW = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());

			eggS[i] = Integer.parseInt(tok.nextToken());
			eggW[i] = Integer.parseInt(tok.nextToken());
		}

		permu(0, new int[N]);

//		System.out.println(answer);
		return answer;
	}

	public static void permu(int depth, int[] chosen) {
		if (depth == N) {
			int num = 0;
			int[] tempS = eggS.clone();

			for (int i = 0; i < N; i++) {
				if (num >= N - 1) // 깰 계란이 없는 경우
					break;

				if (tempS[chosen[i]] <= 0) // 깨려고 한 계란이 이미 깨진 경우
					return;

				if (tempS[i] <= 0) // 이미 계란이 깨진 경우
					continue;

				tempS[chosen[i]] -= eggW[i];
				tempS[i] -= eggW[chosen[i]];

				if (tempS[chosen[i]] <= 0) {
					num++;
				}
				if (tempS[i] <= 0) {
					num++;
				}
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