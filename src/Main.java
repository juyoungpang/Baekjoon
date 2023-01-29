import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int min = Integer.MAX_VALUE;
	static double[][] position = new double[4][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		for(int i=0;i<4;i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			position[i][0] = Double.parseDouble(tok.nextToken());
			position[i][1] = Double.parseDouble(tok.nextToken());
		}
		
		permu(0, new boolean[4], new int[3]);
		
		System.out.println(min);
	}

	public static void permu(int depth, boolean[] visited, int[] order) {
		if(depth==3) {
			int curPos = 0;
			double totalDist = 0;
			for(int p:order) {
				totalDist += dist(position[curPos][0],position[curPos][1],position[p][0],position[p][1]);
				curPos = p;
			}
			min = Math.min(min, (int) totalDist);
			return;
		}
		
		for(int i=1;i<=3;i++) {
			if(!visited[i]) {
				visited[i]=true;
				order[depth] = i;
				permu(depth+1, visited, order);
				visited[i]=false;
			}
		}
	}

	public static double dist(double r1, double c1, double r2, double c2) {
		return Math.sqrt(Math.pow(r1 - r2, 2.0) + Math.pow(c1 - c2, 2.0));
	}
}