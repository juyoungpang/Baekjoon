package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p18310_bruteForce {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer tok = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}

		Arrays.sort(arr);

		long try1 = run(N / 2 - 1);
		long try2 = run(N / 2);
		long try3 = run(N/2+1);
		
		if(try1<=try2 && try1<=try3) {
			System.out.println(arr[N/2-1]);
		} else if(try2<=try1 && try2<=try3) {
			System.out.println(arr[N/2]);
		} else {
			System.out.println(arr[N/2+1]);
		}

	}

	public static long run(int idx) {
		int i = 1;
		long total = 0;
		
		if(idx<0 || idx>=N) {
			return Long.MAX_VALUE;
		}
		
		while (idx - i >= 0 || idx + i < N) {
			if (idx - i >= 0)
				total += (arr[idx] - arr[idx - i]);
			if (idx + i < N)
				total += (arr[idx + i] - arr[idx]);
			i++;
		}

		return total;
	}
}