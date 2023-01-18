package B2;
import java.util.Scanner;

public class p8320_math {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int answer = N;
		for (int i = 2; i <= (int) Math.sqrt(N); i++) {
			for (int numBlocks = i * i; numBlocks <= N; numBlocks += i) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}