package brute_force;

import java.io.*;
import java.util.*;

public class g5_15686 {
	static int N, M;

	static List<Pair> houses;
	static List<Pair> chickens;

	static boolean[] chosen;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());

		houses = new ArrayList<>();
		chickens = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(tok.nextToken());
				if (num == 1)
					houses.add(new Pair(i, j));
				else if (num == 2)
					chickens.add(new Pair(i, j));
			}
		}

		chosen = new boolean[chickens.size()];

		combi(0, 0);

		System.out.println(min);
		
		br.close();
	}

	public static void combi(int index, int count) {
		if (count == M) {
			findMin();
			return;
		}

		for (int i = index; i < chickens.size(); i++) {
			if (!chosen[i]) {
				chosen[i] = true;
				combi(i + 1, count + 1);
				chosen[i] = false;
			}
		}
	}

	public static void findMin() {
		int total = 0;
		for (int i = 0; i < houses.size(); i++) {
			int dist = Integer.MAX_VALUE;
			for (int j = 0; j < chickens.size(); j++) {
				if (chosen[i]) {
					int temp = Math.abs(chickens.get(j).r-houses.get(i).r)+
							Math.abs(chickens.get(j).c-houses.get(i).c);
					dist = Math.min(dist, temp);
				}
			}
			total += dist;
		}

		min = Math.min(min, total);
	}

	static class Pair {
		int r;
		int c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}