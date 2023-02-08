package B2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3040_combi {
	
	static int[] arr = new int[9];
	static boolean flag;
	
	public static void p3040_combi (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		combi(0,0,0,new int[7],new boolean[9]);
	}
	
	public static void combi(int total, int start, int depth, int[] chosen, boolean[] visited) {
		if(flag) return;
		
		if(depth==7) {
			if(total==100) {
				StringBuilder sb = new StringBuilder();
				for(int c:chosen) {
					sb.append(c).append("\n");
				}
				System.out.println(sb);
				flag = true;
			}
			
			return;
		}
		
		for(int i=start;i<9;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			chosen[depth] = arr[i];
			combi(total+chosen[depth], i+1, depth+1, chosen, visited);
			visited[i] = false;
		}
	}
}