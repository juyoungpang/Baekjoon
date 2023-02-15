package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15666_permu {
	static int N,M,maxNum,minNum=10_001;
	static boolean[] numAppear = new boolean[10_001];
	static int[] chosen;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		
		visit = new boolean[10];
		chosen = new int[M];
		tok = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(tok.nextToken());
			numAppear[input] = true;
			maxNum = Math.max(maxNum, input);
			minNum = Math.min(minNum, input);
		}
		
		permu(0,minNum);
		
		System.out.println(sb.toString());
	}
	
	public static void permu(int depth, int lastChosen) {
		if(depth==M) {
			for(int c:chosen) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=lastChosen;i<=maxNum;i++) {
			if(!numAppear[i]) continue;
			
			chosen[depth] = i;
			permu(depth+1,i);
		}
	}
}