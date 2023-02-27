package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//2668
public class p2668_그래프싸이클찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N, start;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> numsPicked;
	static PriorityQueue<Integer> answerList = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		visited = new boolean[N];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()) - 1;
		}

		for (; start < N; start++) {
			if (visited[start])
				continue;
			numsPicked = new ArrayList<>();
			numsPicked.add(start+1);
			visited[start] = true;
			dfs(arr[start]);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(answerList.size()).append("\n");
		while(!answerList.isEmpty()) {
			sb.append(answerList.poll()).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int cur) {
		if (cur == start) {
			for (int n : numsPicked) {
				answerList.offer(n);
			}
		}

		if (!visited[cur]) {
			numsPicked.add(cur+1);
			visited[cur] = true;
			dfs(arr[cur]);
			visited[cur] = false;
		}
	}
}