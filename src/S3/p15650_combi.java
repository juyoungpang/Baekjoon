package S3;
import java.util.Scanner;

public class p15650_combi {
	static int N,R;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		combi(0, 1, new int[R], new boolean[N+1]);
	}
	
	public static void combi(int depth, int start, int[] chosen, boolean[] visited) {
		if(depth==R) {
			for(int c:chosen) {
				System.out.print(c+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				chosen[depth] = i;
				combi(depth+1, i+1, chosen, visited);
				visited[i] = false;
			}
		}
	}
}
