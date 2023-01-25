package S4;
import java.util.Arrays;
import java.util.Scanner;

//6
//9
//2 7 4 1 5 3

public class p1940_twoPointer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int M = sc.nextInt();
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		
		int answer = 0;
		
		while(left<right) {
			if(arr[left]+arr[right]==M) {
				left++;
				right--;
				answer++;
			} else if(arr[left]+arr[right]>M) {
				right--;
			} else {
				left++;
			}
			
		}
		System.out.println(answer);
	}
}