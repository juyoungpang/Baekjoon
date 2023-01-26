package S3;
import java.util.Scanner;

public class p2503_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] table = new int[N][3]; // 수,스트라이크,볼

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				table[i][j] = sc.nextInt();
			}
		}

		int count = 0;
		

		for (int n = 123; n <= 987; n++) {
			int n1 = n / 100;
			int n2 = (n / 10) % 10;
			int n3 = n % 10;

			if (n1 == n2 || n1 == n3 || n2 == n3 || n1==0 || n2==0 || n3==0)
				continue;
			
			for (int i = 0; i < table.length; i++) {
				int t1 = table[i][0] / 100;
				int t2 = (table[i][0] / 10) % 10;
				int t3 = table[i][0] % 10;

				int strike = 0;
				if (t1 == n1)
					strike++;
				if (t2 == n2)
					strike++;
				if (t3 == n3)
					strike++;

				int ball = 0;
				if (n1 == t2 || n1 == t3)
					ball++;
				if (n2 == t1 || n2 == t3)
					ball++;
				if (n3 == t1 || n3 == t2)
					ball++;

				if (strike != table[i][1] || ball != table[i][2]) {
					count--;
					break;
				}
			}
			count++;
		}
		System.out.println(count);
		
	}
}