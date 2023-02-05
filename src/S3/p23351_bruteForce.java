package S3;
import java.util.Arrays;
import java.util.Scanner;

public class p23351_bruteForce {
	
	static int[] pots;
	static int N,K,A,B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		
		pots = new int[N];
		Arrays.fill(pots, K);
		
		int days = 0;
		int minIdx = 0;
		do {
			days++;
			water(minIdx);
			for(int i=0;i<pots.length;i++) {
				pots[i]--;
			}
			minIdx = findMin();
		} while (pots[minIdx]>0);
		
		System.out.println(days);
	}
	
	public static void water(int startIdx) {
		for(int i=0;i<A;i++) {
			pots[(i+startIdx)%N]+=B;
		}
	}
	
	public static int findMin() {
		int minVal = Integer.MAX_VALUE;
		int minIdx = -1;
		
		for(int i=0;i<N;i++) {
			if(pots[i]<minVal) {
				minVal = pots[i];
				minIdx = i;
			}
		}
		
		return minIdx;
	}
}