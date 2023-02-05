import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] board = new Point[N];

		for (int n = 0; n < N; n++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			board[n] = new Point(Integer.parseInt(tok.nextToken()),Integer.parseInt(tok.nextToken()));
		}
		
		Arrays.sort(board, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.x-o2.x;
			}
		});
		
		int midX = board[N/2].x;
		
		Arrays.sort(board, new Comparator<Point>() {
			
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y-o2.y;
			}
		});
		
		int midY = board[N/2].y;
		
		for(Point p:board) {
			System.out.print(Math.abs(midX-p.x)+Math.abs(midY-p.y)+" ");
		}
		

	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}