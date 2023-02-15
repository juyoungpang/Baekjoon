package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2630_divConq {
	static int[][] paper;
	static int white, blue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for(int i=0;i<N;i++) {
			tok = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		cut(0,N,0,N);
		
		System.out.println(white+"\n"+blue);
	}
	
	public static void cut(int left, int right, int top, int bottom) {
		int check = check(left,right,top,bottom);
		if(check!=-1) {
			if(check==0) white++;
			else blue++;
			return;
		}
		
		//top left
		cut(left,(left+right)/2,top,(top+bottom)/2);
		//top right
		cut((left+right)/2,right,top,(top+bottom)/2);
		//bottom left
		cut(left,(left+right)/2,(top+bottom)/2,bottom);
		//bottom right
		cut((left+right)/2,right,(top+bottom)/2,bottom);		
	}
	
	public static int check(int left, int right, int top, int bottom) {
		int first = paper[top][left];
		for(int i=top;i<bottom;i++) {
			for(int j=left;j<right;j++) {
				if(paper[i][j]!=first) {
					return -1;
				}
			}
		}
		
		return first;
	}
}