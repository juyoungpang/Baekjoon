package S4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10816_binarySearch {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		N = nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = nextInt();
		}

		Arrays.sort(nums);

		int M = nextInt();
		while (M-- > 0) {
			int key = nextInt();
			int left = leftBound(key);
			int right = rightBound(key);

			if (left == -1)
				sb.append("0 ");
			else
				sb.append(right - left + 1).append(" ");
		}

		System.out.println(sb.toString());
	}

	public static int leftBound(int key) {
		int left = 0;
		int right = N - 1;
		int idx = -1;

		while (left <= right) {
			int middle = (left + right) / 2;
			if (nums[middle] >= key) {
				if (nums[middle] == key)
					idx = middle;
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return idx;
	}

	public static int rightBound(int key) {
		int left = 0;
		int right = N - 1;
		int idx = -1;

		while (left <= right) {
			int middle = (left + right) / 2;
			if (nums[middle] <= key) {
				if (nums[middle] == key)
					idx = middle;
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return idx;
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}