package B1;
import java.util.Scanner;

public class p3985_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] taken = new boolean[L+1];
		
		int max = 0;
		int maxPerson = 0;
		
		int actualMax = 0;
		int actualMaxPerson = 0;
		
		for(int i=0;i<N;i++) {
			int p = sc.nextInt()-1;
			int k = sc.nextInt()-1;
			
			if(k-p>max) {
				max = k-p;
				maxPerson = i+1;
			}
			
			int got = 0;
			for(int j=p;j<=k;j++) {
				if(!taken[j]) {
					taken[j]=true;
					got++;
				}
			}
			
			if(got>actualMax) {
				actualMax = got;
				actualMaxPerson = i+1;
			}
		}
		
		System.out.println(maxPerson);
		System.out.println(actualMaxPerson);
	}
}