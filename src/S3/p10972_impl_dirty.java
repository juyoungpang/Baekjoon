package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10972_impl_dirty {
	static int[] input;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(tok.nextToken());
		}

		int[] answer = input.clone();
		boolean found = false;

		for (int i = N - 2; i >= 0; i--) {
			if (input[i] > input[i + 1]) {
				continue;
			}

			int num = 0;
			for (int j = N - 1; j > i; j--) {
				if (answer[i] < answer[j]) {
					num = answer[j];
					break;
				}
			}
			answer[i] = num;
			Arrays.sort(input, i, N);

			int idx = i + 1;
			for (int j = i; j < N; j++) {
				if (input[j] == num)
					continue;
				answer[idx++] = input[j];
			}
			found = true;
			break;
		}

		if (found) {
			for (int ans : answer) {
				System.out.print(ans + " ");
			}
		} else {
			System.out.println(-1);
		}
	}

}