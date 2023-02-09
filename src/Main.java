import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int S, P, total, numPos;
	static String input;
	static int[] counts = new int[4];
	static Map<Character, Integer> map = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tok = new StringTokenizer(br.readLine());
		S = Integer.parseInt(tok.nextToken());
		P = Integer.parseInt(tok.nextToken());

		input = br.readLine();

		tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < counts.length; i++) {
			counts[i] = Integer.parseInt(tok.nextToken());
		}

		// first window
		int l = 0;
		int r = P;
		for (int i = l; i < r; i++) {
			counts[map.get(input.charAt(i))]--;
		}

		for (int c : counts) {
			if (c > 0)
				numPos++;
		}

		if (numPos == 0)
			total++;

		while (r < S) {
			int idxL = map.get(input.charAt(l++));
			int idxR = map.get(input.charAt(r++));
			counts[idxL]++;
			counts[idxR]--;

			if (idxL != idxR) {
				if (counts[idxL] == 1)
					numPos++;
				if (counts[idxR] == 0)
					numPos--;
			}
			
			if (numPos == 0)
				total++;
		}

		System.out.println(total);
	}
}