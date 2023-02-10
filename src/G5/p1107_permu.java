package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1107_permu {

	static int answer = Integer.MAX_VALUE, digit, input;
	static boolean[] broken = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = Integer.parseInt(br.readLine());

		digit = getDigit(input);

		int M = Integer.parseInt(br.readLine());

		if (M == 0) {
			System.out.println(Math.min(digit, Math.abs(100 - input)));
			return;
		}
		if (M == 10) {
			System.out.println(Math.abs(100 - input));
			return;
		}

		StringTokenizer tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			broken[Integer.parseInt(tok.nextToken())] = true;
		}

		permu(0, 0);

		System.out.println(Math.min(answer, Math.abs(100 - input)));
	}

	public static int getDigit(int integer) {
		int d = 1;
		while ((int) (integer / Math.pow(10, d++)) != 0)
			;
		return d - 1;
	}

	public static void permu(int depth, int chosen) {
		if ((depth!=0 && depth==digit-1) || depth == digit || depth == digit + 1) {
			answer = Math.min(answer, getDigit(chosen) + Math.abs(chosen - input));

			if(depth==digit+1) return;
		}

		for (int i = 0; i < 10; i++) {
			if (broken[i])
				continue;

			permu(depth + 1, chosen * 10 + i);
		}
	}
}