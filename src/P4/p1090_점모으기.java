package P4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p1090_점모으기 {
	static int[][] allPoints;
	static List<Integer> rows = new ArrayList<>();
	static List<Integer> cols = new ArrayList<>();
	static int[][] distances;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		allPoints = new int[N][2]; // row-col
		StringTokenizer tok;
		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tok.nextToken());
			int c = Integer.parseInt(tok.nextToken());

			allPoints[i][0] = r;
			allPoints[i][1] = c;

			if (!rows.contains(r))
				rows.add(r);
			if (!cols.contains(c))
				cols.add(c);
		}
		
		distances = new int[rows.size()*cols.size()][N];
		
		int idx = 0;
		for(int i=0;i<rows.size();i++) {
			for(int j=0;j<cols.size();j++) {
				for(int k=0;k<N;k++) {
					distances[idx][k] = (Math.abs(allPoints[k][0]-rows.get(i))+Math.abs(allPoints[k][1]-cols.get(j)));
				}
				Arrays.sort(distances[idx]);
				idx++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("0 ");
		
		for(int i=2;i<=N;i++) {
			int min = Integer.MAX_VALUE;
			for(int[] dist:distances) {
				int temp = 0;
				for(int j=0;j<i;j++) {
					temp+=dist[j];
				}
				min = Math.min(min, temp);
			}
			sb.append(min).append(" ");
		}
		
		System.out.println(sb);
	}
}