import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		boolean[][] visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j)=='0'?true:false;
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,1,0});
		while(!q.isEmpty()) {
			int[] point = q.poll(); // r, c, dist, wallBroken
			visited[point[0]][point[1]] = true;
			
			if(point[0]==N-1 && point[1]==M-1) {
				System.out.println(point[2]);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int newR = point[0] + dr[i];
				int newC = point[1] + dc[i];
				
				if(newR<0 || newR>=N || newC<0 || newC>=M || visited[newR][newC]) {
					continue;
				}
				
				if(!map[newR][newC]) { // 못가는 벽이라도 만약 부술수 있으면 넣음
					if(point[3]==0) {
						q.offer(new int[] {newR, newC, point[2]+1, point[3]+1});
					}
				} else {
					q.offer(new int[] {newR, newC, point[2]+1, point[3]});
				}
			}
		}
		System.out.println(-1);
	}
}