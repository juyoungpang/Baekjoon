package G2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2121_binarySearch {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static long count;
	static int n;
	static int[] A, B, C, D, AB, CD;

	public static void main(String[] args) throws IOException {
		n = nextInt();
		A = new int[n];
		B = new int[n];
		C = new int[n];
		D = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = nextInt();
			B[i] = nextInt();
			C[i] = nextInt();
			D[i] = nextInt();
		}

		createCombi();

		Arrays.sort(CD);

		for (int i = 0; i < n * n; i++) {
			int lowerBound = lowerBound(AB[i] * -1);
			int upperBound = upperBound(AB[i] * -1);

			count += (upperBound - lowerBound) + 1;
		}

		System.out.println(count);
	}

	public static int lowerBound(int key) {
		int left = 0;
		int right = n * n - 1;
		int idx = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (CD[mid] >= key) {
				idx = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return idx;
	}

	public static int upperBound(int key) {
		int left = 0;
		int right = n * n - 1;
		int idx = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (CD[mid] <= key) {
				idx = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return idx;
	}

	public static void createCombi() {
		AB = new int[n * n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[idx++] = A[i] + B[j];
			}
		}
		CD = new int[n * n];
		idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				CD[idx++] = C[i] + D[j];
			}
		}
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}