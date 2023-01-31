package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2082_impl {
//	###  ..#  ###  ###  #.#  ###  ###  ###  ###  ###
//	#.#  ..#  ..#  ..#  #.#  #..  #..  ..#  #.#  #.#
//	#.#  ..#  ###  ###  ###  ###  ###  ..#  ###  ###
//	#.#  ..#  #..  ..#  ..#  ..#  #.#  ..#  #.#  ..#
//	###  ..#  ###  ###  ..#  ###  ###  ..#  ###  ###
//	

	static char[][][] digits = {
			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '.', '#' }, { '#', '.', '#' }, { '#', '#', '#' } }, // 0
			{ { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' } }, // 1
			{ { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' } }, // 2
			{ { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } }, // 3
			{ { '#', '.', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '.', '.', '#' } }, // 4
			{ { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } }, // 5
			{ { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' } }, // 6
			{ { '#', '#', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' } }, // 7
			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' } }, // 8
			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } }, // 9
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][][] input = new char[4][5][3];

		for (int i = 0; i < 5; i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				String temp = tok.nextToken();
				for (int k = 0; k < 3; k++) {
					input[j][i][k] = temp.charAt(k);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int in = 0; in < input.length; in++) {
			if (in == 2)
				sb.append(":");
			int digit = 0;
			for (int i = 0; i < input[0].length; i++) {
				for (int j = 0; j < input[0][0].length; j++) {
					// 켜져있는데 꺼져있어야하는 경우
					if (input[in][i][j] == '#' && digits[digit][i][j] == '.') {
						digit++;
						i = 0;
						j = 0;
					}
				}
			}
			sb.append(digit);
		}
		
		System.out.println(sb);

		br.close();

	}
}