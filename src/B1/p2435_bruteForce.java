package B1;
import java.util.Scanner;

public class p2435_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		// first sum
		int sum = 0;
		for(int i=0;i<K;i++) {
			sum+=arr[i];
		}
		
		// 앞에 하나 빼고 뒤에 하나 더해가면서 비교
		int max = sum;
		for(int i=K;i<N;i++) {
			sum+=arr[i];
			sum-=arr[i-K];
			
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
	}
}