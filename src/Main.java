
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, countCloud;
	static int[][] A;
	static List<int[]> cloud = new ArrayList<>();
	static boolean[][] isCloud;

	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int[][] drdc = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());

		A = new int[N][N];
		isCloud = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		cloud.add(new int[] {N-1,0});
		cloud.add(new int[] {N-1,1});
		cloud.add(new int[] {N-2,0});
		cloud.add(new int[] {N-2,1});
		
		countCloud = 4;
		
		for(int m=0;m<M;m++) {
			tok = new StringTokenizer(br.readLine());
			moveCloud(Integer.parseInt(tok.nextToken())-1, Integer.parseInt(tok.nextToken()));
			rain();
			copyRain();
			newCloud();
		}
		
		int answer = 0;
		for(int[] rows:A) {
			for(int num:rows) {
				answer+=num;
			}
		}
		System.out.println(answer);
	}

	// 모든 구름이 di 방향으로 si칸 이동한다.
	public static void moveCloud(int d, int s) {
		for (int[] rc : cloud) {
			rc[0] = (rc[0] + (drdc[d][0] * s)) % N;
			rc[1] = (rc[1] + (drdc[d][1] * s)) % N;
			
			if(rc[0]<0) {
				rc[0] = N+rc[0];
			}
			if(rc[1]<0) {
				rc[1] = N+rc[1];
			}
			
			isCloud[rc[0]][rc[1]] = true;
		}
	}

	// 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
	public static void rain() {
		for (int[] rc : cloud) {
			A[rc[0]][rc[1]]++;
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	// 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
	public static void copyRain() {
		for (int[] rc : cloud) {
			int countBasket = 0;
			for (int d = 1; d < drdc.length; d += 2) { // 대각선이니까 원래 배열 이용
				int newR = rc[0] + drdc[d][0];
				int newC = rc[1] + drdc[d][1];

				if (!isValid(newR, newC))
					continue;
				
				if(A[newR][newC]>0) 
					countBasket++;
			}
			A[rc[0]][rc[1]]+=countBasket;
		}
	}
	
	// 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
	public static void newCloud() {
		int countNewCloud = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(A[i][j]>=2 && !isCloud[i][j]) {
					countNewCloud++;
					cloud.add(new int[] {i,j});
					isCloud[i][j] = true;
					A[i][j]-=2;
				}
			}
		}
		
		deleteCloud();
		
		countCloud = countNewCloud;
	}
	
	public static void deleteCloud() {
		for(int i=0;i<countCloud;i++) {
			int[] deletedCloud = cloud.remove(0);
			isCloud[deletedCloud[0]][deletedCloud[1]] = false;
		}
	}

}