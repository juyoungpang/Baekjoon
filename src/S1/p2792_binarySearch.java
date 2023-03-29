package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2792_binarySearch {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[] gems;

	public static void main(String[] args) throws IOException {
		N = nextInt();
		M = nextInt();

		gems = new int[M];
		for (int i = 0; i < M; i++) {
			gems[i] = nextInt();
		}

		int left = 1;
		int right = (int) 1e9; // 1.0 곱하기 10의 9승
		int answer = Integer.MAX_VALUE;
		while (left <= right) {
			int middle = (int) (left + right) / 2;
			int sum = 0;
			int maxVal = -1;
			for (int g : gems) {
				int temp = g / middle + (g % middle == 0 ? 0 : 1);
				maxVal = Math.max(maxVal, temp);
				sum += temp;
			}

			if (sum <= N) {
				answer = Math.min(middle, answer);
				right = middle-1;
			} else {
				left = middle+1;
			}
		}
		
		System.out.println(answer);
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}