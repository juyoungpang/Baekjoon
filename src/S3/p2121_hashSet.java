package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class p2121_hashSet {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static Set<Point> set = new HashSet<>();
	static List<Point> list = new ArrayList<>();

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int dx = nextInt();
		int dy = nextInt();
		
		int answer = 0;

		for (int i = 0; i < n; i++) {
			Point newPoint = new Point(nextInt(), nextInt());
			set.add(newPoint);
			list.add(newPoint);
		}
		
		for(Point p:list) {
			Point nP1 = new Point(p.x+dx, p.y);
			Point nP2 = new Point(p.x+dx, p.y+dy);
			Point nP3 = new Point(p.x, p.y+dy);
			
			if(set.contains(nP1) && set.contains(nP2) && set.contains(nP3)) 
				answer++;
		}
		
		System.out.println(answer);
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}