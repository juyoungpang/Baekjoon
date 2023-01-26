package B2;
import java.util.Scanner;

public class p15593_bruteForce{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] guards = new int[N][2];
		int[] time = new int[1001];
		
		int totalTime = 0;
		
		for(int i=0;i<N;i++) {
			guards[i][0] = sc.nextInt();
			guards[i][1] = sc.nextInt();
			
			for(int j=guards[i][0];j<guards[i][1];j++) {
				if(time[j]==0) totalTime++;
				time[j]++;
			}
		}
		
		int answer = -1;
		
		for(int i=0;i<N;i++) {
			int temp = totalTime;
			for(int j=guards[i][0];j<guards[i][1];j++) {
				if(time[j]==1) temp--;
			}
			answer = Math.max(answer, temp);
		}
		
		System.out.println(answer);
	}
}