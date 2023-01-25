package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2467_twoPointer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer tok = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = N-1;
		int leftVal = 0;
		int rightVal = N-1;
		while(right>left) {
			int num = arr[left]+arr[right];
			if(min>=Math.abs(num)) {
				min = Math.abs(num);
				leftVal = left;
				rightVal = right;
			}
			
			if(num>0) {
				right--;
			} else {
				left++;
			}
		}
		
		System.out.println(arr[leftVal]+" "+arr[rightVal]);
	} // end of main
} //end of class
