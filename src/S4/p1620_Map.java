package S4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p1620_Map {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tok.nextToken());
		int M = Integer.parseInt(tok.nextToken());
		
		Map<String,Integer> pi = new HashMap<>();
		Map<Integer,String> ip = new HashMap<>();
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			pi.put(input, i+1);
			ip.put(i+1, input);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			String input = br.readLine();
			try {
				int idx = Integer.parseInt(input);
				sb.append(ip.get(idx)).append("\n");
			} catch (Exception e) {
				sb.append(pi.get(input)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}