import java.util.Arrays;
import java.util.Scanner;

/**
 * 알고리즘 퀴즈 [input] 5 3 1 2 3 4 5
 * 
 * 5P3 순열 : 60개 5π3 중복순열 : 125개 5C3 조합 : 10개 5H3 중복조합 : 35개 2^5 부분집합 : 32개 피보나치
 * 5항 : 5 하노이5개회수: 31회
 * 
 * @author 서민규 쌤
 * @since 2023.02.22
 */
public class TestAlgo_1_방주영 {
	private static int N;
	private static int R;
	private static int[] input; // 사용자 입력받은 숫자 배열
	private static int[] numbers; // 순열에서 뽑은 숫자 담을 배열
	private static boolean[] isSelected; // 사용한 숫자인지 체크할 플래그 배열
	private static int total;

	public static void main(String[] args) {
		System.out.println("알고리즘 연습");
		input(); // 사용할 데이터를 입력받아서 저장하는 메서드
		System.out.println("입력하신 숫자 배열 : " + Arrays.toString(input));

		System.out.println("■■■1. 순열 3P3 : 반복문 사용, 배열원소는 {1,2,3} ■■■");
		permutationLoop1();

		System.out.println("■■■2. 중복순열 3π3 : 반복문 사용, 배열원소는 {1,2,3} ■■■");
		permutationLoop2();

		System.out.println("■■■3. 순열 nPr: selected 배열사용 ■■■");
		total = 0;
		permutationSelected1(0);
		System.out.println("개수 : " + total);

		System.out.println("■■■4. 순열 nPr: selected 배열 대신 flag 비트마스킹 사용 ■■■");
		total = 0;
		permutationSelectedBitMaking(0, 0);
		System.out.println("개수 : " + total);

		System.out.println("■■■5. 중복순열 nπr : selected 배열사용 ■■■");
		total = 0;
		permutationSelected2(0);
		System.out.println("개수 : " + total);

// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

		System.out.println("■■■6. 조합 5C3 : 반복문 사용, 배열원소는 {1,2,3,4,5} ■■■");
		combinationLoop1();

		System.out.println("■■■7. 중복조합 5H3 : 반복문 사용, 배열원소는 {1,2,3,4,5} ■■■");
		combinationLoop2();

		System.out.println("■■■8. 조합 : nCr = n-1Cr + n-1Cr-1 사용 ■■■");
		total = 0;
		combination1(N, R);
		System.out.println("개수 : " + total);

		System.out.println("■■■9. 조합 : nCr 다음 시작 위치 start 사용 ■■■");
		total = 0;
		combination2(0, 0);
		System.out.println("개수 : " + total);

		System.out.println("■■■10. 중복조합 : nHr 다음 시작 위치 start 사용 ■■■");
		total = 0;
		combination3(0, 0);
		System.out.println("개수 : " + total);

// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

		System.out.println("■■■11. 순열 nPn : NextPermutation 사용 ■■■");
		permutation_NextPermutation1();

		System.out.println("■■■12. 순열 nPr : NextPermutation 사용 ■■■");
		total = 0;
		permutation_NextPermutation2();
		System.out.println("개수 : " + total);

		System.out.println("■■■13. 조합 nCr : NextPermutation 사용 ■■■");
		total = 0;
		combination_NextPermutation();
		System.out.println("개수 : " + total);
// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

		System.out.println("■■■14. 부분집합 : 반복문 사용, 배열원소는 {1,2,3} ■■■");
		subSetLoop();

		System.out.println("■■■15. 부분집합 : 재귀 사용 ■■■");
		total = 0;
		subSet(0); 
		System.out.println("개수 : " + total);

//		System.out.println("■■■16. 부분집합 : BinaryCounting 사용 ■■■");
//		total = 0;
//		subSetBinaryCounting(0); 
//		System.out.println("개수 : " + total);

// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

		System.out.println("■■■17. 피보나치 N ■■■");
		System.out.println(N + "항 : " + fibo(N));
//		
//		System.out.println("■■■18. 하노이 재귀 N ■■■");
//		total = 0;
//		hanoi(N, 1, 2, 3);
//		System.out.println("회수 : " + total);
	} // end of main

