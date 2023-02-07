package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1527_permu {
	static long A, B, count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(tok.nextToken());
		B = Integer.parseInt(tok.nextToken());
		
		permu(0);
		
		System.out.println(count);
	}
	
	public static void permu(long num) {
		if(num>=A && num<=B) {
			count++;
		}
		
		for(int i=0;i<2;i++) {
			long newNum = num*10+((i==0)?4:7);
			if(newNum>B) continue;
			
			permu(newNum);
		}
	}
}