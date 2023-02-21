import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//2668
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N, start, answer;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> numsPicked, answerList = new ArrayList<>();

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

		System.out.println(answer);
	}

	public static void dfs(int cur) {
		if (cur == start) {
			answer+=numsPicked.size();
			for (int n : numsPicked) {
				answerList.add(n);
			}
		}

		if (visited[cur])
			return;

		numsPicked.add(cur+1);
		visited[cur] = true;
		dfs(arr[cur]);
	}
}