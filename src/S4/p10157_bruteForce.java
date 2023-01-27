package S4;
import java.util.Scanner;

public class p10157_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();
		
		if(K>R*C) {	//앉을 수 있는 범위를 벗어나는 경우 바로 0을 출력
			System.out.println(0);
			return;
		}
				
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int x = 1;	//현재 위치 x
		int y = 1;	//현재 위치 y
		int k = 1;	//현재 번호 k
		int d = 0;	//현재 direction
		
		boolean[][] visited = new boolean[R+1][C+1];	//이미 앉았는지 확인하는 용
		visited[1][1] = true;
		
		while(true) {
			int newX = x+dx[d];
			int newY = y+dy[d];
			//k가 원하는 위치에 도달했거나 + newX나newY가 범위를 벗어났거나 + 이미 앉은 경우 앉지말고 dirction change
			while(k<K && newX>0 && newX<=C && newY>0 && newY<=R && !visited[newY][newX]) {
				x=newX;
				y=newY;
				k++;
				visited[y][x] = true;
			}
			if(k==K) {
				break;
			}
			d = (d+1)%4;
		}
		
		System.out.println(x+" "+y);
		
	}
}