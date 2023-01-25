//package G2;
//import java.util.Scanner;
//import java.util.Set;
//
////7
////1 1 2 3 4 2 1
//
//public class p17299_wrong {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		
//		int[] arr = new int[N];
//		int[] freq = new int[1000001];
//		Set<Integer>[] onTheRight = new Set[1000001];
//		
//		int minFreq = Integer.MAX_VALUE;
//		
//		for(int i=0;i<N;i++) {
//			arr[i] = sc.nextInt();
//			freq[arr[i]]++;
//			
//			minFreq = Math.min(minFreq, freq[arr[i]]);
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for(int i=N-1;i>=0;i--) {
//			int numsOnRight = N-i-1;
//			int numsSmallerThan = 0;
//			for(int j=freq[arr[i]];j>=minFreq;j--) {
//				numsSmallerThan += onTheRight[j];
//			}
//			if(numsOnRight-numsSmallerThan==0) sb.append("1- ");
//			else sb.append(numsOnRight-numsSmallerThan).append(" ");
//			
//			onTheRight[freq[arr[i]]]++;
//		}
//		
//		sb.setLength(sb.length()-1);
//		System.out.println(sb.reverse());
//	}
//}