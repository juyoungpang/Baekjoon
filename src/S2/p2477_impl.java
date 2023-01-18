package S2;
import java.util.Scanner;

public class p2477_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] map = new int[6];

		int maxLen = 0;
		int maxIdx = 0;
		for (int i = 0; i < map.length; i++) {
			sc.nextInt();
			map[i] = sc.nextInt();

			if (map[i] > maxLen) {
				maxIdx = i;
				maxLen = map[i];
			}
		}

		int area = (map[(maxIdx + 1) % 6] * map[(maxIdx + 2) % 6])
				+ (map[(maxIdx - 1) >= 0 ? (maxIdx - 1) : (maxIdx - 1 + 6)]
						* map[(maxIdx - 2) >= 0 ? (maxIdx - 2) : (maxIdx - 2 + 6)]);
		
		System.out.println(area*N);

	}
}