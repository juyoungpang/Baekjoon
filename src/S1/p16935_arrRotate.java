package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p16935_arrRotate {
	static List<Element> e = new ArrayList<>();
	static int N, M, R;
	static int[][] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		R = Integer.parseInt(tok.nextToken());

		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				e.add(new Element(i, j, Integer.parseInt(tok.nextToken())));
			}
		}

		tok = new StringTokenizer(br.readLine());
		while (R-- > 0) {
			switch (Integer.parseInt(tok.nextToken())) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}

		answer = new int[N][M];
		
		for (Element el : e) {
			answer[el.row][el.col] = el.val;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void one() {
		for (int i = 0; i < e.size(); i++) {
			int r = e.get(i).row;

			e.get(i).row = N - r - 1;
		}
	}

	public static void two() {
		for (int i = 0; i < e.size(); i++) {
			int c = e.get(i).col;

			e.get(i).col = M - c - 1;
		}
	}

	public static void three() {
		for (int i = 0; i < e.size(); i++) {
			int r = e.get(i).row;
			int c = e.get(i).col;

			e.get(i).row = c;
			e.get(i).col = N - r - 1;
		}

		int temp = N;
		N = M;
		M = temp;
	}

	public static void four() {
		for (int i = 0; i < e.size(); i++) {
			int r = e.get(i).row;
			int c = e.get(i).col;

			e.get(i).row = M - c - 1;
			e.get(i).col = r;
		}
		
		int temp = N;
		N = M;
		M = temp;
	}

	public static void five() {
		int oM = M / 2;
		int oN = N / 2;
		for (int i = 0; i < e.size(); i++) {
			int r = e.get(i).row;
			int c = e.get(i).col;

			if (r < oN && c < oM) {
				e.get(i).col = c + oM;
			} else if (r < oN && c >= oM) {
				e.get(i).row = r + oN;
			} else if (r >= oN && c >= oM) {
				e.get(i).col = c - oM;
			} else {
				e.get(i).row = r - oN;
			}
		}
	}
	
	public static void six() {
		int oM = M / 2;
		int oN = N / 2;
		for (int i = 0; i < e.size(); i++) {
			int r = e.get(i).row;
			int c = e.get(i).col;

			if (r < oN && c < oM) {
				e.get(i).row = r + oN;
			} else if (r < oN && c >= oM) {
				e.get(i).col = c - oM;
			} else if (r >= oN && c >= oM) {
				e.get(i).row = r - oN;
			} else {
				e.get(i).col = c + oM;
			}
		}
	}

}

class Element {
	int row;
	int col;
	int val;

	public Element(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}