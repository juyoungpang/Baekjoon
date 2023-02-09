package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p1389_bfs {
	static int N, M, answer = Integer.MAX_VALUE, answerNode = -1;

	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());

		graph = new List[N];
		for(int i=0;i<N;i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			tok = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(tok.nextToken()) - 1;
			int b = Integer.parseInt(tok.nextToken()) - 1;

			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			int total = bfs(i);
			if(total<answer) {
				answer = total;
				answerNode = i+1;
			}
		}
		
		System.out.println(answerNode);

	}

	public static int bfs(int nodeNum) {
		int[] dist = new int[N];
		Arrays.fill(dist, -1);

		ArrayDeque<Integer> deck = new ArrayDeque<>();
		deck.add(nodeNum);
		dist[nodeNum] = 0;

		while (!deck.isEmpty()) {
			int node = deck.poll();

			for (int connectedNode : graph[node]) {
				if (dist[connectedNode] != -1)
					continue;

				dist[connectedNode] = dist[node] + 1;

				deck.add(connectedNode);
			}
		}

		int total = 0;
		for (int d : dist) {
			total += d;
		}
		return total;

	}
}