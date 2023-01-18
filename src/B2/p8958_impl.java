package B2;
import java.util.Scanner;

public class p8958_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 0;test_case<T;test_case++) {
			String str = sc.next();
			int answer = 0;
			int curScore = 0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='O') {
					answer+=(++curScore);
				} else {
					curScore=0;
				}
			}
			System.out.println(answer);
		}
	}
}