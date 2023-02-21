package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 25330 SHOW ME THE DUNGEON

/*

나라는 0, 1, 2, ..., N번의 번호가 붙어있는 N+1개의 마을
0번 마을과 1, 2, ..., N번 마을을 오갈 수 있는 도로만 존재 -> N개의 도로
게임 시작은 0번 마을
1~N 마을에 몬스터 한 마리씩 위치
몇 개의 마을을 선택해서 순서로 방문
시루의 초기 체력 = K
i마을의 몬스터 공격력 = Ai
마을 주민 수 = Pi
마을 방문 시 몬스터와 싸운 뒤 마을 주민 해방
이전에 방문한 마을 + 방문하는 마을의 몬스터 공격력의 누적 만큼 체력 감소
체력이 0보다 작아지면 해방시키지 못하고 종료
해방 주민 최대 수
[입력]
첫째 줄에 몬스터의 수 N과 시루의 초기 체력K가 공백으로 구분되어 주어진다.
둘째 줄에 각 마을에 있는 몬스터의 공격력 A_1, A_2, ..., A_N이 공백으로 구분되어 주어진다.
셋째 줄에 각 마을에 있는 주민의 수 P_1, P_2, ..., P_N이 공백으로 구분되어 주어진다.
입력으로 주어지는 모든 값은 정수이다.
[출력]
시루가 해방시킬 수 있는 주민들의 최대 수
주민을 해방시킬 수 없다면 0을 출력
[제한]
1 <= N <= 20
1 <= K <= 100_000
1 <= Ai <= 100_000
1 <= Pi <= 100_000
백트래킹,
damage 때문에 순서가 중요해지네 -> 순열 => 20! - 시간 초과
sort를 하고 조합으로?
max <= N*Pi = 2_000_000 -> int */
public class p25330_sortComb_내가푼거아님 {
	static StringBuilder sb;
	static int N, K;
	static int[][] data; // Ai, Pi
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		// input
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		K = Integer.parseInt(st1.nextToken());

		data = new int[N][2];
		st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i][0] = Integer.parseInt(st1.nextToken());
			data[i][1] = Integer.parseInt(st2.nextToken());
		}
		// input end

		Arrays.sort(data, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o2[1] - o1[1];
			} else {
				return o1[0] - o2[0];
			}
		});

		comb(0, 0, K, 0);

		System.out.println(max);
	}// end of main

	private static void comb(int start, int sum, int hp, int damage) {
		if (start == N) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = start; i < N; i++) {
			if (hp < damage + data[i][0]) { // 이 마을에서 게임 종료
				max = Math.max(max, sum);
				continue;
			}

			comb(i + 1, sum + data[i][1], hp - damage - data[i][0], damage + data[i][0]);
		}
	}
} // end of class

/*
 * 20 100000 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 1 2 3 4 5 6 7 8
 * 9 10 11 12 13 14 15 16 17 18 19 20
 */