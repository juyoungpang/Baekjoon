package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p14400_sorting {
	static Point [] points;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tok.nextToken());
		points = new Point [N];

		for (int n = 0; n < N; n++) {
			tok = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tok.nextToken());
			int y = Integer.parseInt(tok.nextToken());

			points[n] = new Point (x, y);
		}
		
		Arrays.sort(points, new Comparator<Point >() {

			@Override
			public int compare(Point  o1, Point  o2) {
				// TODO Auto-generated method stub
				return o1.x-o2.x;
			}
		});
		
		int midX = points[N/2].x;
		
		Arrays.sort(points, new Comparator<Point >() {

			@Override
			public int compare(Point  o1, Point  o2) {
				// TODO Auto-generated method stub
				return o1.y-o2.y;
			}
		});
		
		int midY = points[N/2].y;
		
		Point  center = new Point (midX,midY);

		long answer = 0;

		for (Point  p : points) {
 			answer+=center.diff(p);
		}
		
		System.out.println(answer);

	}
}

class Point {
	int x = 0;
	int y = 0;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int diff(Point  p) {
		return Math.abs(p.x - this.x) + Math.abs(p.y - this.y);
	}
}