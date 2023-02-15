package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15663_permu {
	static int N,M,maxNum,minNum=10_001;
	static int[] numCount = new int[10_001];
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
			numCount[input]++;
			maxNum = Math.max(maxNum, input);
			minNum = Math.min(minNum, input);
		}
		
		permu(0);
		
		System.out.println(sb.toString());
	}
	
	public static void permu(int depth) {
		if(depth==M) {
			for(int c:chosen) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=1;i<=maxNum;i++) {
			if(numCount[i]==0) continue;
			
			numCount[i]--;
			chosen[depth] = i;
			permu(depth+1);
			numCount[i]++;
		}
	}
}