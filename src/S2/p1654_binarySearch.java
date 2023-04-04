package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1654_binarySearch {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;
	static int[] wires;

	public static void main(String[] args) throws IOException {
		K = nextInt();
		N = nextInt();

		wires = new int[K];
		for (int i = 0; i < K; i++) {
			wires[i] = nextInt();
		}

		long left = 0L;
		long right = (long) Integer.MAX_VALUE;
		long answer = -1;
		while (left <= right) {
			long middle = ((left + right) / 2);
			if(check(middle)) {
				left = middle+1;
				answer = middle;
			} else {
				right = middle-1;
			}
		}
		
		System.out.println(answer);
	}
	
	public static boolean check(long val) {
		int total = 0;
		for(int wire:wires) {
			total+=wire/val;
		}
		return total>=N;
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}