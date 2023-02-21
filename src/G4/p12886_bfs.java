package G4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p12886_bfs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		boolean[][] visited = new boolean[1501][1501];
		visited[a][b] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,b,c});

		boolean flag = false;
		while(!q.isEmpty()) {
			int[] num = q.poll();
			
			for(int i=0;i<3;i++) {
				int[] n = num.clone();
				
				if(n[0] == n[1] && n[1]==n[2]) {
					flag = true;
					System.out.println(1);
					return;
				}
				
				if((n[0]+n[1]+n[2])%3!=0) {
					System.out.println(0);
					return;
				}

				if(i==0) {
					if(n[0]==n[1]) continue;
					int new0 = n[0]>n[1]?n[0]-n[1]:n[0]*2;
					int new1 = n[1]>n[0]?n[1]-n[0]:n[1]*2;
					n[0] = new0;
					n[1] = new1;
				} else if(i==1) {
					if(n[2]==n[1]) continue;
					int new1 = n[1]>n[2]?n[1]-n[2]:n[1]*2;					
					int new2 = n[2]>n[1]?n[2]-n[1]:n[2]*2;
					n[1] = new1;
					n[2] = new2;
				} else {
					if(n[2]==n[0]) continue;
					int new0 = n[0]>n[2]?n[0]-n[2]:n[0]*2;
					int new2 = n[2]>n[0]?n[2]-n[0]:n[2]*2;		
					n[0] = new0;
					n[2] = new2;
				}
				
				if(visited[n[0]][n[1]])
					continue;
				
				q.add(n);
				visited[n[0]][n[1]] = true;
			}
		}
		
		System.out.println(0);
	}
}