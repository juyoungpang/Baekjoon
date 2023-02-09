public class MyAnswer {
	int N, answer = 0;
	int[] eggS, eggW; // 내구도, 무게

	public int run(int N, int[] eggS, int[] eggW) {

		this.N = N;
		this.eggS = eggS.clone();
		this.eggW = eggW.clone();
		
		permu(0, new int[N]);

		return answer;
	}

	public void permu(int depth, int[] chosen) {
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