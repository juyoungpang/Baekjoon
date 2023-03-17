package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class p2121_hashMapSetBetter {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static Map<Integer, Set<Integer>> map = new HashMap<>();
	static int[] x, y;

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		x = new int[n];
		y = new int[n];
		int dx = nextInt();
		int dy = nextInt();
		
		int answer = 0;

		for (int i = 0; i < n; i++) {
			int pointX = nextInt();
			int pointY = nextInt();
			
			x[i] = pointX;
			y[i] = pointY;
			
			if(!map.containsKey(pointX)) {
				map.put(pointX, new HashSet<>());
			}
			
			map.get(pointX).add(pointY);
		}
		
		int[][] dxdy = {{dx,0},{0,dy},{dx,dy}};
		
		for(int i=0;i<n;i++) {
			int pointX = x[i];
			int pointY = y[i];
			
			int ans = 1;
			
			for(int d=0;d<3;d++) {
				int nX = pointX+dxdy[d][0];
				int nY = pointY+dxdy[d][1];
				if(!(map.containsKey(nX) && map.get(nX).contains(nY))) {
					ans = 0;
					break;
				}
			}
			
			answer+=ans;
		}
		
		System.out.println(answer);
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}