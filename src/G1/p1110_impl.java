package G1;

import java.util.*;

public class p1110_impl {
	
	static int[] num;
	static int input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextInt();
		num = new int[2];
		
		num[0] = input/10;
		num[1] = input%10;
		
		System.out.println(cycle(0));
		
	}
	
	public static int cycle(int count) {
		if(count!=0 && num[0]==input/10 && num[1]==input%10) {
			return count;
		}
		
		int temp = num[0] + num[1];
		num[0] = num[1];
		num[1] = temp%10;
		
		return cycle(count+1);
	}
}
