package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p19949_permu {
	static int num;
	static int[] answer = new int[10], chosen = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		for (int i = 0; i < 10; i++) {
			answer[i] = Integer.parseInt(tok.nextToken());
		}

		permu(0, 0, 0);

		System.out.println(num);
	}

	public static void permu(int depth, int before2, int before) {
		if (depth == 10) {
			int correct = 0;
			for (int i = 0; i < 10; i++) {
				if (chosen[i] == answer[i]) {
					correct++;
				}
			}
			if (correct >= 5)
				num++;
			return;
		}

		for (int i = 1; i <= 5; i++) {
			if (before2 != 0 && before2 == before && before == i)
				continue;

			chosen[depth] = i;
			permu(depth + 1, before, i);
		}
	}
}