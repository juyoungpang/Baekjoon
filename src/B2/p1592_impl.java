package B2;
import java.util.Scanner;

public class p1592_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] people = new int[N];
		
		int answer = 0;
		
		int curr = 0;
		while(people[curr] != M) {
			if(people[curr]%2==0) { // 짝수
				curr = (curr-L)>=0?(curr-L):N+(curr-L);
			} else { // 홀수
				curr = (curr+L)%N;
			}			
			
			people[curr]++;
			answer++;
		}
		
		System.out.println(answer-1);
	}
}