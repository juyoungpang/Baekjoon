package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//위상정렬 사용해서 다시..
public class p1005_wrong {
	
	static int[] dp;
	static List<Integer>[] children;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0;tc<T;tc++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tok.nextToken());
			int K = Integer.parseInt(tok.nextToken());
			
			children = new List[N];
			dp = new int[N];
			
			tok = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				children[i] = new ArrayList<>();
				children[i].add(Integer.parseInt(tok.nextToken()));
			}
			
			for(int j=0;j<K;j++) {
				tok = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tok.nextToken())-1;
				int y = Integer.parseInt(tok.nextToken())-1;
				
				children[y].add(x);
			}
			
			int w = Integer.parseInt(br.readLine())-1;
			findVal(w);
			System.out.println(dp[w]);
			
		} // end of tc
	} // end of main
	
	public static void findVal(int n) {
		if(dp[n]!=0) return;
		
		if(children[n].size()==1) {
			dp[n] = children[n].get(0);
			return;
		}
		
		int num = 0;
		
		for(int i=1;i<children[n].size();i++) {
			int child = children[n].get(i);
			
			if(dp[child]==0) {
				findVal(child);
			}
			
			num = Math.max(num, dp[child]);
		}
		
		dp[n] = num+children[n].get(0);
	}
} // end of class