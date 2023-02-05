package S4;
import java.util.Arrays;
import java.util.Scanner;

public class p15970_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Point[] points = new Point[N];

		for (int i = 0; i < N; i++) {
			points[i] = new Point(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(points);

		int answer = 0;

		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int curColor = points[i].color;
			int curPos = points[i].pos;

			int left = i - 1;
			while (left >= 0) {
				if (points[left].color == curColor) {
					int dist = curPos - points[left].pos;
					min = Math.min(dist, min);
					break;
				}
				left--;
			}

			int right = i + 1;
			while (right < N) {
				int dist = points[right].pos - curPos;
				if (dist > min) {
					break;
				}
				if (points[right].color == curColor) {
					min = Math.min(dist, min);
					break;
				}
				right++;
			}

			answer += min;
		}

		System.out.println(answer);
	}
}

class Point implements Comparable<Point> {
	int pos;
	int color;

	public Point(int pos, int color) {
		this.pos = pos;
		this.color = color;
	}

	@Override
	public int compareTo(Point p) {
		return this.pos - p.pos;
	}

}