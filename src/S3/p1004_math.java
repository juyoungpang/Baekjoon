package S3;
import java.util.Scanner;

public class p1004_math {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int num=0;

			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int cx = sc.nextInt();
				int cy = sc.nextInt();
				int cr = sc.nextInt();

				if (pointIn(x1, y1, cx, cy, cr)^pointIn(x2,y2,cx,cy,cr))
					num++;
			}
			
			System.out.println(num);	

		}
	}

	public static boolean pointIn(int x, int y, int cx, int cy, int cr) {
		return Math.pow(x-cx, 2) + Math.pow(y-cy, 2) <= Math.pow(cr, 2);
	}
}