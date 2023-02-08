package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11659_prefixSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tok = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tok.nextToken());
		int M = Integer.parseInt(tok.nextToken());
		
		int[] arr = new int[N+1];
		arr[0] = 0;
		tok = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
			if(i!=0) arr[i]+=arr[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			tok = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(tok.nextToken())-1;
			int end = Integer.parseInt(tok.nextToken());

			sb.append(arr[end]-arr[start]).append("\n");
		}
		
		System.out.println(sb.toString());
	} 
}