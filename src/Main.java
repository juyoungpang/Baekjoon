import java.util.Scanner;

public class Main {

	static String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	static int[] ds = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int M = sc.nextInt();

		int day = 3;

		int d = 1;
		int m = 1;

		while (m<M) {
			day = (day + m) % 7;
			d++;

			if ((d == 29 && m == 2) || (d == 30 && (m == 4 || m == 6 || m == 9 || m == 11))
					|| (d == 31 && (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12))) {
				m++;
				d = 1;
			}
		}

		System.out.println(days[day]);
	}
}