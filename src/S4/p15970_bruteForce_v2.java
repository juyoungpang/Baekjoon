package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;


public class p15970_bruteForce_v2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] points = new ArrayList[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(tok.nextToken());
			int color = Integer.parseInt(tok.nextToken());

			if (points[color] == null) {
				points[color] = new ArrayList<>();
			}
			points[color].add(pos);
		}

		int answer = 0;

		for (ArrayList<Integer> p : points) {
			if (p == null)
				continue;
			
			p.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
			
			for (int i = 0; i < p.size(); i++) {
				if (i == 0) {
					answer += p.get(i + 1) - p.get(i);
				} else if (i == p.size() - 1) {
					answer += p.get(i) - p.get(i - 1);
				} else {
					answer += Math.min(p.get(i + 1) - p.get(i), p.get(i) - p.get(i - 1));
				}
			}
		}

		System.out.println(answer);
	}
}
