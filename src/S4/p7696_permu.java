package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p7696_permu {
	
	static int n = 1;
	static final int MAXN = 1_000_001;
	static int[] allValues = new int[1_000_001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int depth = 1;
		while(n<MAXN) {
			permu(0,0,depth++,new boolean[10]);
		}
		while (true) {
			int inputNumber = Integer.parseInt(br.readLine());
			if(inputNumber==0) {
				break;
			}
			bw.write(String.valueOf(allValues[inputNumber]));
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}

	public static void permu(int num, int curDepth, int depth, boolean[] visited) {
		if (n == MAXN) {
			return;
		}
		if (curDepth == depth) {
			allValues[n++] = num;
		}
		for (int i = curDepth == 0 ? 1 : 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permu(num * 10 + i, curDepth + 1, depth, visited);
				visited[i] = false;
			}
		}
	}
}