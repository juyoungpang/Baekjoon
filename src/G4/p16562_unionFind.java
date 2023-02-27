package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16562_unionFind {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] tree, cost;
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		N = nextInt();
		M = nextInt();
		K = nextInt();

		cost = new int[N];
		tree = new int[N];
		for (int i = 0; i < N; i++) {
			cost[i] = nextInt();
			tree[i] = i;
		}

		for (int m = 0; m < M; m++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;

			merge(a, b);
		}

		int totalCost = 0;
		for (int i = 0; i < N; i++) {
			if(tree[i]==i) { // 루트 노드일 경우
				totalCost+=cost[i];
			}
		}
		
		if(totalCost<=K) {
			System.out.println(totalCost);
		} else {
			System.out.println("Oh no");
		}
	}

	public static int findRoot(int node) {
		if (tree[node] == node) {
			return node;
		}

		return tree[node] = findRoot(tree[node]);
	}

	public static void merge(int node1, int node2) {
		int root1 = findRoot(node1);
		int root2 = findRoot(node2);

		if (root1 == root2) { // 이미 연결되어있음
			return;
		}

		if (cost[root1] > cost[root2]) {
			tree[root1] = root2;
		} else {
			tree[root2] = root1;
		}
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(st.nextToken());
	}
}