package S3;
import java.util.Arrays;
import java.util.Scanner;

//9
//5 12 7 10 9 1 2 3 11
//13

public class p3273_twoPointer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int p1 = 0;
		int p2 = arr.length-1;
		
		int x = sc.nextInt();
		
		int answer = 0;
		
		while(p1<p2) {
			if(arr[p1]+arr[p2]==x) {
				p1++;
				p2--;
				answer++;
			} else if(arr[p1]+arr[p2]>x) {
				p2--;
			} else {
				p1++;
			}
		}
		
		System.out.println(answer);
	}
}