package B1;
import java.util.Scanner;

public class p2180_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.next();
		String input = sc.next();
		
		int holders=0;
		for(int i=0;i<input.length();i++) {
			if(i==0) holders++;
			if(input.charAt(i)=='S') holders++;
			else {
				holders++;
				i++;
			}
		}
		
		System.out.println(holders>input.length()?input.length():holders);
	}
}