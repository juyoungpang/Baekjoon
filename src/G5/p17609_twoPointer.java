package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17609_twoPointer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			char[] arr = br.readLine().toCharArray();
			if(isPalindrome(arr, 0, arr.length-1)) {
				System.out.println(0);
				continue;
			}
			
			if(isSimilarPalindrome(arr, 0, arr.length-1)) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
			
		}

	} // end of main

	public static boolean isPalindrome(char[] arr, int left, int right) {
		while (left < right) {
			if (arr[left] != arr[right]) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	} // end of isPalindrome

	public static boolean isSimilarPalindrome(char[] arr, int left, int right) {
		while (left < right) {
			if (arr[left] != arr[right]) {
				if(!isPalindrome(arr, left+1,right) && !isPalindrome(arr, left, right-1)) return false;
				else return true;
			}
			left++;
			right--;
		}
		
		return true;
	} // end of isSimilarPalindrome
} // end of class
