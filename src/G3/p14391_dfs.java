package G3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14391_dfs {
	static int[][] original, action;
	static int N, M, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());

		original = new int[N + 2][M + 2];
		action = new int[N + 2][M + 2];
		for(int i=1;i<=N;i++) {
			String temp = br.readLine();
			for(int j=1;j<=M;j++) {
				original[i][j] = temp.charAt(j-1)-'0';
			}
		}
		
		dfs(1,1);
		
		System.out.println(max);
		
	}

	public static void dfs(int r, int c) {
		if (r == N+1) { // 끝
			boolean[][] visited = new boolean[N+2][M+2];
			int totalNum = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (visited[i][j])
						continue;

					if (action[i][j] == 0) { // 안 붙인다
						totalNum += original[i][j];
						visited[i][j] = true;
					} else if (action[i][j] == 1) { // 가로
						int k = j+1;
						int num = original[i][j];
						visited[i][j] = true;
						while(action[i][k] == 1) {
							num*=10;
							num+=original[i][k];
							visited[i][k] = true;
							k++;
						}
						totalNum+=num;
					}  else { // 세로
						int k = i+1;
						int num = original[i][j];
						visited[i][j] = true;
						while(action[k][j] == 2) {
							num*=10;
							num+=original[k][j];
							visited[k][j] = true;
							k++;
						}
						totalNum+=num;
					}
				}
			}
//			max = Math.max(max, totalNum);
			if(totalNum>max) {
				max = totalNum;
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			if(r==N && action[r-1][c]!=2 && i==2) { // 맨 아래 줄인데 위가 2도 아니면 2는 안들어감
				continue;
			}
			
			if(c==M && action[r][c-1]!=1 && i==1) { // 맨 오른쪽인데 왼쪽이 1도 아니면 1은 안들어감
				continue;
			}
			
			if(c!=1 && action[r][c-1]==1 && action[r][c-2]!=1 && i!=1) {
				continue;
			}
			
			if(r!=1 && action[r-1][c]==2 && action[r-2][c]!=2 && i!=2) {
				continue;
			}
			
			action[r][c] = i;

			int newR = r;
			int newC = c + 1;
			if (newC == M + 1) {
				newC = 1;
				newR = r + 1;
			}
			dfs(newR, newC);
		}
	}

}