package B2;
import java.util.Scanner;

public class p2292_math {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int level = 0;
		int startVal = 1;
		
		while(startVal<=N) {
			startVal+=(level==0?1:6*level);
			level++;
		}
		
		System.out.println(level);
		
	}
}