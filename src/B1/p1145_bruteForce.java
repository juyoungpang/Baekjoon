package B1;

import java.util.Scanner;

public class p1145_bruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[5];
		int answer = 101;
		for (int i = 0; i < 5; i++) {
			numbers[i] = sc.nextInt();
			answer = Math.min(answer, numbers[i]);
		}
		if(answer<4) answer = 4;

		/*
		 * 방법1: 전체 입력의 최솟값(4이상)보다 높은 값을 다 본다 최악의 경우 입력: 3 79 83 89 97
		 * 최악의 경우 시간: while loop는 최대 480,000번정도 돈다
		 */
		int a=0;
		while (true) {
			a++;
			int count = 0;
			for (int n : numbers) {
				if (answer % n == 0)
					count++;
			}
			if (count >= 3)
				break;

			answer++;
		}
		System.out.println(a);
		System.out.println(answer);
	}
}