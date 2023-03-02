import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 엥몇번문제여 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] population, connection;
	static int N, answer = Integer.MAX_VALUE, totalPopulation;

	public static void main(String[] args) throws IOException {
		N = nextInt();
		population = new int[N];
		connection = new int[N];

		for (int i = 0; i < N; i++) {
			population[i] = nextInt();
			totalPopulation += population[i];
		}

		for (int i = 0; i < N; i++) {
			int n = nextInt();
			int conn = 0;
			while (n-- > 0) {
				conn |= (1 << (nextInt() - 1));
			}
//			conn |= (1 << i);
			connection[i] = conn;
		}

		int chosen = 1;
		while (chosen < (1 << N) - 1) {
			p = 0;
			if (checkConnected(chosen)) {
				answer = Math.min(answer, Math.abs(p-(totalPopulation-p)));
			}

			chosen++;
		}
		
		if(answer==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	static int p;

	public static boolean checkConnected(int conn) {
		int flag1 = 0;
		int flag2 = 0;
		for (int i = 0; i < N; i++) {
			if ((conn & (1 << i)) != 0) {
				p += population[i];
				flag1 |= connection[i];
			} else {
				flag2 |= connection[i];
			}
		}
		
		return conn == (conn & flag1) && ((~conn)&((1<<N)-1)) == (~conn & flag2);
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}