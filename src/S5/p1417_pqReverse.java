package S5;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p1417_pqReverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N==1) {
			System.out.println(0);
			return;
		}
		
		int me = sc.nextInt();
		int count = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=1;i<N;i++) {
			pq.add(sc.nextInt());
		}
		
		while(pq.peek()>=me) {
			pq.add(pq.poll()-1);
			me++;
			count++;
		}
		
		System.out.println(count);
	}
}