package S4;
import java.util.Scanner;

public class p2567_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[][] map = new boolean[101][101];
		
		int N = sc.nextInt();

		int answer = 0;
		
		for (int n = 0; n < N; n++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			
			for(int i=x1;i<x1+10;i++)  {
				for(int j=y1;j<y1+10;j++) {
					if(!map[i][j]) {
						map[i][j] = true;
					}
				}
			}
		}
		
		for(int i=0;i<101;i++) {
			for(int j=0;j<100;j++) {
				if(j==0&&map[i][j]) {
					answer++;
					continue;
				}
				
				if(!map[i][j]&&map[i][j+1]) {
					answer++;
					continue;
				}
			}
		}
		for(int i=0;i<101;i++) {
			for(int j=0;j<100;j++) {
				if(j==0&&map[j][i]) {
					answer++;
					continue;
				}
				
				if(!map[j][i]&&map[j+1][i]) {
					answer++;
					continue;
				}
			}
		}
		for(int i=0;i<101;i++) {
			for(int j=100;j>0;j--) {
				if(j==0&&map[j][i]) {
					answer++;
					continue;
				}
				
				if(!map[j][i]&&map[j-1][i]) {
					answer++;
					continue;
				}
			}
		}
		for(int i=0;i<101;i++) {
			for(int j=100;j>0;j--) {
				if(j==0&&map[i][j]) {
					answer++;
					continue;
				}
				
				if(!map[i][j]&&map[i][j-1]) {
					answer++;
					continue;
				}
			}
		}
		System.out.println(answer);
	}
}