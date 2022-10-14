package implementation;

import java.util.*;
import java.io.*;

public class g3_17822 {

	static int N, M, T;
	static int[][] plate;
	static int[] top;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		T = Integer.parseInt(tok.nextToken());

		plate = new int[N][M];
		top = new int[N];

		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				plate[i][j] = Integer.parseInt(tok.nextToken());
			}
		}

		int total = 0;

		for (int t = 0; t < T; t++) {
			tok = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(tok.nextToken());
			int D = Integer.parseInt(tok.nextToken());
			int K = Integer.parseInt(tok.nextToken());

			for (int i = X - 1; i < N; i += X) {
				for (int k = 0; k < K; k++) {
					if (D == 0) {
						top[i]--;
						if (top[i] < 0)
							top[i] = M - 1;
					} else {
						top[i] = (top[i] + 1) % M;
					}
				}
			}

//			print();
			
			int val = 0;
			int count = 0;
			boolean wasErased = false;

			int[][] clone = new int[plate.length][];
			for (int i = 0; i < plate.length; i++) {
				clone[i] = plate[i].clone();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int curCol = (top[i]+j) % M;
					
					if (plate[i][curCol] != 0) {
						val += plate[i][curCol];
						count++;

						// 같은 판 옆
						int next = curCol + 1;
						if (next == M)
							next = 0;
						if (plate[i][next] == plate[i][curCol]) {
							clone[i][curCol] = clone[i][next] = 0;
							wasErased=true;
						}
						// 안쪽판
						int inRow = i - 1;
						if (inRow > 0) {
							int inCol = (top[inRow]+j) % M;
							if(plate[inRow][inCol] == plate[i][curCol]) {
								clone[i][curCol] = clone[inRow][inCol] = 0;
								wasErased=true;
							}
						}
						// 바깥쪽 판
						int outRow = i+1;
						if(outRow<N) {
							int outCol = (top[outRow]+j)%M;
							if(plate[outRow][outCol] == plate[i][curCol]) {
								clone[i][curCol] = clone[outRow][outCol] = 0;
								wasErased=true;
							}
						}
					}
				}
			}
			for (int i = 0; i < plate.length; i++) {
				plate[i] = clone[i].clone();
			}

//			print();
			
			total=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!wasErased) {
						double avg = (double) val / count;
						if (plate[i][j] != 0) {
							if (plate[i][j] < avg)
								plate[i][j]++;
							else if (plate[i][j] > avg)
								plate[i][j]--;
						}
					}
					total += plate[i][j];
				}
			}
			
//			print();
		}
		System.out.println(total);
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int col = (top[i]+j)%M;
				
				System.out.print(plate[i][col]+" ");
			}
			System.out.println("");
		}
		System.out.println("==================");
	}
}
