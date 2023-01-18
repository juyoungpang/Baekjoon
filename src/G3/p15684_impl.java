package G3;

import java.util.*;
import java.io.*;

public class p15684_impl {
	public static int[][] ladder;
	public static int N,M,H,min = 4;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		H = Integer.parseInt(tok.nextToken());
		
		if(M==0) {
			System.out.println(0);
			return;
		}
		
		ladder = new int[H][N-1];
		
		for(int m=0;m<M;m++) {
			tok = new StringTokenizer(br.readLine());
			ladder[Integer.parseInt(tok.nextToken())-1][Integer.parseInt(tok.nextToken())-1]=1;
		}
		
		simulate(0);
		
		System.out.println(min==4?-1:min);
		
	}
	
	public static int simulate(int count) {
		if(runLadder()) return count;
		if(count>min || count>3) return -1;
		
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<H;j++) {
				int left = i-1;
				int right = i;
				if(ladder[j][i]==1) continue;
				if(left>=0 && ladder[j][left]==1) continue;
				if(right<N-1 && ladder[j][right]==1) continue;
				
				ladder[j][i] = 1;
				int s = simulate(count+1);
				if(s!=-1) min = Math.min(min, s);
				ladder[j][i] = 0;
			}
		}
		
		return -1;
	}
	
	public static boolean runLadder() {
		for(int n=0;n<N;n++) {
			int curPlace = n;
			for(int i=0;i<H;i++) {
				int left = curPlace-1;
				int right = curPlace;
				if(left>=0 && ladder[i][left]==1) {
					curPlace = left;
				} else if(right<N-1 && ladder[i][right]==1) {
					curPlace = right+1;
				}
			}
			if(curPlace!=n) return false;
		}
		return true;
	}
}
