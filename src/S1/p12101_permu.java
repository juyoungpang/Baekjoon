package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12101_permu {
	static int n,k,found;
	static boolean end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(tok.nextToken());
		k = Integer.parseInt(tok.nextToken());
		
		permu(new StringBuilder(), 0);
		if(!end) System.out.println(-1);
	}
	
	public static void permu(StringBuilder sb, int total) {
		if(end) {
			return;
		}
		
		if(total==n) {
			found++;
			if(found==k) {
				System.out.println(sb.toString());
				end = true;
			}
			return;
		}
		
		for(int i=1;i<=3;i++) {
			if((total+i)>n) continue;
			if(sb.length()>0) sb.append("+");
			sb.append(i);
			permu(sb, total+i);
			sb.setLength(sb.length()-(sb.length()==1?1:2));
		}
	}
}