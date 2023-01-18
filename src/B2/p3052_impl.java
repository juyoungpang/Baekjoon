package B2;
import java.util.Scanner;

public class p3052_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] got = new boolean[42];
		int answer = 0;
		
		for(int i=0;i<10;i++) {
			int num = sc.nextInt();
			if(!got[num%42]) {
				got[num%42]=true;
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}