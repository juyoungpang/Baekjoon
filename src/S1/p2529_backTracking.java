package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2529_backTracking {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String input;
	static int k;
	static boolean found;

	public static void main(String[] args) throws IOException {
		k = Integer.parseInt(br.readLine()) + 1;
		input = br.readLine();

		
		for (int i = 9; i >= 0; i--) {
			if(found) break;
			move(i, 0, new StringBuilder(), new boolean[10], false);
		}

		found = false;
		for (int i = 0; i < 10; i++) {
			if(found) break;
			move(i, 0, new StringBuilder(), new boolean[10], true);
		}
		
	}

	public static void move(int start, int depth, StringBuilder sb, boolean[] visited, boolean increasing) {
		if (found) {
			return;
		}

		if (depth == k) {
			System.out.println(sb.toString());
			found = true;
			return;
		}
		
		boolean biggerThan = (depth!=k-1)?(input.charAt(depth*2) == '<' ? true : false):increasing;
		int i = start;

		while (i >= 0 && i < 10) {
			if (!visited[i]) {
				visited[i] = true;
				sb.append(i);
				move(biggerThan ? i + 1 : i - 1, depth+1, sb, visited, biggerThan);
				sb.setLength(sb.length() - 1);
				visited[i] = false;
			}

			i = increasing ? i + 1 : i - 1;
		}
		
	}
}