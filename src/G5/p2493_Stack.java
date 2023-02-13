package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2493_Stack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer tok = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int height = Integer.parseInt(tok.nextToken());
			while(!s.isEmpty()) {
				if(s.peek()[1]>=height) {
					sb.append(s.peek()[0]).append(" ");
					break;
				}
				s.pop();
			}
			if(s.isEmpty()) {
				sb.append(0).append(" ");
			}
			
			s.push(new int[] {i, height});
		}
		

		System.out.println(sb.toString());
	}
}
