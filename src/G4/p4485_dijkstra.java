package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4485_dijkstra {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		int testCase = 1;
		
		while (true) {
			N = nextInt();
			if(N==0) break;
			sb.append("Problem ").append(testCase++).append(": ");
			arr = new int[N * N];
			for (int i = 0; i < N * N; i++) {
				arr[i] = nextInt();
			}
			dist = new int[N * N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			int[] offset = { -1, 1, -N, N };

			dist[0] = arr[0];

			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			pq.add(new int[] { 0, dist[0] });

			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int curNode = cur[0];
				int curWeight = cur[1];

				for (int d = 0; d < 4; d++) {
					if (curNode % N == 0 && d == 0)
						continue;
					if ((curNode + 1) % N == 0 && d == 1)
						continue;

					int nextNode = curNode + offset[d];
					if (nextNode < 0 || nextNode >= N * N)
						continue;

					if (curWeight + arr[nextNode] >= dist[nextNode])
						continue;

					dist[nextNode] = curWeight + arr[nextNode];
					pq.add(new int[] { nextNode, curWeight + arr[nextNode] });
				}
			}

			sb.append(dist[N * N - 1]).append("\n");
		}
		
		System.out.print(sb.toString());
	}

	static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}