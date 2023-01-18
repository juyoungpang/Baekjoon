package S1;

import java.io.*;
import java.util.*;

public class p14888_bruteForce {
	static int[] A, O;
	static int N;

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		A = new int[N];
		StringTokenizer tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tok.nextToken());
		}

		O = new int[4];
		tok = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			O[i] = Integer.parseInt(tok.nextToken());
		}
		
		for(int i=0;i<O.length;i++) {
			if(O[i]!=0) {
				O[i]--;
				cal(1,i,A[0]);
				O[i]++;
			}
		}
		
		System.out.println(max+"\n"+min);
		
		br.close();
	}
	

	public static void cal(int idx, int op, int ans) {
		
		switch (op) {
		case 0:
			ans += A[idx];
			break;
		case 1:
			ans -= A[idx];
			break;
		case 2:
			ans *= A[idx];
			break;
		default:
			ans /= A[idx];
			break;
		}

		if(idx==N-1) {
			min = Math.min(min, ans);
			max = Math.max(max, ans);
			return;
		}
		
		for(int i=0;i<O.length;i++) {
			if(O[i]>0) {
				O[i]--;
				cal(idx+1, i, ans);
				O[i]++;
			}
		}
		
	}
}
