package S3;
import java.util.Scanner;

//10 2
//3 -2 -4 -9 0 3 7 13 8 -3

public class p2559_twoPointer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int startIdx = 0;
		long total = 0;
		long max = 0;

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			
			if (i < K) {
				total += arr[i];
				max+=arr[i];
				continue;
			}
			
			total-=arr[startIdx++];
			total+=arr[i];
			
			max = Math.max(total, max);
		}

		System.out.println(max);
	}
}