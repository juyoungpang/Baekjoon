package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15657_combiPermu {
	static int N, M;
	static int[] arr;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		
		arr = new int[N];
		tok = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}
		
		Arrays.sort(arr);
		
		combiPermu(new int[M], 0,0);
		
		System.out.println(sb.toString());
	}
	
	public static void combiPermu(int[] chosen, int start, int depth) {
		if(depth==M) {
			for(int c:chosen) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=start;i<N;i++) {
			chosen[depth] = arr[i];
			combiPermu(chosen, i, depth+1);
		}
	}
}