	/** 사용할 데이터를 입력받아서 저장하는 메서드 */
	public static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("■■■ N, R, N개의 숫자배열을 입력해주세요 ■■■");
		System.out.print("N : ");
		N = sc.nextInt();
		System.out.print("R : ");
		R = sc.nextInt();

		System.out.println("N개의 숫자배열 : ");
		input = new int[N]; // 사용자 입력받은 숫자 배열
		numbers = new int[R]; // 순열에서 뽑은 숫자 담을 배열
		isSelected = new boolean[N]; // 사용한 숫자인지 체크할 플래그 배열
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt(); // 사용자 입력받은 숫자 배열
		}
	}

	/** 순열 3P3 : 반복문 사용, 배열원소는 {1,2,3} */
	public static void permutationLoop1() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i == j)
					continue;
				for (int k = 1; k <= 3; k++) {
					if (i == k || j == k)
						continue;
					sb.append(i).append(" ").append(j).append(" ").append(k).append("\n");
				}
			}
		}
		System.out.print(sb.toString());
	}

	/** 중복순열 3π3 : 반복문 사용, 배열원소는 {1,2,3} */
	public static void permutationLoop2() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				for (int k = 1; k <= 3; k++) {
					sb.append(i).append(" ").append(j).append(" ").append(k).append("\n");
				}
			}
		}
		System.out.print(sb.toString());
	}

	/**
	 * 순열 nPr: selected 배열사용, index 위치에 사용하지 않은 숫자를 하나씩 넣어보는 재귀함수 N, R : 사용자 입력받은
	 * 값(전역변수)
	 */
	public static void permutationSelected1(int index) {
		if (index == R) {
			System.out.println(Arrays.toString(numbers));
			total++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			numbers[index] = input[i];
			permutationSelected1(index + 1);
			isSelected[i] = false;
		}
	}

	/**
	 * 순열 nPr: selected 배열 대신 flag 비트마스킹 사용, index 위치에 사용하지 않은 숫자를 하나씩 넣어보는 재귀함수 N,
	 * R : 사용자 입력받은 값(전역변수)
	 */
	public static void permutationSelectedBitMaking(int index, int flag) {
		if (index == R) {
			System.out.println(Arrays.toString(numbers));
			total++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			numbers[index] = input[i];
			permutationSelectedBitMaking(index + 1, (flag | (1 << i)));
		}
	}

	/**
	 * 중복순열 nπr : selected 배열사용, index 위치에 사용하지 않은 숫자를 하나씩 넣어보는 재귀함수 N, R : 사용자 입력받은
	 * 값(전역변수)
	 */
	public static void permutationSelected2(int index) {
		if (index == R) {
			total++;
			return;
		}

		for (int i = 0; i < N; i++) {
			permutationSelected2(index + 1);
		}
	}

// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

	/** 조합 5C3 : 반복문 사용, 배열원소는 {1,2,3,4,5} */
	public static void combinationLoop1() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				for (int k = j + 1; k < 5; k++) {
					sb.append(input[i]).append(" ").append(input[j]).append(" ").append(input[k]).append("\n");
				}
			}
		}
		System.out.print(sb.toString());
	}

	/** 중복조합 5H3 : 반복문 사용, 배열원소는 {1,2,3,4,5} */
	public static void combinationLoop2() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 5; j++) {
				for (int k = j; k < 5; k++) {
					sb.append(input[i]).append(" ").append(input[j]).append(" ").append(input[k]).append("\n");
				}
			}
		}
		System.out.print(sb.toString());
	}

	/**
	 * 조합 : nCr = n-1Cr + n-1Cr-1 사용 N, R : 매개변수로 받음
	 */
	public static void combination1(int n, int r) {
		if (n == r || r == 0) {
			total++;
			return;
		}

		combination1(n - 1, r);
		combination1(n - 1, r - 1);
	}

	/**
	 * 조합 : nCr 다음 시작 위치 start 사용 N, R : 사용자 입력받은 값(전역변수)
	 */
	public static void combination2(int index, int start) {
		if (index == R) {
			total++;
			return;
		}

		for (int i = start; i < N; i++) {
			combination2(index + 1, i + 1);
		}
	}

	/**
	 * 중복조합 : nHr 다음 시작 위치 start 사용 N, R : 사용자 입력받은 값(전역변수)
	 */
	public static void combination3(int index, int start) {
		if (index == R) {
			total++;
			return;
		}

		for (int i = start; i < N; i++) {
			combination3(index + 1, i);
		}
	}

// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

	/** input 배열의 사전순 다음 순열을 만들어주는 메서드, 순열의 마지막이라 다음이 없으면 false / 있으면 true */
	public static boolean nextPermutation(int numbers[]) {
		// 뒤에서부터 꼭짓점 찾기
		int peak = numbers.length - 1;
		while (numbers[peak] <= numbers[peak - 1]) {
			peak--;
			if (peak == 0)
				return false;
		}

		// 꼭짓점 앞 값과 뒤에서부터 봤을때 꼭짓점보다 커지는 순간의 값 바꾸기
		int swapIdx = numbers.length - 1;
		while (numbers[peak - 1] >= numbers[swapIdx]) {
			swapIdx--;
		}

		swap(numbers, peak - 1, swapIdx);

		Arrays.sort(numbers, peak, numbers.length);

		return true;
	}

	/** numbers 배열의 i, j 인덱스 위치의 값을 교환 */
	public static void swap(int numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	/** 순열 nPn : NextPermutation 사용 */
	public static void permutation_NextPermutation1() {
		Arrays.sort(input);
		System.out.println(Arrays.toString(input));
		do {
			System.out.println(Arrays.toString(input));
		} while (nextPermutation(input));
	}

	/** 순열 nPr : NextPermutation 사용 */
	public static void permutation_NextPermutation2() {
		int[] p = new int[N];
		for(int i=0;i<N;i++) {
			p[i] = i;
		}

		Arrays.sort(input);
		do {
			for(int i=0;i<N;i++) {
				System.out.print(input[p[i]]+" ");
			}
			System.out.println();
			total++;
		} while(nextPermutation(p));
	}

	/** 조합 nCr : NextPermutation 사용 */
	public static void combination_NextPermutation() {
		int[] p = new int[N];
		for(int i=R;i<p.length;i++) {
			p[i] = 1;
		}
		
//		Arrays.sort(p);

		Arrays.sort(input);
		do {
			for(int i=0;i<p.length;i++) {
				if(p[i]==0) {
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
			total++;
		} while (nextPermutation(p));
	}

// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

	/** 부분집합 : 반복문 사용, 배열원소는 {1,2,3} */
	public static void subSetLoop() {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < 4; r++) {
			if(r==0) { // 공집합
				sb.append("\n");
				continue;
			}
			for (int i = 1; i <= 3; i++) {
				if (r == 1) {
					sb.append(i).append("\n");
					continue;
				}
				for (int j = i + 1; j <= 3; j++) {
					if (r == 2) {
						sb.append(i).append(" ").append(j).append("\n");
						continue;
					}
					for (int k = j + 1; k <= 3; k++) {
						sb.append(i).append(" ").append(j).append(" ").append(k).append("\n");
					}
				}
			}
		}
		System.out.print(sb.toString());
	}

	/** 부분집합 : 재귀 사용 */
	public static void subSet(int index) {
		if(total==0) { // 공집합
			total = 1;
		}
		
		if(index==N) {
			return;
		}
		
		for(int i=index;i<N;i++) {
			subSet(i+1);
			total++;
		}
	}

	/** 부분집합 : BinaryCounting 사용 */
	public static void subSetBinaryCounting() {
		
	}

// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

	/** 피보나치 n항을 계산하여 리턴 */
	public static long fibo(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibo(n-1)+fibo(n-2);
	}

	/** 원반갯수, 시작기둥, 임시기둥, 끝기둥 */
	private static void hanoi(int cnt, int from, int temp, int to) {
	}
} // end of class
