package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2529_bruteForce {
	static int[] collected;
	static boolean[] visited;
	
	static boolean increasing, found;
	static boolean[] biggerThan;
	static int k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		biggerThan = new boolean[k];
		
		StringTokenizer tok = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			biggerThan[i] = tok.nextToken().equals("<")?true:false;
		}
		
		collected = new int[k+1];
		visited = new boolean[10];

		permu(0);

		found = false;
		increasing = true;
		permu(0);
	}
	
	public static void permu(int depth) {
		if(found) return;
		if(depth==k+1) {
			if(check()) {
				StringBuilder sb = new StringBuilder();
				for(int c:collected) {
					sb.append(c);
				}
				System.out.println(sb);
				found=true;
			}
			return;
		}
		
		int num = increasing?0:9;
		
		while(num>=0 && num<10) {
			if(!visited[num]) {
				visited[num] = true;
				collected[depth] = num;
				permu(depth+1);
				visited[num] = false;
			}
			num = increasing?num+1:num-1;
		}
	}
	
	public static boolean check() {
		for(int i=0;i<k;i++) {
			if(collected[i+1]>collected[i]!=biggerThan[i]) {
				return false;
			}
		}
		return true;
	}
}