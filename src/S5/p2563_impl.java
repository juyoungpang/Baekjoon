package S5;
import java.util.Scanner;

public class p2563_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[][] map = new boolean[100][100];
		
		int N = sc.nextInt();

		int answer = 0;
		
		for (int n = 0; n < N; n++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			
			for(int i=x1;i<x1+10;i++)  {
				for(int j=y1;j<y1+10;j++) {
					if(!map[i][j]) {
						answer++;
						map[i][j] = true;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}