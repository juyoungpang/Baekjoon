package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2805_binarySearch {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[] height;

	public static void main(String[] args) throws IOException {
		N = nextInt();
		M = nextInt();
		
		height = new int[N];
		for (int i = 0; i < N; i++) {
			height[i] = nextInt();
		}

		System.out.println(binarySearch(1, 1_000_000_000));
	}

	public static long binarySearch(long left, long right) {
		long answer = 0;
		while (left <= right) {
			long middle = (left + right) / 2;
			if (calc(middle)) {
				answer = middle;
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return answer;
	}

	public static boolean calc(long H) {
		long totalWoods = 0;
		for (long h : height) {
			if (h > H) {
				totalWoods += h - H;
			}
		}
		return totalWoods >= M;
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}