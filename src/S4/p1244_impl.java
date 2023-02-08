package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1244_impl {

	static int[] switches;

	static final int MALE = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // number of switches
		switches = new int[N]; // 0==false==off, 1==true==on

		StringTokenizer tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			switches[i] = Integer.parseInt(tok.nextToken());
		}

		int S = Integer.parseInt(br.readLine()); // num of students

		for (int i = 0; i < S; i++) {
			tok = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(tok.nextToken());
			int num = Integer.parseInt(tok.nextToken()) - 1; // index여야해서 1빼기

			if (gender == MALE) {
				male(num);
			} else
				female(num);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(switches[i]).append(" ");
			if ((i + 1) % 20 == 0)
				sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void male(int num) {
		for (int i = num; i < switches.length; i += (num + 1)) {
			switches[i] = (switches[i] - 1) * -1;
		}
	}

	public static void female(int num) {
		int left = num - 1;
		int right = num + 1;

		if (left < 0 || right >= switches.length) {
			switches[num] = (switches[num] - 1) * -1;
			return;
		}

		while (left >= 0 && right < switches.length) {
			if (switches[left] != switches[right])
				break;
			left--;
			right++;
		}

		for (int i = left + 1; i < right; i++) {
			switches[i] = (switches[i] - 1) * -1;
		}
	}
}