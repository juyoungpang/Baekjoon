package jenna.S3;
import java.util.Scanner;

public class p15649_permu {
	static int N,R;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		permu(0, new int[R], new boolean[N+1]);
	}
	
	public static void permu(int depth, int[] chosen, boolean[] visited) {
		if(depth==R) {
			for(int c:chosen) {
				System.out.print(c+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				chosen[depth] = i;
				permu(depth+1, chosen, visited);
				visited[i] = false;
			}
		}
	}
}
