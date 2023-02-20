package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p21608_impl {

	static int N, score, numVoid;
	// 상 하 좌 우
	static int[][] drdc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] fav;
	static int[][] seating;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		N = Integer.parseInt(br.readLine());
		
		seating = new int[N][N];
		fav = new boolean[(N*N)+1][(N*N)+1];
		for(int n=0;n<N*N;n++) {
			tok = new StringTokenizer(br.readLine());
			int studNum = Integer.parseInt(tok.nextToken());
			for(int i=0;i<4;i++) {
				fav[studNum][Integer.parseInt(tok.nextToken())] = true;
			}
			
			sit(studNum);
		}
		
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				check(i,j,seating[i][j]);
				answer += (int) Math.pow(10, (score-1));
			}
		}
		
		System.out.println(answer);
	}
	
//	비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
//	1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
//	2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
	public static void sit(int studNum) {
		int maxScore = 0;
		int maxVoid = -1;
		int r = 0;
		int c = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(seating[i][j]!=0) 
					continue;
				
				check(i,j,studNum);
				
				if(score<maxScore || (score==maxScore && numVoid<=maxVoid))
					continue;
				
				maxScore = score;
				maxVoid = numVoid;
				r = i;
				c = j;
			}
		}
		
		seating[r][c] = studNum;
	}

	
//	해당 자리에 대한 만족도 및 비어있는 자리를 구한다
	public static void check(int r, int c, int studNum) {
		score = 0;
		numVoid = 0;
		for(int d=0;d<drdc.length;d++) {
			int newR = r+drdc[d][0];
			int newC = c+drdc[d][1];
			
			if(!isValid(newR,newC))
				continue;
			
			if(fav[studNum][seating[newR][newC]])
				score++;
			
			if(seating[newR][newC]==0)
				numVoid++;
		}
	}
	
	public static boolean isValid(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}